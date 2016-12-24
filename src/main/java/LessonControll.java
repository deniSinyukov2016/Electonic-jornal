import Connect.Connect;
import Table.Table;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import request.Request;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Created by Denis on 20.12.2016.
 */
public class LessonControll implements Initializable{

    @FXML
    private TextField les_tf;
    TableClassController tableClassController ;

    //-----------------------------------------------------------

    private  Connect con = new Connect();

    //-------------------------------------------------------

    public void on_add_lesson(ActionEvent actionEvent) {

        try(Connection connection  = con.connection()){
            try(PreparedStatement stmp = connection.prepareStatement(Request.addNewLesson)){
                String lessonText = les_tf.getText();
                les_tf.setAlignment(Pos.CENTER);
                if (lessonText.equals("") || lessonText.length() == 0){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Информационная информация");
                    alert.setHeaderText("Пустое поле");
                    alert.setContentText("Введите название предмета корректно!");
                }else {
                    stmp.setString(1, lessonText);
                    int k = stmp.executeUpdate();

                    System.out.println("Обновлено " + k);
                }

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
