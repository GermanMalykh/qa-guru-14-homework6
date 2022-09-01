package tests.internet;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void configure() {
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
