package tests;

import models.LoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PostUpdatePage;
import testdata.GetLoginModel;

import java.util.List;

import static com.codeborne.selenide.Selenide.sleep;

public class PostUpdateTest extends BaseTest {
    @Test(description = "Test checks sending of post")
    public void postUpdateTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        LoginModel loginModel = GetLoginModel.loginModel();
        loginPage.login(loginModel.getEmail(), loginModel.getPassword());
        PostUpdatePage postUpdatePage = new PostUpdatePage();
        String expectedText = postUpdatePage.updatePost();
        List<String> actualText = postUpdatePage.getTextFromMainBoard();
        boolean isContain = actualText.contains(expectedText);
        Assert.assertTrue(isContain, "The page does not contain this post");
    }
}
