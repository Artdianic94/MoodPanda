package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PostsPage {
    private ElementsCollection buttonGetTextOnMainBoard = $$(By.xpath("//div[@id='app']/div[@class='content-pane nav-bar-spacer']"));
    private SelenideElement buttonHome = $(By.xpath("//div/a[contains(.,'Home ')]"));

    public List<String> getTextFromMainBoard() {
        buttonHome.click();
        return buttonGetTextOnMainBoard.texts();
    }
}
