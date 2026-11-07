package ru.bulgakov.qa.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WsWelcomePage
{
    private final SelenideElement registerButton = $("a.ico-register");
    private final SelenideElement loginButton = $("a.ico-login");

    public WsRegistartionPage openRegistration()
    {
        registerButton.click();
        return new WsRegistartionPage();
    }

    public WsLoginPage openLogin()
    {
        loginButton.click();
        return new WsLoginPage();
    }
}
