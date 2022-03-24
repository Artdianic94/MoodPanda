package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utilities.GenerateFakeMessage;

import static com.codeborne.selenide.Selenide.$;

public class EdithProfilePage {
    private SelenideElement navMenu = $(By.xpath("//a[text()=' Your dashboard ']"));
    private SelenideElement edithProfileLink = $(By.xpath("//div[@class='content-pane nav-bar-spacer']//aside//li[contains(.,'Edit profile ')]"));
    private SelenideElement firstNameInput = $(By.xpath("//label[text()='Last name initial']//preceding::input"));
    private SelenideElement saveButton = $(By.xpath("//button[text()=' Save identity ']"));
    private SelenideElement toastMessage = $(By.xpath("//div[contains(@class,'notification is-full-width-toast is-')]"));

    public void edithProfile() {
        navMenu.click();
        edithProfileLink.click();
        firstNameInput.click();
        firstNameInput.sendKeys(GenerateFakeMessage.getFirstName());
    }

    public String saveAndGetMessage() {
        saveButton.click();
        return toastMessage.getText();
    }
}
