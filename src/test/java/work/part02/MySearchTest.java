go


        package work.part02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MySearchTest {
    @Test
    public void testElementSearchMethods() {
        open("https://slqamsk.github.io/demo/search-demo/");

        element(By.id("user-password")).shouldBe(visible);
        $(By.id("user-password")).shouldBe(visible);

        $(By.name("user_email")).shouldBe(visible);
        $(By.className("btn")).shouldBe(visible);
        $(By.tagName("h3")).shouldBe(visible);
        $(By.linkText("Регистрация нового пользователя в системе")).shouldBe(visible);
        $(By.partialLinkText("Контакты")).shouldBe(visible);
    }
}