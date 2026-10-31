package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LavaPage;
import pages.WelcomePage;
import pages.YandexSearchPage;

import static com.codeborne.selenide.Selenide.*;

public class SearchTest
{
    @Test
    @DisplayName("Проверить что цена обучения - 47 000 рублей")
    @Tag("Positive")
    void mentoringPriceShouldBe47kTest()
    {
        Configuration.holdBrowserOpen = true;

        open("https://ya.ru", YandexSearchPage.class) //Открыть поисковик яндекс
                .closeDistributionWindow() //Закрытие рекламного окна
                .search("bulgakov qa") //Вбить в поисковую строку запрос и нажать энтер
                .openSearchResultURL("-инженер обучение профессии"); //Переход по заданной ссылке

        switchTo().window(1);
        sleep(3000);

        //System.out.println($$(".t-menu__list li").size());

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
