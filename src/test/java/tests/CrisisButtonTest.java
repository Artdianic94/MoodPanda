package tests;

import models.LoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CrisisPage;
import pages.LoginPage;
import testdata.GetLoginModel;

import java.util.ArrayList;
import java.util.List;

public class CrisisButtonTest extends BaseTest {
    @Test
    public void crisisTextTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        LoginModel loginModel = GetLoginModel.loginModel();
        loginPage.login(loginModel.getEmail(), loginModel.getPassword());
        CrisisPage crisisPage = new CrisisPage();
        List<String> actualTextFromThePage = crisisPage.getTextFromCrisisPage();
        List<String> expectedCrisisText = new ArrayList<>();
        expectedCrisisText.add("Crisis center");
        expectedCrisisText.add("You deserve help.");
        Assert.assertEquals(actualTextFromThePage, expectedCrisisText, "The texts are not identical");
    }

}
