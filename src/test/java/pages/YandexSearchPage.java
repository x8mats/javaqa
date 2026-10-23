package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class YandexSearchPage
{
    private final SelenideElement searchInput = $("#text");
    private final SelenideElement closeDistribution = $(".DistributionButtonClose_view_button");

    public YandexSearchPage closeDistributionWindow()
    {
        if (closeDistribution.exists() && closeDistribution.isDisplayed())
        {
            closeDistribution.click();
        }
        return this;
    }

    //search, submit
    public YandexSearchResultPage search(String query)
    {
        searchInput.setValue(query).pressEnter();
        return new YandexSearchResultPage();
    }


}
