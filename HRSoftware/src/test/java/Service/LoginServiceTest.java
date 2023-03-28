package Service;

import Database.JDBCUtil;
import org.junit.jupiter.api.AfterAll;
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
    public static void init() {
        System.out.println("Before all");
    }

    @Test
    public void testLogin() {
        String user = "admin";
        String Pass = "adminadmin1";
        LoginService lgs = new LoginService();
        boolean rs = Login(user, Pass);
        Assertions.assertTrue(rs);
    }

    @Test
    public void testUserNull() {
        String user = null;
        String pass = "adminadmin1";
        LoginService lgs = new LoginService();
        boolean rs = Login(user, pass);
        assertFalse(rs);
    }

    @Test
    public void testPassNull() {
        String user = "admin";
        String pass = null;
        LoginService lgs = new LoginService();
        boolean rs = Login(user, pass);
        assertFalse(rs);
    }

    @Test
    public void testUserError() {
        String user = "admin";
        String pass = "x";
        LoginService lgs = new LoginService();
        boolean rs = lgs.Login(user, pass);
        Assertions.assertFalse(rs);
    }

    @Test
    public void testPassError() {
        String user = "x";
        String pass = "addminadmin1";
        LoginService lgs = new LoginService();
        boolean rs = lgs.Login(user, pass);
        Assertions.assertFalse(rs);
    }

    @Test
    public void testPassUserError() {
        String user = "x";
        String pass = "x";
        LoginService lgs = new LoginService();
        boolean rs = lgs.Login(user, pass);
        Assertions.assertFalse(rs);
    }
    @AfterAll
    public static void last() {
        System.out.println("AFTER ALL");
    }
//@Test
//public void testEmptyDatabase() throws SQLException {
//    Connection cnt = JDBCUtil.getConnection();
//    Statement stmt = cnt.createStatement();
//    String Sql = "DELETE FROM admins";
//    stmt.executeUpdate(Sql);
//    boolean result = Login("admin1", "password1");
//    assertFalse(result);
//}
}
