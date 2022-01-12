package online.fortis;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaTest {
    private static final String REPOSITORY = "Bigwatch86/Homework_06";

    @Test
    public void lambdaStepTest(){
        step("открываем гитхаб", () -> {
            open("https://github.com");
        });

        step("ищем репозиторий " + REPOSITORY, () -> {
            $("[data-test-selector='nav-search-input']").setValue(REPOSITORY).pressEnter();
        });

        step("открываем найденный репозиторий", () -> {
            $$("ul.repo-list li").first().$("a").click();
        });

        step("ищем вкладку 'Issues'", () -> {
            Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
            $("#issues-tab").should(Condition.visible);
        });

    }
}
