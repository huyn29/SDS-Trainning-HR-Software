package Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


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
        boolean rs = lgs.Login(user,Pass);
        Assertions.assertTrue(true);
    }
    @Test
    public void testUserNull(){
        String user = null;
        String pass = "admin";
        LoginService lgs = new LoginService();
        boolean rs = lgs.Login(user,pass);
        Assertions.assertTrue(true);
    }
}
