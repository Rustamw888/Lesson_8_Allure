package ga.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LablesTest {

    @Test
    @Owner("Рустам")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории")
    @Story("Просмотр созданных задач в репозитории")
    @DisplayName("Мой любимый тест")
    @Link(value = "Ссылка", url = "https://github.com")
    public void annotatedTest() {

    }

    @Test
    public void testCode() {
        Allure.label("owner", "Рустам");
        Allure.label("severity", SeverityLevel.BLOCKER.value());
        Allure.feature("Задачи в репозитории");
        Allure.story("Просмотр созданных задач в репозитории");
        Allure.link("Ссылка", "https://github.com");
    }

//    @Test
//    @craftAnnotation
//    @DisplayName("Мой любимый тест")
//    @Link(value = "Ссылка", url = "https://github.com")
//    public void annotatedTest() {
//
//    }
//
//    @Documented
//    @Owner("Рустам")
//    @Severity(SeverityLevel.BLOCKER)
//    @Feature("Задачи в репозитории")
//    @Story("Просмотр созданных задач в репозитории")
//    @Target({ ElementType.TYPE, ElementType.METHOD })
//    @Retention(RetentionPolicy.RUNTIME)
//    public @interface craftAnnotation {
//
//    }
}
