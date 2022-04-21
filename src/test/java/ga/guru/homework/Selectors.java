package ga.guru.homework;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Selectors {

    SelenideElement searchField = $("[data-test-selector='nav-search-input']");
}
