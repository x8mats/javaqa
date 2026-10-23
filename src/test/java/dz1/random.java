package dz1;

import PythonEditor.PythonInput;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import pages.YandexSearchPage;

import static com.codeborne.selenide.Selenide.*;

public class random
{
    @Test
    void randomOnlineCompiler()
    {
        Configuration.holdBrowserOpen = true;
        PythonInput editor = new PythonInput();

        open("https://ya.ru", YandexSearchPage.class) //Открыть поисковик яндекс
                .closeDistributionWindow() //Закрытие рекламного окна
                .search("python online compiler") //Вбить в поисковую строку запрос и нажать энтер
                .openSearchResultURL("online-python-compiler.ru"); //Переход по заданной ссылке

        switchTo().window(1);

        editor.insertRandomCode(1, 10)
                .launch();

        int resultNumber = editor.getResultNumber();

        editor.checkResult(resultNumber, 1, 10);
    }
}