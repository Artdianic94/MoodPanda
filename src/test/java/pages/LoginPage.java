package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import staticdata.WebUrls;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * LoginPage class it is Page Object realisation of login page
 *
 * @author Diana Art
 */
public class LoginPage {
    private SelenideElement emailInput = $(By.xpath("//input[@placeholder='MoodPanda registered email ']"));
    private SelenideElement passwordInput = $(By.name("password"));
    private SelenideElement loginButton = $(By.xpath("//button[contains(.,'Login')]"));

    public void openLoginPage() {
        open(baseUrl.concat(WebUrls.LOGIN_URL));
    }

    /**
     * Method performs login to Mood Panda
     *
     * @param email
     * @param password
     */
    public void login(String email, String password) {
        loginButton.shouldBe(Condition.enabled);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
