package tests.tricentis;

import config.WebConfig;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.filter.Filter;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.restassured.RestAssured.baseURI;
import static java.lang.System.getProperties;
import static java.lang.System.setProperty;

public class BaseTest {
    protected static Filter filter;

    @BeforeAll
    @DisplayName("Precondition step")
    static void setUp() {
        addListener("AllureSelenide", new AllureSelenide( ).screenshots(true).savePageSource(true));
        final WebConfig config = ConfigFactory.create(WebConfig.class, getProperties( ));
        browser = config.getBrowser( );
        browserVersion = config.getBrowserVersion( );
        startMaximized = true;

        baseURI = "http://demowebshop.tricentis.com";
        baseUrl = config.getBaseUrl( );
        DesiredCapabilities capabilities = new DesiredCapabilities( );
        capabilities.setCapability("enableVNC", config.isEnableVnc( ));
        capabilities.setCapability("enableVideo", config.isEnableVideo( ));
        browserCapabilities = capabilities;
        remote = config.getRemoteDriver( );


        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/common.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.forEach((key, value) -> setProperty((String) key, (String) value));
    }
}