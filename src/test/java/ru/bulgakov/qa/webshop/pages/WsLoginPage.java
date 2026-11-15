package ru.bulgakov.qa.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsLoginPage
{
    private final SelenideElement pageTitle = $("div.page-title");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement boxRememberMe = $("input#RememberMe");
    private final SelenideElement clickLogin = $("input.login-button");
    private final ElementsCollection headerLinks = $$("div.header-links ul li a");

    @Step("Проверка что пользователь не залогинен")
    public WsLoginPage checkLoginPageOpened()
    {
        pageTitle.shouldHave(text("Welcome, Please Sign In!"));
        return this;
    }

    @Step("Ввести электронную почту {email}")
    public WsLoginPage enterEmail(String email)
    {
        emailInput.setValue(email);
        return this;
    }

    @Step("Ввести пароль {password}")
    public WsLoginPage enterPassword(String password)
    {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Установить галочку Remember Me")
    public WsLoginPage checkRememberMe()
    {
        boxRememberMe.click();
        return this;
    }

    @Step("Подтвердить авторизацию")
    public WsLoginPage submitLogin()
    {
        clickLogin.click();
        return this;
    }

    @Step("Проверка на наличие ошибки валидации пользователя")
    public WsLoginPage verifyEmailValidationErrorAppear()
    {
        $("span.field-validation-error").shouldBe(visible);
        return this;
    }

    @Step("Кликнуть на поле пароля")
    public WsLoginPage clickOnPassword()
    {
        $("#Password.password").click();
        return this;
    }

    @Step("Проверка что пользователь с почтой {email} залогинен")
    public WsLoginPage checkUserLoggedIn(String email)
    {
        headerLinks.get(0).shouldHave(text(email));
        return this;
    }



}


//$("div.page-title").shouldHave(text("Welcome, Please Sign In!"));
//$("input#Email").setValue(email);
//$("input#Password").setValue(password);
//$("input#RememberMe").click();
//$("input.login-button").click();
//$$("div.header-links ul li a").get(0).shouldHave(text(email));