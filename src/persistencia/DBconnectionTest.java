package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnectionTest {
    public Connection getConnection() {
        Connection con;
        DBconnectionCredentials db = new DBconnectionCredentials();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());

            System.out.println("DB conectado");

            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
