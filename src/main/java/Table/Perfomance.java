package Table;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Denis on 17.12.2016.
 */
public class Perfomance {

    private IntegerProperty count;
    private StringProperty family;
    private StringProperty name;
    private StringProperty one;
    private StringProperty two;
    private StringProperty three;
    private StringProperty four;
    private StringProperty five;
    private StringProperty six;
    private StringProperty seven;
    private StringProperty eight;
    private StringProperty nine;
    private StringProperty ten;
    private StringProperty eleven;
    private StringProperty twelve;
    private StringProperty thirteen;
    private StringProperty fourteen;
    private StringProperty fifteen;
    private StringProperty sixteen;
    private StringProperty seventeen;
    private StringProperty eighteen;
    private StringProperty nineteen;
    private StringProperty twenty;
    private StringProperty twentyОne;
    private StringProperty twentyTwo;
    private StringProperty twentyTree;
    private StringProperty twentyFour;
    private StringProperty twentyFive;
    private StringProperty twentySix;
    private StringProperty twentySeven;
    private StringProperty twentyEight;
    private StringProperty twentyNine;
    private StringProperty thirty;
    private StringProperty thirtyOne;


    public Perfomance( int count,String family,String name, String one, String two, String three, String four, String five,String six,
                      String seven, String eight, String nine, String ten, String eleven, String twelve,String thirteen,
                      String fourteen, String fifteen, String sixteen, String seventeen, String eighteen, String nineteen,
                      String twenty, String twentyОne, String twentyTwo, String twentyTree, String twentyFour, String twentyFive,
                      String twentySix, String twentySeven, String twentyEight, String twentyNine, String thirty, String thirtyOne){
        this.count =  new SimpleIntegerProperty(count);
        this.setFamily(new SimpleStringProperty(family));
        this.setName( new SimpleStringProperty(name));
        this.setOne(new SimpleStringProperty(one));
        this.setTwo(new SimpleStringProperty(two));
        this.setThree(new SimpleStringProperty(three));
        this.setFour(new SimpleStringProperty(four));
        this.setFive(new SimpleStringProperty(five));
        this.setSix(new SimpleStringProperty(six));
        this.setSeven(new SimpleStringProperty(seven));
        this.setEight(new SimpleStringProperty(eight));
        this.setNine(new SimpleStringProperty(nine));
        this.setTen(new SimpleStringProperty(ten));
        this.setEleven(new SimpleStringProperty(eleven));
        this.setTwelve(new SimpleStringProperty(twelve));
        this.setThirteen(new SimpleStringProperty(thirteen));
        this.setFourteen(new SimpleStringProperty(fourteen));
        this.setFifteen(new SimpleStringProperty(fifteen));
        this.setSixteen(new SimpleStringProperty(sixteen));
        this.setSeventeen(new SimpleStringProperty(seventeen));
        this.setEighteen(new SimpleStringProperty(eighteen));
        this.setNineteen(new SimpleStringProperty(nineteen));
        this.setTwenty(new SimpleStringProperty(twenty));
        this.setTwentyОne(new SimpleStringProperty(twentyОne));
        this.setTwentyTwo(new SimpleStringProperty(twentyTwo));
        this.setTwentyTree(new SimpleStringProperty(twentyTree));
        this.setTwentyFour(new SimpleStringProperty(twentyFour));
        this.setTwentyFive(new SimpleStringProperty(twentyFive));
        this.setTwentySix(new SimpleStringProperty(twentySix));
        this.setTwentySeven(new SimpleStringProperty(twentySeven));
        this.setTwentyEight(new SimpleStringProperty(twentyEight));
        this.setTwentyNine(new SimpleStringProperty(twentyNine));
        this.setThirty(new SimpleStringProperty(thirty));
        this.setThirtyOne(new SimpleStringProperty(thirtyOne));
    }





    public int getCount() {
        return count.get();
    }

    public void setCount(IntegerProperty count) {
        this.count = count;
    }
    public String getName() {
        return name.get();
    }


    public  void setName (StringProperty name){
        this.name = name;
    }
    public String getFamily() {
        return family.get();
    }

    public void setFamily(StringProperty family) {
        this.family = family;
    }

    public String getOne() {
        return one.get();
    }

    public void setOne(StringProperty one) {
        this.one = one;
    }

    public String getTwo() {
        return two.get();
    }

    public void setTwo(StringProperty two) {
        this.two = two;
    }

    public String getThree() {
        return three.get();
    }

    public void setThree(StringProperty three) {
        this.three = three;
    }

    public String getFour() {
        return four.get();
    }

    public void setFour(StringProperty four) {
        this.four = four;
    }

    public String getFive() {
        return five.get();
    }

    public void setFive(StringProperty five) {
        this.five = five;
    }

    public String getSix() {
        return six.get();
    }

    public void setSix(StringProperty six) {
        this.six = six;
    }

    public String getSeven() {
        return seven.get();
    }

    public void setSeven(StringProperty seven) {
        this.seven = seven;
    }

    public String getEight() {
        return eight.get();
    }

    public void setEight(StringProperty eight) {
        this.eight = eight;
    }

    public String getNine() {
        return nine.get();
    }

    public void setNine(StringProperty nine) {
        this.nine = nine;
    }

    public String getTen() {
        return ten.get();
    }

    public void setTen(StringProperty ten) {
        this.ten = ten;
    }

    public String getEleven() {
        return eleven.get();
    }

    public void setEleven(StringProperty eleven) {
        this.eleven = eleven;
    }

    public String getTwelve() {
        return twelve.get();
    }

    public void setTwelve(StringProperty twelve) {
        this.twelve = twelve;
    }

    public String getThirteen() {
        return thirteen.get();
    }

    public void setThirteen(StringProperty thirteen) {
        this.thirteen = thirteen;
    }

    public String getFourteen() {
        return fourteen.get();
    }

    public void setFourteen(StringProperty fourteen) {
        this.fourteen = fourteen;
    }

    public String getFifteen() {
        return fifteen.get();
    }

    public void setFifteen(StringProperty fifteen) {
        this.fifteen = fifteen;
    }

    public String getSixteen() {
        return sixteen.get();
    }

    public void setSixteen(StringProperty sixteen) {
        this.sixteen = sixteen;
    }

    public String getSeventeen() {
        return seventeen.get();
    }

    public void setSeventeen(StringProperty seventeen) {
        this.seventeen = seventeen;
    }

    public String getEighteen() {
        return eighteen.get();
    }

    public void setEighteen(StringProperty eighteen) {
        this.eighteen = eighteen;
    }

    public String getNineteen() {
        return nineteen.get();
    }

    public void setNineteen(StringProperty nineteen) {
        this.nineteen = nineteen;
    }

    public String getTwenty() {
        return twenty.get();
    }

    public void setTwenty(StringProperty twenty) {
        this.twenty = twenty;
    }

    public String getTwentyОne() {
        return twentyОne.get();
    }

    public void setTwentyОne(StringProperty twentyОne) {
        this.twentyОne = twentyОne;
    }

    public String getTwentyTwo() {
        return twentyTwo.get();
    }

    public void setTwentyTwo(StringProperty twentyTwo) {
        this.twentyTwo = twentyTwo;
    }

    public String getTwentyTree() {
        return twentyTree.get();
    }

    public void setTwentyTree(StringProperty twentyTree) {
        this.twentyTree = twentyTree;
    }

    public String getTwentyFour() {
        return twentyFour.get();
    }

    public void setTwentyFour(StringProperty twentyFour) {
        this.twentyFour = twentyFour;
    }

    public String getTwentyFive() {
        return twentyFive.get();
    }

    public void setTwentyFive(StringProperty twentyFive) {
        this.twentyFive = twentyFive;
    }

    public String getTwentySix() {
        return twentySix.get();
    }

    public void setTwentySix(StringProperty twentySix) {
        this.twentySix = twentySix;
    }

    public String getTwentySeven() {
        return twentySeven.get();
    }

    public void setTwentySeven(StringProperty twentySeven) {
        this.twentySeven = twentySeven;
    }

    public String getTwentyEight() {
        return twentyEight.get();
    }

    public void setTwentyEight(StringProperty twentyEight) {
        this.twentyEight = twentyEight;
    }

    public String getTwentyNine() {
        return twentyNine.get();
    }

    public void setTwentyNine(StringProperty twentyNine) {
        this.twentyNine = twentyNine;
    }

    public String getThirty() {
        return thirty.get();
    }

    public void setThirty(StringProperty thirty) {
        this.thirty = thirty;
    }

    public String getThirtyOne() {
        return thirtyOne.get();
    }

    public void setThirtyOne(StringProperty thirtyOne) {
        this.thirtyOne = thirtyOne;
    }
}
