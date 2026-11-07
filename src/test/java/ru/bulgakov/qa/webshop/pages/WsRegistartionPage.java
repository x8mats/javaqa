package ru.bulgakov.qa.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

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

    public WsRegistartionPage verifyRegistartionOpened()
    {
        pageTitle.shouldHave(text("Register"));
        return this;
    }

    public WsRegistartionPage selectMaleGender()
    {
        maleGenderRadio.click();
        return this;
    }

    public WsRegistartionPage enterFirstName(String firstName)
    {
        firstNameInput.setValue(firstName);
        return this;
    }

    public WsRegistartionPage enterLastName(String lastName)
    {
        lastNameInput.setValue(lastName);
        return this;
    }

    public WsRegistartionPage enterEmail(String email)
    {
        emailInput.setValue(email);
        return this;
    }

    public WsRegistartionPage enterPassword(String password)
    {
        passwordInput.setValue(password);
        return this;
    }

    public WsRegistartionPage enterConfirmPassword(String confirmPassword)
    {
        confirmPasswordInput.setValue(confirmPassword);
        return this;
    }

    public WsRegistartionPage submitRegistration()
    {
        submitRegistrationButton.click();
        return this;
    }

    public WsRegistartionPage checkRegistrationCompleted()
    {
        resultText.shouldHave(text("Your registration completed"));
        return this;
    }

    public WsRegistartionPage checkUserLoggedIn(String email)
    {
        headerLinks.get(0).shouldHave(text(email));
        return this;
    }

    public WsRegistartionPage contReg()
    {
        findCont.click();
        return this;
    }



}
