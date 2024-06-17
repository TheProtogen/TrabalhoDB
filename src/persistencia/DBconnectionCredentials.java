package persistencia;

public class DBconnectionCredentials {
    
    public String url = "jdbc:sqlserver://localhost:1433;databaseName=Aluguel_Vestido;trustServerCertificate=true";
    public String user = "Vivi";
    public String pass = "root789ROOT";
    
    public String getUrl() {
        return url;
    }
    public String getUser() {
        return user;
    }
    public String getPass() {
        return pass;
    }

}
