import Connect.Connect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import request.Request;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Denis on 20.12.2016.
 */
public class Teacher_controller implements Initializable {



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_fam;

    @FXML
    private TextField tf_patr;

    @FXML
    private TextArea tf_post;
    //---------------------------------------------------

    private Connect con = new Connect();

    @FXML
    void on_addTeacher(ActionEvent event) {
        String selectFam = tf_fam.getText();
        String selectName = tf_name.getText();
        String selectPatr = tf_patr.getText();
        String selectPost = tf_post.getText();

        try(Connection connection = con.connection()){
            try(PreparedStatement ps = connection.prepareStatement(Request.addNewTeacher)){
                if ((!selectFam.equals("")) && (!selectName.equals("")) && (!selectPatr.equals("")) && (!selectPost.equals(""))){
                    ps.setString(1,selectFam);
                    ps.setString(2,selectName);
                    ps.setString(3,selectPatr);
                    ps.setString(4,selectPost);
                   int k =  ps.executeUpdate();
                    System.out.println("Обновлено "+k);
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Информационное окно");
                    alert.setHeaderText("Не все поля заполнены!");
                    alert.setContentText("Для успешного внесения нового учителя зполните все поля! ");
                    alert.show();


                }
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

}
