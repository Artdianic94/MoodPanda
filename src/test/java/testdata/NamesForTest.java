package testdata;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NamesForTest {

    String myNoteIsExist = "//div/a[contains(., '%s')]";
    private SelenideElement nameOnPage = $(By.xpath("//p[@class='title is-4']"));
    private SelenideElement buttonYourDiary = $(By.xpath("//a[text()=' Your diary ']"));

    public SelenideElement inputText() {
        buttonYourDiary.click();
        String newName = nameOnPage.should(Condition.exist).getText();
        myNoteIsExist = String.format(myNoteIsExist, newName);
        return $(By.xpath(myNoteIsExist));
    }
}
