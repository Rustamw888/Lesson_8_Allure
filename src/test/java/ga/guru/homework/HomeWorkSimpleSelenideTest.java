package ga.guru.homework;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

@DisplayName("First part")
public class HomeWorkSimpleSelenideTest extends Selectors {

    public static final String repositoryValue = "allure-framework/allure-java";
    public static final String resultValue = "Disable StepAspects possible?";

    @BeforeAll
    public static void setUp() {
        baseUrl = "https://github.com";
    }

    @Test
    @DisplayName("Чистый Selenide (с Listener)")
    public void githubSimpleTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(baseUrl);
        searchField.click();
        searchField.setValue(repositoryValue);
        searchField.submit();

        $(linkText(repositoryValue)).click();
        $(partialLinkText("Issues")).click();
        $(withText(resultValue)).shouldBe(visible);
    }
}
