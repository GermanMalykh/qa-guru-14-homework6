package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GitHubElementsPage {

    private final static String
            PAGE_URL = "https://github.com",
            REPO_NAME = "GermanMalykh/qa-guru-14-homework6",
            ISSUES_NUM = "#1",
            PRICING_MENU = "Pricing",
            PLANS_COMPARE = "Compare plans",
            PRICING_PAGE_H1_TEXT = "Get the complete developer platform.";

    private SelenideElement
            searchField = $(".header-search-input"),
            issuesTab = $("#issues-tab"),
            menu = $(".HeaderMenu"),
            headerPricingPage = $(".p-responsive h1.h2-mktg");

    @Step("Открываем главную страницу: " + PAGE_URL)
    public void openPage() {
        open(PAGE_URL);
        takeScreenshot();
    }

    @Step("Находим и выбирем репозиторий: " + REPO_NAME)
    public void searchAndSelectRepo() {
        searchField.click();
        searchField.sendKeys(REPO_NAME);
        searchField.submit();
        $(linkText(REPO_NAME)).click();
        takeScreenshot();
    }

    @Step("Выбираем вкладку Issues и находим: " + ISSUES_NUM)
    public void checkIssues() {
        issuesTab.click();
        $(withText(ISSUES_NUM)).should(Condition.exist);
        takeScreenshot();
    }

    @Step("Выбираем в меню " + PRICING_MENU + "-->" + PLANS_COMPARE)
    public void selectPricingCompare() {
        menu.$(byText(PRICING_MENU)).hover();
        $(byText(PLANS_COMPARE)).click();
    }

    @Step("Проверяем наличие заголовка " + PRICING_PAGE_H1_TEXT + " на странице")
    public void headerCheck() {
        headerPricingPage.shouldHave(text(PRICING_PAGE_H1_TEXT));
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
