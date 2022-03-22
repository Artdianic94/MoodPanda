package tests;

import com.codeborne.selenide.Configuration;
import models.LoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PostUpdatePage;
import pages.PostsPage;
import staticdata.WebUrls;
import testdata.GetLoginModel;

import java.util.List;

import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.*;

public class PostUpdateTest extends BaseTest {
    @Test
    public void postUpdateTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        LoginModel loginModel = GetLoginModel.loginModel();
        loginPage.login(loginModel.getEmail(), loginModel.getPassword());
        PostUpdatePage postUpdatePage = new PostUpdatePage();
        String expectedText = postUpdatePage.updatePost();
        PostsPage postsPage = new PostsPage();
        List<String> actualText = postsPage.getTextFromMainBoard();
        System.out.println(expectedText);
        System.out.println(actualText);
        boolean isContain = actualText.contains(expectedText);
        Assert.assertTrue(isContain, "The page does not contain this post");
    }
}
