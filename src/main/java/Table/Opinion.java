package Table;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by Denis on 26.11.2016.
 */
public class Opinion {
    private SimpleIntegerProperty title;

    public Opinion(int title){
        this.title = new SimpleIntegerProperty(title);
    }

    public int getTitle(){
        return title.get();
    }
    public IntegerProperty getTitle2(){
        return title;
    }
}
