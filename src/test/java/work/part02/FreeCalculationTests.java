package work.part02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class FreeCalculationTests {

    @Test
    public void test01() {
        open("https://slqa.ru/cases/fc/v01/");

        $(By.name("sum")).sendKeys("500");
        $(By.name("submit")).click();
        $(By.name("sum")).type("2500");
        $(By.name("submit")).click();
        $(By.name("sum")).setValue("2500");
        $(By.name("submit")).click();


    }
}