package ga.guru.allure;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParametersTest {


    @Test
    @DisplayName("Мой любимый тест")
    public void paramTest() {
        Allure.parameter("Регион", "Республика Татарстан");
        Allure.parameter("Город", "Казань");
    }
}
