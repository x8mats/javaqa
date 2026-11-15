package ru.bulgakov.qa.mentor.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WelcomePage
{
    private final ElementsCollection menuItems = $$(".t-menu__list li");
    private final SelenideElement action = $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a");
    private final SelenideElement pay = $(byText("Бегу оплачивать"));

    @Step("Клик на цену")
    public WelcomePage clickPrice()
    {
        menuItems.last().click();
        return this;
    }

    @Step("Переход на вкладку вкатиться")
    public WelcomePage vkatun()
    {
        action.click();
        return this;
    }

    @Step("Переход на страницу оплаты")
    public WelcomePage proceedPayment()
    {
        pay.click();
        return this;
    }

}