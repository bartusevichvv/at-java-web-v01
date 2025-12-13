package work.part02;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstLoginTests {

    @Test
    public void test01() {
        open("https://slqa.ru/cases/ChatGPTLogin");

        // Заполняем форму. Правильный логин и пароль
        $("#username").setValue("standard_user");
        $("#password").setValue("secret_sauce");

        // Нажимаем кнопку Login
        $("#loginButton").click();

        // Проверяем наличие приветствия
        $("#greeting").shouldBe(visible);
    }

    @Test
    public void test02() {
        open("https://slqa.ru/cases/ChatGPTLogin");

        // Заполняем форму. Правильный логин и неправильный пароль
        $("#username").setValue("standard_user");
        $("#password").setValue("secret");

        // Нажимаем кнопку Login
        $("#loginButton").click();

        // Проверяем наличие ошибки
        $("#message").shouldBe(visible);
    }

    @Test
    public void test03() {
        open("https://slqa.ru/cases/ChatGPTLogin");

        // Заполняем форму. Правильный логин и пароль и нажимаем Enter
        $("#username").setValue("standard_user");
        $("#password").setValue("secret_sauce");

        // Нажимаем кнопку Login
        $("#loginButton").pressEnter();

        // Проверяем наличие приветствия
        $("#greeting").shouldBe(visible);
    }

    @Test
    public void test04() {
        open("https://slqa.ru/cases/ChatGPTLogin");

        // Заполняем форму. Правильный логин и пароль и выход из системы
        $("#username").setValue("standard_user");
        $("#password").setValue("secret_sauce");

        // Нажимаем кнопку Login
        $("#loginButton").click();
        // Нажимаем кнопку Logout
        $("#logoutButton").click();

        // Должна исчезнуть надпись welcome и снова появится форма входа
        $x("//h2").shouldHave(text("Аутентификация"));
    }
}