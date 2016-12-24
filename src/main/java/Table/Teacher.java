package Table;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Denis on 08.11.2016.
 */
public class Teacher {

    //private final SimpleIntegerProperty id;
    private final SimpleStringProperty  family;
    private final SimpleStringProperty  name;
    private final SimpleStringProperty  patronomic;
    private final SimpleStringProperty  post;

    public Teacher( String family, String name, String patronomic, String post){
        this.family = new SimpleStringProperty(family);
        this.name =  new SimpleStringProperty(name);
        this.patronomic = new SimpleStringProperty(patronomic);
        this.post = new SimpleStringProperty(post);

    }

    public String getFamily() {
        return family.get();
    }

    public String getName() {
        return name.get();
    }

    public String getPatronomic() {
        return patronomic.get();
    }

    public String getPost() {
        return post.get();
    }

    public  void setFamily(String family){
        this.family.set(family);
    }
}
