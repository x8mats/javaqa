package ru.bulgakov.qa.mentor;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.bulgakov.qa.mentor.pages.LavaPage;
import ru.bulgakov.qa.mentor.pages.WelcomePage;
import ru.bulgakov.qa.mentor.pages.YandexSearchPage;
import ru.bulgakov.qa.TestBase;

import static com.codeborne.selenide.Selenide.*;

public class SearchTest extends TestBase
{
    @Test
    @DisplayName("Проверить что цена обучения - 47 000 рублей")
    @Tag("Positive")
    @Severity(SeverityLevel.NORMAL)
    @Owner("matsjov")
    @Link(name = "TASK-0")
    void mentoringPriceShouldBe47kTest()
    {
        Configuration.holdBrowserOpen = true;

        open("https://ya.ru", YandexSearchPage.class) //Открыть поисковик яндекс
                .closeDistributionWindow() //Закрытие рекламного окна
                .search("bulgakov qa") //Вбить в поисковую строку запрос и нажать энтер
                .closeDefaultBrowser()
                .openSearchResultURL("-инженер обучение профессии"); //Переход по заданной ссылке

        switchTo().window(1);
        sleep(3000);


        new WelcomePage()
                .clickPrice() // Переход на страницу стоимости
                .vkatun() //Нажать на хочу вкатиться в QA
                .proceedPayment();

        switchTo().window(2);
        sleep(5000);
        new LavaPage()
                .checkPrice("₽ 47 000.00"); //Проверка что в цене есть 47
    }
}
