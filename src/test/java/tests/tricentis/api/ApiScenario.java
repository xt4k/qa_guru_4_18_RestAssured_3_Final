package tests.tricentis.api;

import io.qameta.allure.Step;
import tests.tricentis.BaseTest;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.HTML;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiScenario extends BaseTest {

    @Step("Scenario for test `Search` button.")
    void apiScenario(String query, String returnText) {
        String body = given( )
                .contentType(HTML)
                .params("Q", query)
                .when( )
                .get("/search")
                .then( )
                .statusCode(200)
                .extract( )
                .asString( );
        assertThat(body.contains(returnText));
    }
}
