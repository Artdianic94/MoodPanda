package pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import testdata.NamesForTest;
import utilities.GenerateFakeMessage;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PostUpdatePage {
    private SelenideElement postUpdateButton = $(By.xpath("//div[@class='buttons']/a[contains(.,'Post update')]"));
    private SelenideElement textArea = $(By.xpath("//textarea"));
    private SelenideElement buttonUpdateTo = $(By.xpath("//div[@class='container']/a[contains(.,' Update to 5')]"));
    private SelenideElement buttonReturnOnMainBoard = $(By.xpath("//p/a[contains(.,'Home ')]"));
    private ElementsCollection buttonGetTextOnMainBoard = $$(By.xpath("//div[@class='content']/div"));
    private SelenideElement buttonHome = $(By.xpath("//div/a[contains(.,'Home ')]"));
    private SelenideElement containerWithText = $(By.xpath(("//p[@class='title is-4 wrap']")));
    //private SelenideElement myNoteIsExist = $(By.xpath("//div/a[contains(., 'DianaCarroll A ')]"));
    private SelenideElement myNoteIsExist = new NamesForTest().inputText();
    int i = 0;


    public String updatePost() {
        String expectedText = GenerateFakeMessage.getSomeText();
        postUpdateButton.click();
        textArea.sendKeys(expectedText);
        buttonUpdateTo.click();
        buttonReturnOnMainBoard.click();
        return expectedText;
    }

    public List<String> getTextFromMainBoard() {
        buttonHome.click();
        refresh();
        i++;
        if (!myNoteIsExist.isDisplayed() && i <= 60) {
            return getTextFromMainBoard();
        } else if (i <= 60) {
            if (isTrue()) {
                return buttonGetTextOnMainBoard.texts();
            } else {
                return getTextFromMainBoard();
            }
        }
        return buttonGetTextOnMainBoard.texts();
    }

    public boolean isTrue() {
        containerWithText.shouldBe(visible);
        return true;
    }
}
//if (myNoteIsExist.isDisplayed()) {
//        if (isTrue()) {
//        return buttonGetTextOnMainBoard.texts();
//        } else {
//        return getTextFromMainBoard();
//        }
//        }