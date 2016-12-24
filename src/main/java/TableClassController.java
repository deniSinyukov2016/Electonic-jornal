import Connect.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import request.Request;
import Table.Perfomance;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by Denis on 24.10.2016.
 */
public class TableClassController implements Initializable{




    ////////////////////////////////////////////////////////////////////


    @FXML
    private AnchorPane panelUp;

    @FXML
    private ComboBox<String> cbLetter;

    @FXML
    private ComboBox<String> cbLesson;

    @FXML
    private ComboBox<Integer> cbNumber;


    @FXML
    private ComboBox<String> cbFIO;

    @FXML
    private Button btnAply;

    @FXML
    private Tab tab_1;

    @FXML
    private AnchorPane tab_1_AnctorPane;

    @FXML
    private Button btnSave;

    @FXML
    private Button btn_boot_cancel;
    @FXML
    private ComboBox<String> cbMonth;

    @FXML
    private TextField tf_bottom_name;

    @FXML
    private TextField tf_bottom_fam;

    @FXML
    private DatePicker dp_bot_opin;

    @FXML
    private Button btn_bott_save;

    @FXML
    private TextField tf_bottom_opin;

    @FXML
    private AnchorPane panel_bott;



    //////////////////////////////////////////////////////////////////////////

    //Калас для установки соеденение с БД
    private Connect con;
    private Connection connection;
    private  Statement stmt;

    //Список для хранения обьектов
    private ObservableList<Test> data;
    private ObservableList<String> dataString;

    //Список для хранения букв класса
    private ObservableList<String> listLetter;

    //Список для хранения номера класса
    private ObservableList<Integer> listNumber;

    //Список для хранения фамилий студентов
    private ObservableList<String> listFioTeacher;
    private ObservableList<String> listLesson;
    private ObservableList<String> monthList;
    private  Load_Peromance load_peromance;
    ResultSet rs = null;

    private String selectedMonth;
    private String selectedLesson;
    private String selectedLetter;
    private Integer selectedNumber;
    private String selectedFIO;
    private String[] selectedFamily_Name;




    ////////////////////////////////////////////////////////////////













    //Вызывается перед началом работы

    public void initialize(URL location, ResourceBundle resources) {

        panel_bott.setVisible(false);
        Image imageOk = new Image(getClass().getResourceAsStream("img/cancel.png"));
        btn_boot_cancel.graphicProperty().setValue(new ImageView(imageOk));

            con = new Connect();


        //Установка соединения
        // Connection connect = con.connection();

        load_peromance = new Load_Peromance(tab_1_AnctorPane);


        //Создание списков
        listLetter = FXCollections.observableArrayList();
        listNumber = FXCollections.observableArrayList();
        listFioTeacher = FXCollections.observableArrayList();
        monthList = FXCollections.observableArrayList();
        monthList.addAll("Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь");

        listLesson = FXCollections.observableArrayList();



        try {
            connection = con.connection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(Request.UA_RUS);
            rs = stmt.executeQuery(Request.LETER_CLASS_NOT_REPETITION);
            //Добавление в список данных
            while (rs.next()) {
                getListLetter().add(rs.getString("leter_class"));
            }
            rs = stmt.executeQuery(Request.NUMBER_CLASS_NOT_REPETITION);
            while (rs.next()) {
                getListNumber().add(rs.getInt("number_class"));
            }
            rs = stmt.executeQuery(Request.ALL_TEACHER);
            while (rs.next()) {
                listFioTeacher.add(rs.getString("family") + " " + rs.getString("name"));
            }
            rs = stmt.executeQuery(Request.ALL_LESSON);
            while (rs.next()) {
                listLesson.add(rs.getString("title"));
            }
            //Установление данных в визуальные объекты
            cbLetter.setItems(getListLetter());
            cbNumber.setItems(getListNumber());
            cbFIO.setItems(listFioTeacher);
            cbMonth.setItems(monthList);
            cbLesson.setItems(listLesson);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    System.out.println("ResultSet close");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (stmt != null) {
                    try {
                        stmt.close();
                        System.out.println("Statment close");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if(connection!=null){
                    try {
                        connection.close();
                        System.out.println("connection close");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }


    }







    public void OnAply(ActionEvent actionEvent) {
        btnAply.setText("Обновить");
        panel_bott.setVisible(true);

         selectedMonth = cbMonth.getSelectionModel().getSelectedItem();
         selectedLesson = cbLesson.getSelectionModel().getSelectedItem();
         selectedLetter = cbLetter.getSelectionModel().getSelectedItem();
         selectedNumber = cbNumber.getSelectionModel().getSelectedItem();
         selectedFIO = cbFIO.getSelectionModel().getSelectedItem();
         selectedFamily_Name = getSelectedFIO().trim().split("\\s+");

        //Определение кол-ва дней
        int day_count = getNumberMonth(getSelectedMonth());

        ObservableList<Perfomance> dataPefromance = FXCollections.observableArrayList();

        //Создание таблицы выборки
        load_peromance.createPerfomanceTable(day_count,this);

        load_peromance.getMonthColumn().setText(getSelectedMonth());
        load_peromance.getLessonColumn().setText(getSelectedLesson());
        int k = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection c= null;
        Statement statement = null;

        try {
             c = con.connection();
            statement = c.createStatement();
            rs = statement.executeQuery(Request.UA_RUS);

            ps = c.prepareStatement(Request.PERFOMANCE_REQUERY);
            ps.setString(1, getSelectedMonth());
            ps.setString(2, getSelectedLesson());
            ps.setString(3, getSelectedFamily_Name(0));
            ps.setString(4, getSelectedLetter());
            ps.setInt(5, getSelectedNumber());
            rs = ps.executeQuery();

            while (rs.next()) {
                dataPefromance.add(new Perfomance(k++, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                        rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16),
                        rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22),
                        rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27), rs.getString(28),
                        rs.getString(29), rs.getString(30), rs.getString(31), rs.getString(32),rs.getString(33)));
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                    System.out.println("rs close");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                    System.out.println("statement close");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (c != null) {
                try {
                    c.close();
                    System.out.println("Connection2 close");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        //Установка данных в таблицу
        load_peromance.getPerfomanceTableView().setItems(dataPefromance);


    }







    private int getNumberMonth(String montn){
        switch (montn){
            case "Январь": return 31;
            case "Февраль": return 28;
            case "Март": return 31;
            case "Апрель": return 30;
            case "Май": return 31;
            case "Июнь": return 30;
            case "Июль": return 31;
            case "Август": return 31;
            case "Сентябрь": return 30;
            case "Октябрь": return 31;
            case "Ноябрь": return 30;
            case "Декабрь": return 31;
            default:return 31;
        }
    }


    public TextField getTf_bottom_fam() {
        return tf_bottom_fam;
    }

    public void setTf_bottom_fam(TextField tf_bottom_fam) {
        this.tf_bottom_fam = tf_bottom_fam;
    }

    public TextField getTf_bottom_name() {
        return tf_bottom_name;
    }

    public DatePicker getDp_bot_opin() {
        return dp_bot_opin;
    }

    public void setDp_bot_opin(DatePicker dp_bot_opin) {
        this.dp_bot_opin = dp_bot_opin;
    }

    public Button getBtn_bott_save() {
        return btn_bott_save;
    }

    public void setBtn_bott_save(Button btn_bott_save) {
        this.btn_bott_save = btn_bott_save;
    }

    public TextField getTf_bottom_opin() {
        return tf_bottom_opin;
    }

    public void setTf_bottom_opin(TextField tf_bottom_opin) {
        this.tf_bottom_opin = tf_bottom_opin;
    }

    public String getSelectedMonth() {
        return selectedMonth;
    }

    public String getSelectedLesson() {
        return selectedLesson;
    }

    public String getSelectedLetter() {
        return selectedLetter;
    }

    public Integer getSelectedNumber() {
        return selectedNumber;
    }

    public String getSelectedFIO() {
        return selectedFIO;
    }

    public String getSelectedFamily_Name(int n) {
        return selectedFamily_Name[n];
    }

    public void clearPar(ActionEvent actionEvent) {
        tf_bottom_fam.clear();
        tf_bottom_name.clear();
        dp_bot_opin.getEditor().clear();
        tf_bottom_opin.clear();
    }

    public void onAdd_Schoolboy(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("View/School_View.fxml"));
            AnchorPane anchorPane = loader.load();
            Scene scene = new Scene(anchorPane);
            Stage stage = new Stage();
            stage.setTitle("Добавление нового ученика");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void onAdd_teacher(MouseEvent mouseEvent) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("View/Teacher_View.fxml"));
            AnchorPane anchorPane = loader.load();
            Scene scene = new Scene(anchorPane);
            stage = new Stage();
            stage.setTitle("Добавление нового учителя");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private  Stage stage;

    public void onAdd_lesson(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("View/Lesson_View.fxml"));
            AnchorPane anchorPane = loader.load();
            Scene scene = new Scene(anchorPane);
            Stage stage = new Stage();
            stage.setTitle("Добавление нового предмета");
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  Stage getStage(){
        return stage;
    }

    public ObservableList<String> getListLetter() {
        return listLetter;
    }

    public ObservableList<Integer> getListNumber() {
        return listNumber;
    }
}