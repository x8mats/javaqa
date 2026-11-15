package ru.bulgakov.qa.mentor.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class YandexSearchResultPage {
    private final SelenideElement splashModal = $(".DistributionSplashScreenModalContent");
    private final SelenideElement findDefaultBrowserNotNow = splashModal.$(byText("Не сейчас"));
    private final SelenideElement findDefaultBrowserContinue = splashModal.$(".DistributionButtonClose");

    private final SelenideElement sitesUnavailableTitle = splashModal.$(withText("сайты недоступны"));
    private final SelenideElement sitesUnavailableOkButton = splashModal.$(byText("OK"));

    @Step("Закрытие баннерых окон")
    public YandexSearchResultPage closeDefaultBrowser() {
        SelenideElement content = $(".DistributionSplashScreenModalContent");
        if (!content.is(Condition.visible, Duration.ofSeconds(5))) {
            return this;
        }

        SelenideElement cancelRadio = content.$("input[value='cancel']");
        SelenideElement closeBtn = content.$("button.DistributionButtonClose");

        if (cancelRadio.exists() && closeBtn.exists()) {
            cancelRadio.parent().parent().click();   // label "Не сейчас"
            closeBtn.click();                        // button "Продолжить"
        } else {
            executeJavaScript(
                    "document.querySelectorAll('.Modal, .Modal-Cell, .DistributionSplashScreenModalScene')" +
                            ".forEach(e => e.remove());");
        }

        content.shouldNotBe(Condition.visible, Duration.ofSeconds(3));
        return this;
    }

    @Step("Открытие ссылки по тексту: {webSiteName}")
    public WelcomePage openSearchResultURL(String webSiteName)
    {
        $(byText(webSiteName)).click();
        return new WelcomePage();
    }
}
