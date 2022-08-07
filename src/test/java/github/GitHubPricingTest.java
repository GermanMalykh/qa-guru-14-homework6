package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubPricingTest {

    @Test
    void comparePlans() {
        //Open Github
        open("https://github.com");
        //Select Pricing -> Compare plans
        $(".HeaderMenu ").$(byText("Pricing")).hover();
        $(byText("Compare plans")).click();
        //Find "Choose the plan..."
        $(".p-responsive h1.h2-mktg").shouldHave(text("Choose the plan that’s right for you."));
    }

}
