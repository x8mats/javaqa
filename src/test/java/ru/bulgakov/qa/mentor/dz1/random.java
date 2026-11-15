package ru.bulgakov.qa.mentor.dz1;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import ru.bulgakov.qa.TestBase;
import ru.bulgakov.qa.mentor.PythonEditor.PythonInput;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import ru.bulgakov.qa.mentor.pages.YandexSearchPage;

import static com.codeborne.selenide.Selenide.*;

public class random extends TestBase
{
    @Test
    @DisplayName("Проверка рандомизиатора python")
    @Severity(SeverityLevel.MINOR)
    @Owner("matsjov")
    @Link(name = "TASK-1")
    void randomOnlineCompiler()
    {
        Configuration.holdBrowserOpen = true;
        PythonInput editor = new PythonInput();

        open("https://ya.ru", YandexSearchPage.class) //Открыть поисковик яндекс
                .closeDistributionWindow() //Закрытие рекламного окна
                .search("python online compiler") //Вбить в поисковую строку запрос и нажать энтер
                .closeDefaultBrowser()
                .openSearchResultURL("online-python-compiler.ru"); //Переход по заданной ссылке

        switchTo().window(1);

        editor.insertRandomCode(1, 10)
                .launch();

        int resultNumber = editor.getResultNumber();

        editor.checkResult(resultNumber, 1, 10);
    }
}