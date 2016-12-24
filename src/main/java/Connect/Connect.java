package Connect;

import com.mysql.jdbc.DatabaseMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Denis on 24.10.2016.
 */
public final class Connect {
    Connection con = null;


    public  Connection connection() {

        try {
            String url = "jdbc:mysql://localhost:3306/dbSchool2";
            String user = "root";
            String password = "root";

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            System.out.println("con open");
            return con;


        } catch (ClassNotFoundException | SQLException e) {
            System.err.print(e);
        }

        return  null;
    }




    public void closeDB() throws SQLException {
        if (con!=null){
            con.close();
            con = null;
        }
    }
}


