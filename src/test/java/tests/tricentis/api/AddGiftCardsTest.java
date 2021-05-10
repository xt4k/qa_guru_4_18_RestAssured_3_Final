package tests.tricentis.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.pojo.Form;
import tests.tricentis.BaseTest;

import java.util.Random;


@Epic("Rest Assured")
@Feature("Web-shop")
@Story("Api testset for add Gift Cards to wishlist")
@Owner("yuriy")
@Tag("wish_api")
public class AddGiftCardsTest extends BaseTest {

    private ApiScenario apiTest = new ApiScenario();

    @Test
    @DisplayName("Test Api_01: Add Virtual gift card 5$.")
    void senVirtualGiftCard5Success() {
        int cardNums = 1 + new Random().nextInt(11);
        int index = 1;
        //GiftCard giftCard = new GiftCard();
        String suffix = "addproducttocart/details/1/2";
        Form form = new Form(cardNums, suffix);
        apiTest.apiVirtualGiftCardScenarioPositive(form);
    }

    @Test
    @DisplayName("Test Api_02: Add Physical gift card 50$.")
    void senPhysicalGiftCard50Success() {
        int cardNums = 2 + new Random().nextInt(22);
        int index = 3;
        //GiftCard giftCard = new GiftCard();
        String suffix = "addproducttocart/details/3/2";
        Form form = new Form(cardNums, suffix);
        apiTest.apiPhysicalGiftCardScenarioPositive(form);
    }
}
