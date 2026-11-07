package ru.bulgakov.qa.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsItemPage
{
    private String itemName;
    private String itemPrice;

    private final ElementsCollection findCheapComputer = $$("div.product-grid div");
    private final ElementsCollection optionGroups = $$("div.attributes ul.option-list");
    private final String optionInputSelector = "li input";
    private final SelenideElement findQtyField = $("input.qty-input");
    private final SelenideElement findAddToCartButton = $("input.add-to-cart-button");
    private final SelenideElement findNotifBar = $("div.bar-notification.success");
    private final SelenideElement findCartQty = $("span.cart-qty");
    private final SelenideElement findCartLink = $("a.ico-cart");


    public WsItemPage selectCheapComputer()
    {
        findCheapComputer.get(0).click();
        return this;
    }

    public WsItemPage rememberItemData()
    {
        itemName = $("[itemprop=name]").getText();
        itemPrice = $("[itemprop=price]").getText();
        return this;
    }

    public WsItemPage selectOption(int groupIndex, int optionIndex)
    {
        optionGroups.get(groupIndex).$$(optionInputSelector).get(optionIndex).click();
        return this;
    }

    public WsItemPage enterQty(String itemQuantity)
    {
        findQtyField.setValue(itemQuantity);
        return this;
    }

    public WsItemPage addToCart()
    {
        findAddToCartButton.click();
        return this;
    }

    public WsItemPage checkNotifSuccess()
    {
        findNotifBar.shouldBe(visible);
        return this;
    }

    public WsItemPage checkCartQty(String itemQuantity)
    {
        findCartQty.shouldHave(text( "(" + itemQuantity + ")" ));
        return this;
    }

    public WsCartPage goToCart()
    {
        findCartLink.click();
        return new WsCartPage(itemName, itemPrice);
    }

}
