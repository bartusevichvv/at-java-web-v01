package work.part02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.devtools.v131.debugger.Debugger.pause;

public class SimpleFormTest {
    @BeforeEach
    void setUp() {
        open("https://slqa.ru/cases/SimpleForm/");
    }

    @Test
    void test01_specific_commands() {
        System.out.println("Начали тест test01_specific_commands");

        $("#unique_id").type("Текст для поля № 1");
        $("[name=unique_name]").type("Текст для поля № 2");
        $x("//blockquote[contains(., 'спрашивает')]");
        $(".unique_class").shouldBe(visible);

        System.out.println("Закончили тест test01_specific_commands");
    }
}

