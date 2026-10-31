package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LavaPage
{

    private final SelenideElement priceTitle = $("h3[data-at='H3'][class*='price']");

    public LavaPage checkPrice(String expectedPrice)
    {
        priceTitle
            .shouldBe(visible, Duration.ofSeconds(15))
            .shouldHave(exactText(expectedPrice));

        return this;
    }
}