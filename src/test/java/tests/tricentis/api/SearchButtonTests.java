package tests.tricentis.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.tricentis.BaseTest;

import static java.lang.System.getProperty;

@Epic("Rest Assured")
@Feature("Web-shop")
@Story("Api testet for button `Search`")
@Owner("yuriy")
@Tag("api_search")
public class SearchButtonTests extends BaseTest {
    private String query;
    private String answer;
    private ApiScenario apiTest = new ApiScenario();

    @Test
    @DisplayName("Test Api_01: Search returns 1 result match.")
    void searchSuccess1Result() {
        query = getProperty("query");
        answer = "Show details for Copy of Computing and Internet EX";
        apiTest.apiSearchScenario(query, answer);
    }

    @Test
    @DisplayName("Test Api_02: Search not found any result matched defined criteria.")
    void searchNoResultTest() {
        query = getProperty("query2");
        answer = "No products were found that matched your criteria.";
        apiTest.apiSearchScenario(query, answer);
    }
}