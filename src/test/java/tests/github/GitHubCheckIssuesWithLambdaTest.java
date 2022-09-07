package tests.github;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class GitHubCheckIssuesWithLambdaTest {

    private final static String
            PAGE_URL = "https://github.com",
            REPO_NAME = "GermanMalykh/qa-guru-14-homework6",
            ISSUES_NUM = "1";

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void testIssueSearch() {

        step("Открываем главную страницу " + PAGE_URL, () -> {
            open(PAGE_URL);
        });
        step("Находим репозиторий " + REPO_NAME, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPO_NAME);
            $(".header-search-input").submit();
        });
        step("Кликаем по ссылке репозитория " + REPO_NAME, () -> {
            $(linkText(REPO_NAME)).click();
        });
        step("Выбираем \"Issue\"", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие issue с номером " + ISSUES_NUM, () -> {
            $(withText("#" + ISSUES_NUM)).should(Condition.exist);
        });
    }

}
