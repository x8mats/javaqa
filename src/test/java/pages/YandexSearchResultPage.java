package pages;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class YandexSearchResultPage
{
    public WelcomePage openSearchResultURL(String webSiteName)
    {
        $(byText(webSiteName)).click();
        return new WelcomePage();
    }
}


