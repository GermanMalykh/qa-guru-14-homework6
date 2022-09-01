package tests.internet;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void rectangleSwap() {
        //Open Url
        open("/drag_and_drop");
        //Swap A and B
        $("#column-a").dragAndDropTo($("#column-b"));
        //Check column-a name
        $("#column-a").shouldHave(text("B"));
        //Check column-b name
        $("#column-b").shouldHave(text("A"));
    }
}
