package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CrisisPage {
    private SelenideElement buttonCrisis = $(By.xpath("//a[text() = ' I am in crisis ']"));
    private ElementsCollection crisisPageText = $$(By.xpath("//div[@class='container']/p"));

    public List<String> getTextFromCrisisPage() {
        buttonCrisis.click();
        return crisisPageText.texts();
    }
}
