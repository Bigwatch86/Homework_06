package online.fortis;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SelenideTest {

    @Test
    public void testIssuesSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");

        $("[data-test-selector='nav-search-input']").setValue("Bigwatch86/Homework_06").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#issues-tab").should(Condition.visible);
    }
}
