package ga.guru.homework;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class HomeWorkWebSteps extends Selectors {

    @Step("Открываем главную страницу {url}")
    public void openMainPage(String url) {
        open(url);
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        searchField.click();
        searchField.setValue(repo);
        searchField.submit();
    }

    @Step("Переходим по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Кликаем на вкладку Issues")
    public void openIssueTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем, что есть Issue, с названием {name}")
    public void shouldSeeIssueWithName(String name) {
        $(withText(name)).shouldBe(visible);
        attachPageSource();
        attachScreenshot();
    }

    @Attachment(value = "Исходный код", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "Новый скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
