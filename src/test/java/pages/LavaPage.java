package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LavaPage
{

    private final SelenideElement priceTitle = $("h3[data-at='H3'][class*='price']");

    public LavaPage checkPrice(String expectedPrice)
    {
        priceTitle
                .shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(text(expectedPrice));
        return this;
    }
}