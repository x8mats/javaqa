package ru.bulgakov.qa.mentor.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class YandexSearchPage
{
    private final SelenideElement searchInput = $("#text");
    private final SelenideElement closeDistribution = $(".DistributionButtonClose_view_button");

    @Step("Закрытие баннерного окна")
    public YandexSearchPage closeDistributionWindow()
    {
        if (closeDistribution.exists() && closeDistribution.isDisplayed())
        {
            closeDistribution.click();
        }
        return this;
    }

    //search, submit
    @Step("Поиск в яндексе по запросу: {query}")
    public YandexSearchResultPage search(String query)
    {
        searchInput.setValue(query).pressEnter();
        return new YandexSearchResultPage();
    }


}
