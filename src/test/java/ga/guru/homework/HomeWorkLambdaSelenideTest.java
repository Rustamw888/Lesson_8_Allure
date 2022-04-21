package ga.guru.homework;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

@HomeWorkLambdaSelenideTest.CraftAnnotation
@Feature("Задачи в репозитории")
@Story("Просмотр созданных задач в репозитории")
@DisplayName("Second part")
public class HomeWorkLambdaSelenideTest extends Selectors {

    public static final String repositoryValue = "allure-framework/allure-java";
    public static final String resultValue = "Disable StepAspects possible?";

    @BeforeAll
    public static void setUp() {
        baseUrl = "https://github.com";
    }

    @Test
    @DisplayName("Лямбда шаги через step (name, () -> {})")
    public void githubSimpleTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Allure.parameter("Домашняя работа", "Тяпаева Рустама");
        step("Открываем главную страницу" + baseUrl, () -> {
            open(baseUrl);
        });
        step("Ищем репозиторий " + repositoryValue, () -> {
            searchField.click();
            searchField.setValue(repositoryValue);
            searchField.submit();
        });
        step("Переходим по ссылке репозитория " + repositoryValue, () -> {
            $(linkText(repositoryValue)).click();
        });
        step("Кликаем на вкладку Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем, что есть Issue, с названием " + resultValue, () -> {
            $(withText(resultValue)).shouldBe(visible);
            Allure.getLifecycle().addAttachment(
                    "Исходный код",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
            );
            Allure.getLifecycle().addAttachment(
                    "Скриншот",
                    "image/png",
                    "png",
                    ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES)
            );
        });
    }

    @Documented
    @Owner("Рустам")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "ссылка", url = "https://github.com")
    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CraftAnnotation {

    }
}
