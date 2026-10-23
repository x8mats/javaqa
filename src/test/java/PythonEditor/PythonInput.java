package PythonEditor;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PythonInput
{
    private final SelenideElement findLaunch = $(byText("Запуск"));
    private final SelenideElement output = $("#output");

    public PythonInput insertRandomCode(int min, int max)
    {
        String codeToInsert = "import random\n\nprint(random.randint(%d, %d))".formatted(min, max);
        executeJavaScript("ace.edit(document.querySelector('.ace_editor')).setValue(arguments[0]);", codeToInsert);
        return this;
    }

    public PythonInput launch()
    {
        findLaunch.click();
        return this;
    }

    public int getResultNumber()
    {
        String outputText = output.shouldBe(visible).getValue();
        String firstLine = outputText.split("\n")[0].trim();
        return Integer.parseInt(firstLine);
    }

    public PythonInput checkResult(int resultNumber, int min, int max)
    {
        Assertions.assertTrue(resultNumber >= min && resultNumber <= max,
                "Результат " + resultNumber + " вне диапазона " + min + "-" + max);
        return this;
    }
}
