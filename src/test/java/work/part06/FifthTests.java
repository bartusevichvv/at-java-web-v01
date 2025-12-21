package work.part06;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class FifthTests {
    @BeforeAll
    static void beforeAll(TestInfo test_info) {
        Configuration.browser = "chrome"; // "chrome", "firefox", "edge"
    }

    @Test
    void test01() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $("#username").sendKeys("Non_user");
        $("#password").sendKeys("stand_pass1");
        $("#loginButton").click();
        $("#message").shouldHave(text("Неверное имя пользователя или пароль."));

        $("#username").sendKeys("standard_user");
        $("#password").sendKeys("stand_pass1");
        $("#loginButton").click();




        //$("#departureDate").click();

    }


}
