package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import staticdata.WebTimeouts;
import staticdata.WebUrls;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = WebUrls.BASE_URL;
        Configuration.startMaximized = true;
        Configuration.timeout = WebTimeouts.PAGE_LOAD_TIMEOUT;
    }

    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }
}
