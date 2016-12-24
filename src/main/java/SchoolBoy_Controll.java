import Connect.Connect;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import request.Request;

import java.net.URL;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Created by Denis on 20.12.2016.
 */
public class SchoolBoy_Controll implements Initializable {

    @FXML
    private ComboBox<Integer> cb_number_class;

    @FXML
    private TextField tf_family;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_Number;

    @FXML
    private TextField tf_letter;

    @FXML
    private ComboBox<String> cb_sex;

    @FXML
    private ComboBox<String> cb_letter_class;

    @FXML
    private TextField tf_patronomic;

    @FXML
    private DatePicker dp_birth;

    //-----------------------------------
    private Connect con = new Connect();
    private  TableClassController tableClassController;
    private ObservableList<String> listLetter = FXCollections.observableArrayList();
    private ObservableList<Integer> listNumber = FXCollections.observableArrayList();
    private ObservableList<String> listSex = FXCollections.observableArrayList();

    private  ComboBox<String> comboBox = new ComboBox<String>();
    private  ComboBox<Integer> comboBoxNum = new ComboBox<Integer>();



    @FXML
    void on_AddNewSchoolBoy(ActionEvent event) {
//        int selectedLetter = cb_letter_class.getSelectionModel().getSelectedIndex();
//        String selectLetter = cb_letter_class.getSelectionModel().getSelectedItem();

        int selectedSEx = cb_sex.getSelectionModel().getSelectedIndex();
        String selectSex = cb_sex.getSelectionModel().getSelectedItem();

//        int selectedNumber = cb_number_class.getSelectionModel().getSelectedIndex();
//        int selectNumber = cb_number_class.getSelectionModel().getSelectedItem();

        String selLetter = tf_letter.getText();
        int selNum = Integer.parseInt(tf_Number.getText());

        String selectFamily = tf_family.getText();
        String selectName = tf_name.getText();
        String selectPatronomic = tf_patronomic.getText();
        LocalDate localDate = dp_birth.getValue();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date  = Date.valueOf(localDate);
        boolean flag = false;
        boolean flagNum = false;

        for (int i = 0; i <listLetter.size() ; i++) {
            if (listLetter.get(i).equals(selLetter)){
                flag = true;
            }
        }

        for (int i = 0; i <listNumber.size() ; i++) {
            if (listNumber.get(i).equals(selNum)){
                flagNum = true;
            }
        }
        try(Connection connection = con.connection()){

            if (!flag || !flagNum) {
                try (PreparedStatement ps = connection.prepareStatement(Request.addNewClass)) {
                    ps.setString(1, selLetter);
                    ps.setInt(2, selNum);
                    ps.executeUpdate();
                    ps.clearParameters();
                    try (PreparedStatement preparedStatement = connection.prepareStatement(Request.addNewSchoolboy)) {
                        if (selectedSEx != -1) {
                            preparedStatement.setString(1, selLetter);
                            preparedStatement.setInt(2, selNum);
                            preparedStatement.setString(3, selectSex);
                            preparedStatement.setString(4, selectFamily);
                            preparedStatement.setString(5, selectName);
                            preparedStatement.setString(6, selectPatronomic);
                            preparedStatement.setDate(7, date);
                            preparedStatement.executeUpdate();
                        }
                    }
                }
            }else {
                try (PreparedStatement preparedStatement = connection.prepareStatement(Request.addNewSchoolboy)) {
                    
                    if (selectedSEx != -1) {
                        preparedStatement.setString(1, selLetter);
                        preparedStatement.setInt(2, selNum);
                        preparedStatement.setString(3, selectSex);
                        preparedStatement.setString(4, selectFamily);
                        preparedStatement.setString(5, selectName);
                        preparedStatement.setString(6, selectPatronomic);
                        preparedStatement.setDate(7, date);
                        preparedStatement.executeUpdate();
                    }
                   // tf_letter.clear();
//                    tf_Number.clear();
//                    tf_patronomic.clear();
//                    tf_name.clear();
//                    tf_family.clear();
//                    dp_birth.getEditor().clear();
//                    cb_sex.getEditor().clear();
                }

            }
        }catch (SQLException e){
            e.printStackTrace();
        }



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        tableClassController = new TableClassController();
//        cb_letter_class.setItems(tableClassController.getListLetter());
        listSex.addAll("мужчина","девушка");
        tf_letter.setAlignment(Pos.CENTER);
        addTextLimiter(tf_letter,1);
        tf_Number.setAlignment(Pos.CENTER);
        addTextLimiter(tf_Number,1);

        try(Connection connection  = con.connection()){
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(Request.LETER_CLASS_NOT_REPETITION)){
                    while (resultSet.next()){
                        listLetter.add(resultSet.getString("leter_class"));
                    }
                try(ResultSet resultSet1 = statement.executeQuery(Request.NUMBER_CLASS_NOT_REPETITION)){
                    while (resultSet1.next()){
                        listNumber.add(resultSet1.getInt("number_class"));
                    }
                }
                    //Добавление выборок в Comboxs
                    comboBox.setItems(listLetter);
                    comboBoxNum.setItems(listNumber);
                    cb_sex.setItems(listSex);

                }

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                String text = tf.getText();
                if (text.length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }
}
