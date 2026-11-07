package ru.bulgakov.qa.webshop.test;

import com.codeborne.selenide.Configuration;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgakov.qa.webshop.pages.WsRegistartionPage;
import ru.bulgakov.qa.webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static ru.bulgakov.qa.webshop.config.Config.WEB_SHOP_REGISTRATION_URL;
import static ru.bulgakov.qa.webshop.config.Config.WEB_SHOP_URL;

public class LoginTest
{
    private static final Faker faker = new Faker();
    private String email;
    private String password;

    @BeforeEach
    void beforeEach()
    {
        email = faker.internet().emailAddress();
        password = faker.harryPotter().character() + faker.number().positive();

        open(WEB_SHOP_REGISTRATION_URL, WsRegistartionPage.class)
                .register(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        email,
                        password)
                .checkUserLoggedIn(email)
                .contReg();

        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @Test
    void successLoginTest() {
        Configuration.holdBrowserOpen = true;

        open(WEB_SHOP_URL, WsWelcomePage.class)
                .openLogin()
                .checkLoginPageOpened()
                .enterEmail(email)
                .enterPassword(password)
                .checkRememberMe()
                .submitLogin()
                .checkUserLoggedIn(email);
    }
}
