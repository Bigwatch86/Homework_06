package online.fortis;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepTest {
    private static final String REPOSITORY = "Bigwatch86/Homework_06";

    @Test
    @Owner("Bigwatch86")
    @Feature("Issues")
    @Story("Проверка наличия вкладки Issues")
    @DisplayName("Проверка наличия вкладки Issues с лямбда шагами")
    @Severity(SeverityLevel.BLOCKER)
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


    @Test
    @Owner("Bigwatch86")
    @Feature("Issues")
    @Story("Проверка наличия вкладки Issues")
    @DisplayName("Проверка наличия вкладки Issues с аннотацией @Step")
    public void annotatedStepsTest() {
    AnnotationStepTest steps = new AnnotationStepTest();
    steps.openMainPage();
    steps.searchForRepository(REPOSITORY);
    steps.openRepositoryPage(REPOSITORY);
    steps.searchIssuesTab();
    }
}
