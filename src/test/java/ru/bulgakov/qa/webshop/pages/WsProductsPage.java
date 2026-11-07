package ru.bulgakov.qa.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsProductsPage
{
    private final ElementsCollection selectProductComputers = $$("ul.top-menu li a");
    private final SelenideElement selectProductDesktops = $(byText("Desktops"));

    public WsProductsPage hoverComputers()
    {
        selectProductComputers.get(1).hover();
        return this;
    }

    public WsItemPage selectDestops()
    {
        selectProductDesktops.click();
        return new WsItemPage();
    }
}
