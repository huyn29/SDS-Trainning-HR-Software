package Service;

import Database.JDBCUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static Service.LoginService.Login;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class LoginServiceTest {

    @BeforeAll
    public static void init(){
        System.out.println("Before all");
    }
    @Test
    public void testLogin (){
        String user = "admin";
        String Pass = "admin";
        LoginService lgs = new LoginService();
        boolean rs = Login(user,Pass);

        Assertions.assertTrue(rs);
    }
    @Test
    public void testUserNull(){
        String user = null;
        String pass = "admin";
        LoginService lgs = new LoginService();
        boolean rs = Login(user,pass);
        assertFalse(rs);
    }
    @Test
    public void testPassNull(){
        String user = "admin";
        String pass = null;
        LoginService lgs = new LoginService();
        boolean rs = Login(user,pass);
        assertFalse(rs);
    }
//    @Test
//    public void testPassNull(){
//        String user = "admin";
//        String pass = null;
//        LoginService lgs = new LoginService();
//        boolean rs = lgs.Login(user,pass);
//        Assertions.assertFalse(rs);
//    }
@Test
public void testEmptyDatabase() throws SQLException {
    Connection cnt = JDBCUtil.getConnection();
    Statement stmt = cnt.createStatement();
    String Sql = "DELETE FROM admins";
    stmt.executeUpdate(Sql);
    boolean result = Login("admin1", "password1");
    assertFalse(result);
}
}
