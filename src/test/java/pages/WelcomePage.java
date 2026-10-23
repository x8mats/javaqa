package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WelcomePage
{
    private final ElementsCollection menuItems = $$(".t-menu__list li");
    private final SelenideElement action = $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a");
    private final SelenideElement pay = $(byText("Бегу оплачивать"));

    public WelcomePage clickPrice()
    {
        menuItems.last().click();
        return this;
    }

    public WelcomePage vkatun()
    {
        action.click();
        return this;
    }

    public WelcomePage proceedPayment()
    {
        pay.click();
        return this;
    }

}