package work.part02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.devtools.v131.debugger.Debugger.pause;

public class FreeCalculationTests {

    @Test
    public void test01() {
        open("https://slqa.ru/cases/fc/v01/");

        $(By.name("sum")).sendKeys("500");
        $(By.name("submit")).click();

        $x("//input[@name='sum']").setValue("2500");
        $(By.name("submit")).click();

        $x("//input[@name='sum']").setValue("5500");
        $(By.name("submit")).click();

    }
}