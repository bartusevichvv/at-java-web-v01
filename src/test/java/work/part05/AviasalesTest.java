package work.part05;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AviasalesTest {

    @Test
    public void test01() {
        //Configuration.browser = Browsers.FIREFOX;
        Configuration.pageLoadStrategy = "eager";
        open("https://www.aviasales.ru/");
        //getWebDriver().manage().window().maximize();

        $("#avia_form_origin-input").sendKeys("Санкт-Петербург");
        //sleep(2000);
        $("#avia_form_destination-input").sendKeys("Москва");
        //sleep(2000);
        $x("//button[@data-test-id='start-date-field']").click();
        //sleep(4000);
        $x("//td[@data-day='2025-12-20']").click();
        //sleep(2000);
        $x("//button[@data-test-id='end-date-field']").click();
        //sleep(2000);
        $x("//td[@data-day='2026-01-20']").click();
        //sleep(2000);
        $x("//button[@data-test-id='form-submit']").click();


    }//td[data-day='2025-12-20']
}
