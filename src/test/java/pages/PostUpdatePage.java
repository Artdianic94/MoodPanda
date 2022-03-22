package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utilities.GenerateFakeMessage;


import static com.codeborne.selenide.Selenide.*;

public class PostUpdatePage {
    private SelenideElement postUpdateButton = $(By.xpath("//div[@class='buttons']/a[contains(.,'Post update')]"));
    private SelenideElement textArea = $(By.xpath("//textarea"));
    private SelenideElement buttonUpdateTo = $(By.xpath("//div[@class='container']/a[contains(.,' Update to 5')]"));
    private SelenideElement buttonReturnOnMainBoard = $(By.xpath("//p/a[contains(.,'Home ')]"));

    public String updatePost() {
        String expectedText = GenerateFakeMessage.getSomeText();
        postUpdateButton.click();
        textArea.sendKeys(expectedText);
        buttonUpdateTo.click();
        buttonReturnOnMainBoard.click();
        return expectedText;
    }

}
