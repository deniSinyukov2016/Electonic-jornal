package Table;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by Denis on 06.12.2016.
 */
public class Opinion_table {

    private IntegerProperty opinion;

    public Opinion_table(Integer opinion){
        this.opinion = new SimpleIntegerProperty(opinion);
    }

    public Integer getOpinion(){
        return opinion.get();
    }
}
