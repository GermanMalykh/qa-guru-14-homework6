package tests.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubPricingTest {

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void comparePlans() {
        //Open Github
        open("https://github.com");
        //Select Pricing -> Compare plans
        $(".HeaderMenu").$(byText("Pricing")).hover();
        $(byText("Compare plans")).click();
        //Find "Get the complete..."
        $(".p-responsive h1.h2-mktg").shouldHave(text("Get the complete developer platform."));
    }
}
