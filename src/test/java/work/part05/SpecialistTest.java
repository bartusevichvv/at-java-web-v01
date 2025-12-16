package work.part05;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SpecialistTest {

    @Test
    public void test02() {
        Configuration.pageLoadStrategy = "eager";
        open("https://www.specialist.ru/");
        getWebDriver().manage().window().maximize();

        // Согласие с файлами cookie
        $("#cookieConsent__ok").click(); // Нажатие кнопки "Согласен"

        $x("//a[@class='top-level-menu']").shouldHave(text("Форматы обучения")).click(); // Нажатие кнопки "Форматы обучения"
        $(new By.ByLinkText("Свободное обучение")).scrollIntoView(true).click(); // Нажатие Свободное обучение
        $x("//a[@href='#selectCourse']").click(); // Нажатие Выбрать курс
        $("#Filter_CategoriesDirectionFilter").selectOption(10); // Выбираем "Программирование"
        $("#sendBtn").click(); // Нажатие Применить
        $("body").shouldHave(text("Тестирование ПО"));

    }
}
