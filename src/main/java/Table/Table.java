package Table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

/**
 * Created by Denis on 05.12.2016.
 */
public class Table {


    private SimpleStringProperty family;
    private SimpleIntegerProperty opinion_1;
    private SimpleIntegerProperty opinion_2;
    private SimpleIntegerProperty opinion_3;

    public Table(String family, Integer opinion_1, Integer opinion_2,Integer opinion_3){

        this.family = new SimpleStringProperty(family);
        this.opinion_1 = new SimpleIntegerProperty(opinion_1);
        this.opinion_2 = new SimpleIntegerProperty(opinion_2);
        this.opinion_3 = new SimpleIntegerProperty(opinion_3);
    }




    public String getFamily() {
        return family.get();
    }
    public void setFamily(String family){
        this.family.set(family);
    }

    public Integer getOpinion_2(){
        return opinion_2.get();
    }

    public Integer getOpinion_1(){
        return opinion_1.get();
    }
    public Integer getOpinion_3(){
        return opinion_3.get();
    }
}
