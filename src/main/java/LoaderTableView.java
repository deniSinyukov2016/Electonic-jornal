import EditCell.Cell_INT;
import EditCell.Cell_STR;
import Table.Teacher;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;

/**
 * Created by Denis on 20.11.2016.
 */
public class LoaderTableView {

    private AnchorPane tab_1_AnctorPane;



    public LoaderTableView(AnchorPane tab_1_AnctorPane){
        this.tab_1_AnctorPane = tab_1_AnctorPane;

    }
    StringConverter<Integer> sc = new StringConverter<Integer>() {
        @Override
        public String toString(Integer t) {
            return t == null ? null : t.toString();
        }

        @Override
        public Integer fromString(String string) {
            return Integer.parseInt(string);
        }
    };



    TableView<Teacher> table;
    private TableColumn<Teacher,String> family;
    TableColumn<Teacher,String> name;
    TableColumn<Teacher,String> patronomic;
    TableColumn<Teacher,String> post;
    public void table_Teacher(){
        table = new TableView<Teacher>();
        table.setEditable(true);

        family = new TableColumn<Teacher, String>("Фамилия");
        name = new TableColumn<Teacher, String>("Имя");
         patronomic = new TableColumn<Teacher, String>("Отчество");
         post = new TableColumn<Teacher, String>("Должность");

        family.setEditable(true);
        name.setEditable(true);
        patronomic.setEditable(true);
        post.setEditable(true);
//        family.setCellFactory(new Callback<TableColumn<Teacher, String>, TableCell<Teacher, String>>() {
//            @Override
//            public TableCell<Teacher, String> call(TableColumn<Teacher, String> param) {
//                //return new Cell_STR();
//            }
//        });
        //family.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), FXCollections.observableArrayList("1", "2", "3")));
        family.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Teacher, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setFamily(event.getNewValue());
            }
        });



        table.getColumns().addAll(family,name,patronomic,post);
        tab_1_AnctorPane.getChildren().add(table);
        tab_1_AnctorPane.setTopAnchor(table,14.0);
        tab_1_AnctorPane.setRightAnchor(table,14.0);
        tab_1_AnctorPane.setLeftAnchor(table,14.0);
    }



    public TableColumn<Teacher, String> get_family() {
        return family;
    }
    public TableColumn<Teacher, String> get_name() {
        return name;
    }
    public TableColumn<Teacher, String> get_patr() {
        return patronomic;
    }
    public TableColumn<Teacher, String> get_post() {
        return post;
    }





}
