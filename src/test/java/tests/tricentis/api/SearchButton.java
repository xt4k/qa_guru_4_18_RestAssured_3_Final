package tests.tricentis.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.tricentis.BaseTest;
import utils.QueryConverter;

@Epic("Rest Assured")
@Feature("Web-shop")
@Story("Api testet for button `Search`")
@Owner("yuriy")

public class SearchButton extends BaseTest {
    QueryConverter qc = new QueryConverter( );
    private String query;
    private String answer;
    private ApiScenario apiTest = new ApiScenario( );

    @Test
    @DisplayName("Test Api_01: Search returns 1 result match.")
    void searchSuccess1Result( ) {
        query = qc.getQuery("query");
        answer = "Show details for Copy of Computing and Internet EX";
        apiTest.apiScenario(query, answer);
    }

    @Test
    @DisplayName("Test Api_02: Search not found any result matched defined criteria.")
    void searchNoResultTest( ) {
        query = qc.getQuery("query2");
        answer = "No products were found that matched your criteria.";
        apiTest.apiScenario(query, answer);
    }
}