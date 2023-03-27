package Service;

import Database.JDBCUtil;
import com.mysql.cj.jdbc.JdbcConnection;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginService {
    public static boolean Login() {
        Connection cnt = null;
        String user;
        String pass;
        System.out.println("Enter your account");
        System.out.printf("Type your user: ");
        String userType = InputService.InputString();
        System.out.println();
        System.out.printf("Enter your password: ");
        String passType = InputService.InputString();
        try {
            cnt = JDBCUtil.getConnection();
            Statement stmt = cnt.createStatement();
            String Sql = "SELECT * FROM admins";
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                user = rs.getString("userAd");
                pass = rs.getString("passwordAd");
                if (user.equals(userType) == true && pass.equals(passType) == true) {
                    break;
                } else {
                    continue;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.closeConnection(cnt);
        }
        return true;
    }
}
