package ru.bulgakov.qa.webshop.test;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.bulgakov.qa.TestBase;
import ru.bulgakov.qa.webshop.pages.WsLoginPage;
import ru.bulgakov.qa.webshop.pages.WsRegistartionPage;
import ru.bulgakov.qa.webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static ru.bulgakov.qa.webshop.config.Config.*;

public class LoginTest extends TestBase
{
    private static final Faker faker = new Faker();
    private String email;
    private String password;

    @Nested
    public class PositiveTests{
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
        @DisplayName("Проверка успешности логина")
        @Severity(SeverityLevel.CRITICAL)
        @Owner("matsjov")
        @Link(name = "TASK-3")
        void successLoginTest()
        {
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


    @ParameterizedTest(name="Авторизация с невалидным email: {0}")
    @CsvFileSource(resources = "/email.csv")
    @Severity(SeverityLevel.MINOR)
    @Owner("matsjov")
    @Link(name = "TASK-3.1")
    void ivalidEmailLoginTest(String email){
        open(WEB_SHOP_LOGIN_URL, WsLoginPage.class)
                .enterEmail(email)
                .clickOnPassword()
                .verifyEmailValidationErrorAppear();
    }
}
