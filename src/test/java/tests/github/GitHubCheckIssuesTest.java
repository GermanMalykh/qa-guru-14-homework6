package tests.github;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import pages.GitHubElementsPage;

public class GitHubCheckIssuesTest {

    GitHubElementsPage gitHubElementsPage = new GitHubElementsPage();

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void testIssueSearch() {
        gitHubElementsPage.openPage();
        gitHubElementsPage.searchAndSelectRepo();
        gitHubElementsPage.checkIssues();
    }

}