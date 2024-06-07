import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnectionTest {
    public static void main(String[] args) {

        DBconnection db = new DBconnection();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
            System.out.println("-- All good. --");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
