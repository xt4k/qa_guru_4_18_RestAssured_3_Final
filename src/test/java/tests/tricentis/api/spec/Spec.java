package tests.tricentis.api.spec;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static tests.tricentis.api.template.ReportTemplate.filteres;

public class Spec {

    public static RequestSpecification requestForm() {
        return given()
                .contentType("application/x-www-form-urlencoded")
                .baseUri(baseURI)
                .filter(filteres().customTemplates())
                .log().uri();
    }

    public static RequestSpecification requestJson() {
        return given()
                .contentType(JSON)
                .baseUri(baseURI)
                .filter(filteres().customTemplates())
                .log().uri();
    }

}
