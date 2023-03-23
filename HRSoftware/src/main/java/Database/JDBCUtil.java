package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection(){
        Connection cnn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/qlns";
            String user = "huyn29";
            String password = "";
            cnn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cnn;
    }
    public static void closeConnection(Connection cnn)  {
        try {
            if(cnn != null){
                cnn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
