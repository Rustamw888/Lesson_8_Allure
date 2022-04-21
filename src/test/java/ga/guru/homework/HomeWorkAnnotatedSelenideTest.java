package ga.guru.homework;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;

@DisplayName("Third part")
public class HomeWorkAnnotatedSelenideTest extends Selectors {

    public static final String repositoryValue = "allure-framework/allure-java";
    public static final String resultValue = "Disable StepAspects possible?";

    @BeforeAll
    public static void setUp() {
        baseUrl = "https://github.com";
    }

    @Test
    @DisplayName("Шаги с аннотацией @Step")
    public void githubSimpleTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        HomeWorkWebSteps homeWorkWebSteps = new HomeWorkWebSteps();
        Allure.parameter("Домашняя работа", "Тяпаева Рустама");

        homeWorkWebSteps.openMainPage(baseUrl);
        homeWorkWebSteps.searchForRepository(repositoryValue);
        homeWorkWebSteps.clickOnRepositoryLink(repositoryValue);
        homeWorkWebSteps.openIssueTab();
        homeWorkWebSteps.shouldSeeIssueWithName(resultValue);
    }

    @Test
    public void testCode() {
        Allure.label("owner", "Рустам");
        Allure.label("severity", SeverityLevel.BLOCKER.value());
        Allure.feature("Задачи в репозитории");
        Allure.story("Просмотр задач в репозитории");
        Allure.link("Ссылка", "https://github.com");
    }
}
