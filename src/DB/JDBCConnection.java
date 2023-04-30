package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author panpa
 */
public class JDBCConnection {
    public static Connection getJDBCConnection(){
        final String serverName ="TheRich";
        final String dbName = "NhaHang1";
        final String user = "sa";
        final String password = "123456";
        final String url = "jdbc:sqlserver://" +serverName 
                +":1433;DatabaseName=" +dbName
                +";encrypt=false;";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, user, password);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }
}
