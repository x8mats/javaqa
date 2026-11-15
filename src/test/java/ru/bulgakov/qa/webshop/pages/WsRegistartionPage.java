package ru.bulgakov.qa.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsRegistartionPage
{
    private final SelenideElement maleGenderRadio = $("input#gender-male");
    private final SelenideElement pageTitle = $("div.page-title");
    private final SelenideElement firstNameInput = $("input#FirstName");
    private final SelenideElement lastNameInput = $("input#LastName");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement confirmPasswordInput = $("input#ConfirmPassword");
    private final SelenideElement submitRegistrationButton = $("input#register-button");
    private final SelenideElement resultText = $("div.result");
    private final ElementsCollection headerLinks = $$("div.header-links ul li a");
    private final SelenideElement findCont = $(".register-continue-button");

    @Step("Регистрация пользователя с именем {firstName}, фамилией {lastName}, почтой {email}, паролем {password}")
    public WsRegistartionPage register(String firstName, String lastName, String email, String password)
    {
            selectMaleGender()
            .enterFirstName(firstName)
            .enterLastName(lastName)
            .enterEmail(email)
            .enterPassword(password)
            .enterConfirmPassword(password)
            .submitRegistration()
            .checkRegistrationCompleted();
        return this;
    }

    @Step("Проверка что открыта страница регистрации")
    public WsRegistartionPage verifyRegistartionOpened()
    {
        pageTitle.shouldHave(text("Register"));
        return this;
    }

    @Step("Выбор мужского пола")
    public WsRegistartionPage selectMaleGender()
    {
        maleGenderRadio.click();
        return this;
    }

    @Step("Установка имени: {firstName}")
    public WsRegistartionPage enterFirstName(String firstName)
    {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Установка фамилии: {lastName}")
    public WsRegistartionPage enterLastName(String lastName)
    {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Установка почты: {email}")
    public WsRegistartionPage enterEmail(String email)
    {
        emailInput.setValue(email);
        return this;
    }

    @Step("Установка пароля: {password}")
    public WsRegistartionPage enterPassword(String password)
    {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Подтверждения пароля {confirmPassword}")
    public WsRegistartionPage enterConfirmPassword(String confirmPassword)
    {
        confirmPasswordInput.setValue(confirmPassword);
        return this;
    }

    @Step("Подтверждение регистрации")
    public WsRegistartionPage submitRegistration()
    {
        submitRegistrationButton.click();
        return this;
    }

    @Step("Проверка успешности регистрации")
    public WsRegistartionPage checkRegistrationCompleted()
    {
        resultText.shouldHave(text("Your registration completed"));
        return this;
    }

    @Step("Проверка что пользователь с почтой {email} залогинен")
    public WsRegistartionPage checkUserLoggedIn(String email)
    {
        headerLinks.get(0).shouldHave(text(email));
        return this;
    }

    @Step("Переход по кнопке продолжить")
    public WsRegistartionPage contReg()
    {
        findCont.click();
        return this;
    }



}
