package tests.tricentis.ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.tricentis.BaseTest;
import utils.QueryConverter;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static java.lang.System.getProperty;
import static tests.helpers.AttachmentsHelper.*;

@Epic("Rest Assured")
@Feature("Web-shop")
@Story("Gui testet for button `Search`")
@Owner("yuriy")

public class SearchButton extends BaseTest {
    QueryConverter qc = new QueryConverter( );
    private String query;
    private String answer;
    private GuiScenario apiTest = new GuiScenario( );

    @Test
    @DisplayName("Test Ui_01: Search returns 1 result match.")
    void searchSuccess1Result( ) {
        query = getProperty("query3");
        apiTest.successSearchScenario(query);
    }

    @Test
    @DisplayName("Test Ui_02: Search not found any result.")
    void searchNoResultTest( ) {
        query = getProperty("query2");
        String message=getProperty("no.search.result");
        apiTest.unSuccessSearchScenario(query,message);
    }

    @AfterEach
    public void afterEach( ) {
        attachScreenshot("Last screenshot");
        attachPageSource( );
        attachAsText("Browser console logs", getConsoleLogs( ));
        if (System.getProperty("video_storage") != null)
            attachVideo( );
        closeWebDriver( );
    }


}