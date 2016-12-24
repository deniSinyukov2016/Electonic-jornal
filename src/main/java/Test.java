import com.sun.corba.se.impl.logging.ORBUtilSystemException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Denis on 26.11.2016.
 */
public class Test {



    private StringProperty family;
    private IntegerProperty opinion;




    public Test(String family, Integer opinion) {

        this.family = new SimpleStringProperty(family);
        this.opinion = new SimpleIntegerProperty(opinion);
    }


    public StringProperty getFamily_p() {
        return family;
    }

    public IntegerProperty getOpinion_p() {
        return opinion;
    }


    public String getFamily() {
        return family.get();
    }

    public Integer getOpinion() {
        return opinion.get();
    }


//    public void setFamily_p(StringProperty family) {
//        this.family = family;
//    }
    public void setOpinion_p(IntegerProperty opinion) {
        this.opinion = opinion;
    }

    public void setFamily(String family) {
        this.family.set(family);
    }

    public void setOpinion(Integer opinion) {
        this.opinion.set(opinion);
    }


}


