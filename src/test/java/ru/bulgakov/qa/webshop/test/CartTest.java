package ru.bulgakov.qa.webshop.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgakov.qa.webshop.pages.WsProductsPage;
import ru.bulgakov.qa.webshop.steps.AuthSteps;

import static com.codeborne.selenide.Selenide.*;
import static ru.bulgakov.qa.webshop.config.Config.WEB_SHOP_URL;

public class CartTest
{
    private final AuthSteps authSteps = new AuthSteps();


    @BeforeEach
    void beforeEach()
    {
        authSteps.registerNewUser();
    }

    @Test
    void addItemToCartTest()
    {
        Configuration.holdBrowserOpen = true;

        String itemQuantity = "2";

        open(WEB_SHOP_URL, WsProductsPage.class)
                .hoverComputers()
                .selectDestops()
                .selectCheapComputer()
                .rememberItemData()
                .selectOption(0,0)
                .enterQty(itemQuantity)
                .addToCart()
                .checkNotifSuccess()
                .checkCartQty(itemQuantity)
                .goToCart()
                .verifyProductName()
                .verifyItemQuantity(itemQuantity)
                .verifyTotalPrice(itemQuantity);
    }
}
