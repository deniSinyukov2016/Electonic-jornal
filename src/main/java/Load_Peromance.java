import Connect.Connect;
import EditCell.Cell_STR;
import Table.Perfomance;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import request.Request;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Denis on 17.12.2016.
 */
public class Load_Peromance {

    //Панель (главная)
    private AnchorPane tab_1_AnctorPane;

    public Load_Peromance(AnchorPane tab_1_AnctorPane){
        this.tab_1_AnctorPane = tab_1_AnctorPane;
    }



    //Таблица
    private TableView<Perfomance> perfomanceTableView;

    //Колонки
    private TableColumn<Perfomance, Integer> countColumn;
    private TableColumn<Perfomance, String> familyColumn;
    private TableColumn<Perfomance, String> nameColumn;
    private TableColumn<Perfomance, String> oneColumn;
    private TableColumn<Perfomance, String> twoColumn;
    private TableColumn<Perfomance, String> threeColumn;
    private TableColumn<Perfomance, String> fourColumn;
    private TableColumn<Perfomance, String> fiveColumn;
    private TableColumn<Perfomance, String> sixColumn;
    private TableColumn<Perfomance, String> sevenColumn;
    private TableColumn<Perfomance, String> eightColumn;
    private TableColumn<Perfomance, String> nineColumn;
    private TableColumn<Perfomance, String> tenColumn;
    private TableColumn<Perfomance, String> elevenColumn;
    private TableColumn<Perfomance, String> twelveColumn;
    private TableColumn<Perfomance, String> thirteenColumn;
    private TableColumn<Perfomance, String> fourteenColumn;
    private TableColumn<Perfomance, String> fifteenColumn;
    private TableColumn<Perfomance, String> sixteenColumn;
    private TableColumn<Perfomance, String> seventeenColumn;
    private TableColumn<Perfomance, String> eighteenColumn;
    private TableColumn<Perfomance, String> nineteenColumn;
    private TableColumn<Perfomance, String> twentyColumn;
    private TableColumn<Perfomance, String> twentyОneColumn;
    private TableColumn<Perfomance, String> twentyTwoColumn;
    private TableColumn<Perfomance, String> twentyThreeColumn;
    private TableColumn<Perfomance, String> twentyFourColumn;
    private TableColumn<Perfomance, String> twentyFiveColumn;
    private TableColumn<Perfomance, String> twentySixColumn;
    private TableColumn<Perfomance, String> twentySevenColumn;
    private TableColumn<Perfomance, String> twentyEightColumn;
    private TableColumn<Perfomance, String> twentyNineColumn;
    private TableColumn<Perfomance, String> thirtyColumn;
    private TableColumn<Perfomance, String> thirtyOneColumn;
    private TableColumn<Perfomance,String> monthColumn;
    private TableColumn<Perfomance,String> lessonColumn;
    //----------------------------------------------------------------------
    private String selectDate = null;
    int inputOpinion;
    private String family_schoolboy = null;
    private String name_schoolboy = null;
    LocalDate localDate = null;

    //Ссылка на контроллер
    private  TableClassController tableClassController ;

    public void createPerfomanceTable(int day,TableClassController tableClassController){
        this.tableClassController = tableClassController;
        perfomanceTableView = new TableView<Perfomance>();
        perfomanceTableView.setEditable(true);

        tableClassController.getTf_bottom_opin().setAlignment(Pos.CENTER);


        //Обработчик нажатия мыши на выделенную строку таблицы
        perfomanceTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Perfomance selectedItem = getPerfomanceTableView().getSelectionModel().getSelectedItem();
                if(selectedItem!=null) {
                    tableClassController.getTf_bottom_fam().setAlignment(Pos.CENTER);
                    family_schoolboy = selectedItem.getFamily();
                    name_schoolboy = selectedItem.getName();
                    tableClassController.getTf_bottom_fam().setText(family_schoolboy);

                    tableClassController.getTf_bottom_name().setText(selectedItem.getName());
                    tableClassController.getTf_bottom_name().setAlignment(Pos.CENTER);

                }
            }
        });


        tableClassController.getDp_bot_opin().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 localDate = tableClassController.getDp_bot_opin().getValue();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                selectDate = localDate.format(dateTimeFormatter);
            }
        });

        tableClassController.getBtn_bott_save().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Connection connection = null;
                Connect connect = new Connect();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = date = Date.valueOf(localDate);

                try(Connection connection =connect.connection() ){
                    try(PreparedStatement preparedStatement1 = connection.prepareStatement(Request.UPDATE_OPINION)){
                        preparedStatement1.setString(1,family_schoolboy);
                        preparedStatement1.setString(2,name_schoolboy);
                        preparedStatement1.setInt(3,getInputOpinion());
                        preparedStatement1.setString(4,tableClassController.getSelectedFamily_Name(0));
                        preparedStatement1.setString(5,tableClassController.getSelectedLesson());
                        preparedStatement1.setDate(6,date);
                       int countUpdate =  preparedStatement1.executeUpdate();
                        System.out.println(countUpdate);
                        tableClassController.OnAply(new ActionEvent());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


        //addTextLimiter(tableClassController.getTf_bottom_opin(),2);


        //Создание колонок
        setCountColumn(new TableColumn<Perfomance,Integer>("№"));
        getCountColumn().setCellValueFactory(new PropertyValueFactory<Perfomance, Integer>("count"));

        setFamilyColumn(new TableColumn<Perfomance,String>("Фамилия"));
        getFamilyColumn().setCellValueFactory(new PropertyValueFactory<Perfomance, String>("family"));

        nameColumn = new TableColumn<Perfomance,String>("Имя");
        nameColumn.setCellValueFactory(new PropertyValueFactory<Perfomance, String>("name"));

        oneColumn = new TableColumn<Perfomance,String>("1");
        oneColumn.setCellValueFactory(new PropertyValueFactory<Perfomance, String>("one"));

//        oneColumn.setEditable(true);
//        oneColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        twoColumn = new TableColumn<Perfomance,String>("2");
        twoColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("two"));
//        twoColumn.setEditable(true);
//        twoColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        threeColumn = new TableColumn<Perfomance,String>("3");
        threeColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("three"));
//        threeColumn.setEditable(true);
//        threeColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        fourColumn = new TableColumn<Perfomance,String>("4");
        fourColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("four"));
//        fourColumn.setEditable(true);
//        fourColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        fiveColumn = new TableColumn<Perfomance,String>("5");
        fiveColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("five"));
//        fiveColumn.setEditable(true);
//        fiveColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        sixColumn = new TableColumn<Perfomance,String>("6");
        sixColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("six"));
//        sixColumn.setEditable(true);
//        sixColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        sevenColumn = new TableColumn<Perfomance,String>("7");
        sevenColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("seven"));
//        sevenColumn.setEditable(true);
//        sevenColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        eightColumn = new TableColumn<Perfomance,String>("8");
        eightColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("eight"));
//        eightColumn.setEditable(true);
//        eightColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        nineColumn = new TableColumn<Perfomance,String>("9");
        nineColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("nine"));
//        nineColumn.setEditable(true);
//        nineColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        tenColumn = new TableColumn<Perfomance,String>("10");
        tenColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("ten"));
//        tenColumn.setEditable(true);
//        tenColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        elevenColumn = new TableColumn<Perfomance,String>("11");
        elevenColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("eleven"));
//        elevenColumn.setEditable(true);
//        elevenColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        twelveColumn = new TableColumn<Perfomance,String>("12");
        twelveColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("twelve"));
//        twelveColumn.setEditable(true);
//        twelveColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        thirteenColumn = new TableColumn<Perfomance,String>("13");
        thirteenColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("thirteen"));
//        thirteenColumn.setEditable(true);
//        thirteenColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        fourteenColumn = new TableColumn<Perfomance,String>("14");
        fourteenColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("fourteen"));
//        fourteenColumn.setEditable(true);
//        fourteenColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        fifteenColumn = new TableColumn<Perfomance,String>("15");
        fifteenColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("fifteen"));
//        fifteenColumn.setEditable(true);
//        fifteenColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        sixteenColumn = new TableColumn<Perfomance,String>("16");
        sixteenColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("sixteen"));
//        sixteenColumn.setEditable(true);
//        sixteenColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        seventeenColumn = new TableColumn<Perfomance,String>("17");
        seventeenColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("seventeen"));
//        seventeenColumn.setEditable(true);
//        seventeenColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        eighteenColumn = new TableColumn<Perfomance,String>("18");
        eighteenColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("eighteen"));
//        eighteenColumn.setEditable(true);
//        eighteenColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        nineteenColumn = new TableColumn<Perfomance,String>("19");
        nineteenColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("nineteen"));
//        nineteenColumn.setEditable(true);
//        nineteenColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        twentyColumn = new TableColumn<Perfomance,String>("20");
        twentyColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("twenty"));
//        twentyColumn.setEditable(true);
//        twentyColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        twentyОneColumn = new TableColumn<Perfomance,String>("21");
        twentyОneColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("twentyОne"));
//        twentyОneColumn.setEditable(true);
//        twentyОneColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        twentyTwoColumn = new TableColumn<Perfomance,String>("22");
        twentyTwoColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("twentyTwo"));
//        twentyTwoColumn.setEditable(true);
//        twentyTwoColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        twentyThreeColumn = new TableColumn<Perfomance,String>("23");
        twentyThreeColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("twentyTree"));
//        twentyThreeColumn.setEditable(true);
//        twentyThreeColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        twentyFourColumn = new TableColumn<Perfomance,String>("24");
        twentyFourColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("twentyFour"));
//        twentyFourColumn.setEditable(true);
//        twentyFourColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        twentyFiveColumn = new TableColumn<Perfomance,String>("25");
        twentyFiveColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("twentyFive"));
//        twentyFiveColumn.setEditable(true);
//        twentyFiveColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        twentySixColumn = new TableColumn<Perfomance,String>("26");
        twentySixColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("twentySix"));
//        twentySixColumn.setEditable(true);
//        twentySixColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        twentySevenColumn = new TableColumn<Perfomance,String>("27");
        twentySevenColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("twentySeven"));
//        twentySevenColumn.setEditable(true);
//        twentySevenColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        twentyEightColumn = new TableColumn<Perfomance,String>("28");
        twentyEightColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("twentyEight"));
//        twentyEightColumn.setEditable(true);
//        twentyEightColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        twentyNineColumn = new TableColumn<Perfomance,String>("29");
        twentyNineColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("twentyNine"));
//        twentyNineColumn.setEditable(true);
//        twentyNineColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        thirtyColumn = new TableColumn<Perfomance,String>("30");
        thirtyColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("thirty"));
//        thirtyColumn.setEditable(true);
//        thirtyColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        thirtyOneColumn = new TableColumn<Perfomance,String>("31");
        thirtyOneColumn.setCellValueFactory(new PropertyValueFactory<Perfomance,String>("thirtyOne"));
//        thirtyOneColumn.setEditable(true);
//        thirtyOneColumn.setCellFactory(new Callback<TableColumn<Perfomance, String>, TableCell<Perfomance, String>>() {
//            @Override
//            public TableCell<Perfomance, String> call(TableColumn<Perfomance, String> param) {
//                return new Cell_STR();
//            }
//        });

        monthColumn = new TableColumn<Perfomance,String>("Месяц");
        lessonColumn = new TableColumn<Perfomance,String>("Дисциплина");
        lessonColumn.setStyle("");
        monthColumn.getColumns().add(lessonColumn);

        if(day == 31){
            lessonColumn.getColumns().addAll(oneColumn,twoColumn,threeColumn,fourColumn,fiveColumn,
                    sixColumn,sevenColumn,eightColumn,nineColumn,tenColumn,elevenColumn,twelveColumn,thirteenColumn,fourteenColumn,
                    fifteenColumn,sixteenColumn,seventeenColumn,eighteenColumn,nineteenColumn,twentyColumn,twentyОneColumn,twentyTwoColumn,
                    twentyThreeColumn,twentyFourColumn,twentyFiveColumn,twentySixColumn,twentySevenColumn,twentyEightColumn,twentyNineColumn,
                    thirtyColumn,thirtyOneColumn);
        }else if (day == 30){
            lessonColumn.getColumns().addAll(oneColumn,twoColumn,threeColumn,fourColumn,fiveColumn,
                    sixColumn,sevenColumn,eightColumn,nineColumn,tenColumn,elevenColumn,twelveColumn,thirteenColumn,fourteenColumn,
                    fifteenColumn,sixteenColumn,seventeenColumn,eighteenColumn,nineteenColumn,twentyColumn,twentyОneColumn,twentyTwoColumn,
                    twentyThreeColumn,twentyFourColumn,twentyFiveColumn,twentySixColumn,twentySevenColumn,twentyEightColumn,twentyNineColumn,
                    thirtyColumn);
        }else if (day == 29){
            lessonColumn.getColumns().addAll(oneColumn,twoColumn,threeColumn,fourColumn,fiveColumn,
                    sixColumn,sevenColumn,eightColumn,nineColumn,tenColumn,elevenColumn,twelveColumn,thirteenColumn,fourteenColumn,
                    fifteenColumn,sixteenColumn,seventeenColumn,eighteenColumn,nineteenColumn,twentyColumn,twentyОneColumn,twentyTwoColumn,
                    twentyThreeColumn,twentyFourColumn,twentyFiveColumn,twentySixColumn,twentySevenColumn,twentyEightColumn,twentyNineColumn);
        }else if (day == 28){
            lessonColumn.getColumns().addAll(oneColumn,twoColumn,threeColumn,fourColumn,fiveColumn,
                    sixColumn,sevenColumn,eightColumn,nineColumn,tenColumn,elevenColumn,twelveColumn,thirteenColumn,fourteenColumn,
                    fifteenColumn,sixteenColumn,seventeenColumn,eighteenColumn,nineteenColumn,twentyColumn,twentyОneColumn,twentyTwoColumn,
                    twentyThreeColumn,twentyFourColumn,twentyFiveColumn,twentySixColumn,twentySevenColumn,twentyEightColumn);
        }



        //Добавление колонок в таблицу
        perfomanceTableView.getColumns().addAll( countColumn,familyColumn,nameColumn,monthColumn);

        //Добавление таблицы на панель
        tab_1_AnctorPane.getChildren().add(perfomanceTableView);

        //Привязка в сторонам панели
        tab_1_AnctorPane.setTopAnchor(perfomanceTableView,14.0);
        tab_1_AnctorPane.setRightAnchor(perfomanceTableView,14.0);
        tab_1_AnctorPane.setLeftAnchor(perfomanceTableView,14.0);
        tab_1_AnctorPane.setBottomAnchor(perfomanceTableView,20.0);
    }

    public TableView<Perfomance> getPerfomanceTableView(){
        return perfomanceTableView;
    }

    public TableColumn<Perfomance, Integer> getCountColumn() {
        return countColumn;
    }

    public void setCountColumn(TableColumn<Perfomance, Integer> countColumn) {
        this.countColumn = countColumn;
    }

    public TableColumn<Perfomance, String> getFamilyColumn() {
        return familyColumn;
    }

    public void setFamilyColumn(TableColumn<Perfomance, String> familyColumn) {
        this.familyColumn = familyColumn;
    }

    public TableColumn<Perfomance, String> getLessonColumn() {
        return lessonColumn;
    }

    public TableColumn<Perfomance, String> getMonthColumn() {
        return monthColumn;
    }
    public TableColumn<Perfomance, String> getOneColumn() {
        return oneColumn;
    }
    public TableColumn<Perfomance, String> getTwoColumn() {
        return twoColumn;
    }

    public String getSelectDate (){
        return selectDate;
    }

    public int getInputOpinion(){
        return  inputOpinion = Integer.parseInt(tableClassController.getTf_bottom_opin().getText());
    }

    public static void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }
}

