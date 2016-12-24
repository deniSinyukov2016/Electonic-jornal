package EditCell;

import Connect.Connect;
import Table.Perfomance;
import Table.Teacher;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import request.Request;

import java.sql.*;

/**
 * Created by Denis on 30.11.2016.
 */
public class Cell_STR extends TableCell<Perfomance,String> {

    private TextField textField;
     Connect connect = new Connect();
    Connection con = connect.connection();

    public Cell_STR() {
    }

    @Override
    public void startEdit() {
        if (!isEmpty()) {
            super.startEdit();
            createTextField();
            setText(null);
            setGraphic(textField);
            textField.selectAll();
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText((String) getItem());
        setGraphic(null);
    }

    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());
                }
                setText(null);
                setGraphic(textField);
            } else {
                setText(getString());
                setGraphic(null);
            }
        }
    }

    private void createTextField() {
        textField = new TextField(getString());
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 3);

        //Обработка нажатия клавиш
        textField.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode key = event.getCode();
                if(key == KeyCode.ENTER){
                    try {
                        String str = textField.getText();
//                        Statement stmt = con.createStatement();
//                        ResultSet r = stmt.executeQuery("SELECT id  FROM teacher where family = "+str);
//                        int k = r.getInt("id");
//                        System.out.println(k);

                        if(str!=null){
                            PreparedStatement ps = con.prepareStatement("update teacher set family =? where id =?");
                            commitEdit(textField.getText());
                            ps.setString(1,str);
                            ps.setInt(2,1);

                            int rowCount = ps.executeUpdate();
                            System.out.println(rowCount);
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }else if(key == KeyCode.ESCAPE){
                    //отмена изменений
                    cancelEdit();
                }
            }
        });


    }

    private String getString() {
        return getItem() == null ? "" : getItem().toString();
    }
}





