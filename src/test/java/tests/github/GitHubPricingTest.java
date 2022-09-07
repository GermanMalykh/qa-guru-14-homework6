package tests.github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.GitHubElementsPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubPricingTest {

    GitHubElementsPage gitHubElementsPage = new GitHubElementsPage();

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void comparePlans() {
        gitHubElementsPage.openPage();
        gitHubElementsPage.selectPricingCompare();
        gitHubElementsPage.headerCheck();
    }
}
