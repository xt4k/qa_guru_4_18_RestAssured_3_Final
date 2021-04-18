package tests.tricentis.ui;

import io.qameta.allure.Step;
import tests.po.BasePageObject;
import tests.tricentis.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class GuiScenario extends BaseTest {

    @Step("Success scenario for test `Search` button.")
    void successSearchScenario(String query) {
        open(baseUrl);
        new BasePageObject().search(query)
                .checkSearchResult(query);
    }

    @Step("Scenario with `Unsuccess search`")
    void unSuccessSearchScenario(String query, String message) {
        open(baseUrl);
        new BasePageObject().search(query)
                .checkNoSearchResult(message);
    }
}
