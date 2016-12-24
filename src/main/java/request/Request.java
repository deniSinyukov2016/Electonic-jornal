package request;

/**
 * Created by Denis on 20.11.2016.
 */
public class Request {

    //Выборка всех учащихся
    public static final String ALL_SCHOOLBOY = "SELECT * FROM schoolboy";

    //Выборка всех классов
    public static final String ALL_CLASS = "SELECT * FROM class";

    //Выборка всех учителей
    public static final String ALL_TEACHER = "SELECT family ,name FROM teacher";

    //Выборка букв всех классов без повторений
    public static final String LETER_CLASS_NOT_REPETITION = "SELECT DISTINCT  leter_class FROM class";

    //Выборка номеров всех классов без повторений
    public static final String NUMBER_CLASS_NOT_REPETITION = "SELECT  DISTINCT  number_class FROM class ";

    //Выборка названия всех предметов без повторений
    public static final String ALL_LESSON = "SELECT DISTINCT title FROM lesson";

    //Установка русского языка для БД
    public static final String UA_RUS = "SET lc_time_names = 'ru_UA'";


    //Выборка успеваемости учеников по классу, предмету , учителю, и дате.
    public static final String PERFOMANCE_REQUERY = "select schoolboy.family, schoolboy.name,\n" +
            "\tmax(if(dayofmonth(perfomance.date_delivery)= 1,opinion.title,'')) '1' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 2,opinion.title,'')) '2' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 3,opinion.title,'')) '3' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 4,opinion.title,'')) '4' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 5,opinion.title,'')) '5' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 6,opinion.title,'')) '6' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 7,opinion.title,'')) '7' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 8,opinion.title,'')) '8' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 9,opinion.title,'')) '9' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 10,opinion.title,'')) '10' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 11,opinion.title,'')) '11' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 12,opinion.title,'')) '12' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 13,opinion.title,'')) '13' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 14,opinion.title,'')) '14' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 15,opinion.title,'')) '15' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 16,opinion.title,'')) '16' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 17,opinion.title,'')) '17' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 18,opinion.title,'')) '18' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 19,opinion.title,'')) '19' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 20,opinion.title,'')) '20' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 21,opinion.title,'')) '21' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 22,opinion.title,'')) '22' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 23,opinion.title,'')) '23' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 24,opinion.title,'')) '24' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 25,opinion.title,'')) '25' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 26,opinion.title,'')) '26' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 27,opinion.title,'')) '27' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 28,opinion.title,'')) '28' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 29,opinion.title,'')) '29' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 30,opinion.title,'')) '30' ,\n" +
            "    max(if(dayofmonth(perfomance.date_delivery)= 31,opinion.title,'')) '31' \n" +
            "from schoolboy\n" +
            "left  join  perfomance on perfomance.id_schoolboy  = schoolboy.id  AND DATE_FORMAT( date_delivery, '%M' ) = ? " +
            "and perfomance.id_lesson =  (select id from lesson where lesson.title = ?)" +
            "and perfomance.id_teacher = (select id from teacher where teacher.family = ?) \n" +
            "left  join lesson on lesson.id = perfomance.id_lesson #and  lesson.title = 'История'\n" +
            "left join class on schoolboy.id_class = class.id \n" +
            "left  join opinion  on opinion.id = perfomance.id_opinion \n" +
            "where   class.leter_class = ? and class.number_class = ? \n" +
            "group by schoolboy.family; ";

    public static final String UPDATE_OPINION = " replace  into perfomance (id_schoolboy,id_opinion,id_teacher,id_lesson,date_delivery) \n" +
            " values( \n" +
            "(select schoolboy.id from schoolboy where schoolboy.family = ? and schoolboy.name = ?),\n" +
            "(select opinion.id from opinion where opinion.title = ? ),\n" +
            "(select teacher.id from teacher where teacher.family = ?),\n" +
            "(select lesson.id from lesson where lesson.title = ?),\n" +
            "? );";

    public static final String addNewLesson = "insert into lesson (title) values(?);";
    public static final String addNewSchoolboy2 = "insert into schoolboy (id_class,id_sex,family,name,patronymic,birth_date) \n" +
            "values ((select id from class where leter_class = ? and number_class = ?),\n" +
            "(select id from sex where sex.sex_name = ?), ?,?,?,?);";

    public static final String addNewSchoolboy = "insert into schoolboy (id_class,id_sex,family,name,patronymic,birth_date) \n" +
            "values ((select id from class where leter_class = ? and number_class = ?),\n" +
            "(select id from sex where sex.sex_name = ?), ?,?,?,?);";

    public static final String addNewClass = "insert into class (leter_class,number_class) values (?,?);";
    public static final String addNewTeacher = "insert into teacher (family,name,patronomic,post) values (?,?,?,?);";
}
