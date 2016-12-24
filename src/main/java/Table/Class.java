package Table;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Denis on 24.10.2016.
 */
public class Class {

    private final StringProperty leterClass;
    private final IntegerProperty numClass;

    public Class (String leterClass, int numClass){
        this.leterClass =  new SimpleStringProperty(leterClass);
        this.numClass = new SimpleIntegerProperty(numClass);
    }


    public String getLeterClass() {
        return leterClass.get();
    }

    public IntegerProperty getNumClass() {
        return numClass;
    }

    public void setLeterClass(String value){
        leterClass.set(value);
    }
    public void setNumClass(int value){
        numClass.set(value);
    }

    public IntegerProperty numClassProperty() {
        return numClass;
    }

    public StringProperty leterClassProperty() {
        return leterClass;
    }
}
