package work.part02;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v131.browser.Browser;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;

public class AuthorizationTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = Browsers.FIREFOX;
    }

    @Test
    public void test01LoginSuccess() {

        open("https://slqamsk.github.io/cases/slflights/v01/");

        $("input[id=username]").sendKeys("standard_user");
        $("input[id=password]").sendKeys("stand_pass1");
        $("button[id=loginButton]").click();
        $(By.id("flightForm")).shouldBe(visible);

    }
    @Test
   public void test02LoginWrongPassword() {
        open("https://slqamsk.github.io/cases/slflights/v01/");

        $("input[id=username]").sendKeys("standard_user");
        $("input[id=password]").sendKeys("eeeeeeeeee");
        $(By.id("loginButton")).click();
        $(By.id("message")).shouldBe(visible);
    }
}