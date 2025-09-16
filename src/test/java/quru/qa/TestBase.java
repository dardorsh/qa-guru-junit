package quru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        open("https://www.litres.ru/");
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
