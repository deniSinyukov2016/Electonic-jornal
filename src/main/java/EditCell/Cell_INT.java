package EditCell;

import Table.Teacher;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Denis on 12.12.2016.
 */
public  class Cell_INT  extends TableCell<Teacher, String> {


    protected TextField textField;
    public    final ObservableList<String> ocenka = FXCollections.observableArrayList(
            "5", "4", "3", "2", "н");


    public Cell_INT() {
    }



//    @Override
//    public void startEdit() {
//        super.startEdit();
//        if (ocenka == null) {
//            createCBox();
//        }
//        setGraphic(ocenka);
//        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//
//                ocenka.requestFocus();
//            }
//        });
//    }

//    @Override
//    public void cancelEdit() {
//        super.cancelEdit();
//        setText(getItem());
//        setContentDisplay(ContentDisplay.TEXT_ONLY);
//        textField = null;
//    }

    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if(item != null){
            ComboBox cb = new ComboBox(ocenka);
            setGraphic(cb);
        }
        }
    }



//    private void createCBox() {
//        ocenka = new ComboBox<Object>();
//        ocenka.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
//        list.addAll("5","4","3","2","н");
//    }



