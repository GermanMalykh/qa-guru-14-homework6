package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GitHubElementsPage {

    private final static String
            PAGE_URL = "https://github.com",
            REPO_NAME = "GermanMalykh/qa-guru-14-homework6",
            ISSUES_NUM = "#1";


    private SelenideElement
            searchField = $(".header-search-input"),
            issuesTab = $("#issues-tab"),
            menu = $(".HeaderMenu");

    @Step("Открываем главную страницу: " + PAGE_URL)
    public void openPage() {
        open(PAGE_URL);
    }

    @Step("Находим и выбирем репозиторий: " + REPO_NAME)
    public void searchAndSelectRepo() {
        searchField.click();
        searchField.sendKeys(REPO_NAME);
        searchField.submit();
        $(linkText(REPO_NAME)).click();
    }

    @Step("Выбираем вкладку Issues и находим: " + ISSUES_NUM)
    public void checkIssues() {
        issuesTab.click();
        $(withText(ISSUES_NUM)).should(Condition.exist);
    }

}
