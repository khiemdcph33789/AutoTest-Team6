package TestJUnit.TestLoginFeature;

import Model.SanPhamChiTiet;
import TestJUnit.TestSanPham.SanPhamChiTietService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
    private LoginService loginService;

    @BeforeEach
    public void setUp() {
        loginService = new LoginService();
    }
    @Test
    public void LoginThanhCong() {
        String userName = "adimn";
        String password = "123456";
        Assertions.assertTrue(loginService.Login(userName,password));
    }
    @Test
    public void LoginThatBai() {
        String userName = "abcdefgh";
        String password = "123456";
        Assertions.assertFalse(loginService.Login(userName,password));
    }
    @Test
    public void LoginThatBai1() {
        String userName = "adimn";
        String password = "abcdefgh";
        Assertions.assertFalse(loginService.Login(userName,password));
    }
    @Test
    public void LoginThatBai2() {
        String userName = "";
        String password = "123456";
        Assertions.assertFalse(loginService.Login(userName,password));
    }
    @Test
    public void LoginThatBai3() {
        String userName = "adimn";
        String password = "";
        Assertions.assertFalse(loginService.Login(userName,password));
    }
    @Test
    public void LoginThatBai4() {
        String userName = "";
        String password = "";
        Assertions.assertFalse(loginService.Login(userName,password));
    }

    @Test
    public void LoginThatBai5() {
        String userName = "";
        String password = null;
        Assertions.assertFalse(loginService.Login(userName,password));
    }



}
