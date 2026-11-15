package ru.bulgakov.qa.webshop.test;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.bulgakov.qa.TestBase;
import ru.bulgakov.qa.webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static ru.bulgakov.qa.webshop.config.Config.WEB_SHOP_URL;

public class RegistrationTest extends TestBase{
    private static final Faker faker = new Faker();

    @BeforeAll
    static void before() {Configuration.browserSize = "1920*1080";}

    @Test
    @Owner("me")
    @Tag("positive")
    @Severity(CRITICAL)
    @Epic("Авторизация")
    @Feature("Регистрация")
    @Story("Регистрация нового пользователя")
    @Link("TASK-2")
    @DisplayName("Успешная регистрация нового пользователя")
    @Description("Создаем нового пользователя со случайными данными через интерфейс")
    void a(){
        String email = faker.internet().emailAddress();
        String password = faker.harryPotter().character() + faker.number().positive();

        open(WEB_SHOP_URL, WsWelcomePage.class)
                .openRegistration()
                .verifyRegistartionOpened()
                .selectMaleGender()
                .enterFirstName(faker.name().firstName())
                .enterLastName(faker.name().lastName())
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmPassword(password)
                .submitRegistration()
                .checkRegistrationCompleted()
                .checkUserLoggedIn(email)
                .contReg();
    }
}