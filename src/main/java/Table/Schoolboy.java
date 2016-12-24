package Table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

/**
 * Created by Denis on 24.10.2016.
 */
public class Schoolboy {

    private  SimpleIntegerProperty id;
    private SimpleStringProperty family;
    private SimpleStringProperty name;
    private SimpleStringProperty patronymic;
    private Date birthday;
    private SimpleIntegerProperty id_class;
    private SimpleIntegerProperty id_sex;

    public Schoolboy(String family, String name, String patronymic, Date birthday,
                     int id_class, int id_sex){

        this.family = new SimpleStringProperty(family);
        this.name = new SimpleStringProperty(name);
        this.patronymic = new SimpleStringProperty(patronymic);
        this.birthday = birthday;
        this.id_class = new SimpleIntegerProperty(id_class);
        this.id_sex = new SimpleIntegerProperty(id_sex);
    }

    public Schoolboy(int id, String family, String name, String patronymic, Date birthday,
                     int id_class, int id_sex){
        this.id = new SimpleIntegerProperty(id);
        this.family = new SimpleStringProperty(family);
        this.name = new SimpleStringProperty(name);
        this.patronymic = new SimpleStringProperty(patronymic);
        this.birthday = birthday;
        this.id_class = new SimpleIntegerProperty(id_class);
        this.id_sex = new SimpleIntegerProperty(id_sex);
    }

    public int getId() {
        return id.get();
    }

    public String getFamily() {
        return family.get();
    }

    public String getName() {
        return name.get();
    }

    public String getPatronymic() {
        return patronymic.get();
    }

    public int getBirthday() {
        return birthday.getDate();
    }

    public int getId_class() {
        return id_class.get();
    }

    public int getId_sex() {
        return id_sex.get();
    }
}
