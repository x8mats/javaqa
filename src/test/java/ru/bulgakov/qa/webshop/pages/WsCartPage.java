package ru.bulgakov.qa.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class WsCartPage
{
    private final SelenideElement findProductName = $("a.product-name");
    private final SelenideElement findItemQuantity = $("input.qty-input");
    private final SelenideElement findTotalPrice = $("span.product-subtotal");

    private final String itemName;
    private final String itemPrice;

    public WsCartPage(String itemName, String itemPrice)
    {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }


    public WsCartPage verifyProductName()
    {
        findProductName.shouldHave(text(itemName));
        return this;
    }

    public WsCartPage verifyItemQuantity(String itemQuantity)
    {
        findItemQuantity.shouldHave(value(itemQuantity));
        return this;
    }

    public WsCartPage verifyTotalPrice(String itemQuantity)
    {
        float price = Float.parseFloat(itemPrice);
        float quanity = Float.parseFloat(itemQuantity);
        findTotalPrice.shouldHave(text(String.valueOf(price*quanity)));
        return this;
    }
}
