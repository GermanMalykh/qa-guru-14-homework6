package tests.github;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class GitHubCheckIssuesWithListenerTest {


    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void testIssueSearch() {

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("GermanMalykh/qa-guru-14-homework6");
        $(".header-search-input").submit();

        $(linkText("GermanMalykh/qa-guru-14-homework6")).click();
        $("#issues-tab").click();
        $(withText("#1")).should(Condition.exist);
    }
}
