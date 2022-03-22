package tests;

import models.LoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EdithProfilePage;
import pages.LoginPage;
import testdata.GetLoginModel;

public class ToastMessageTest extends BaseTest {
    @Test
    public void getToastMessageTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        LoginModel loginModel = GetLoginModel.loginModel();
        loginPage.login(loginModel.getEmail(), loginModel.getPassword());
        EdithProfilePage edithProfilePage = new EdithProfilePage();
        edithProfilePage.edithProfile();
        String actualTextMessage = edithProfilePage.saveAndGetMessage();
        String expectedTextMessage = "Your identity was updated";
        Assert.assertEquals(actualTextMessage, expectedTextMessage, "The texts are not identical");
    }
}
