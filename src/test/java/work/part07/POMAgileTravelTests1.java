package work.part07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import work.part08.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class POMAgileTravelTests1 {
    @BeforeEach
    void setUp() {
        open("Customize Toolbar…");
        getWebDriver().manage().window().maximize();
    }
// ... Автотесты
// 1. Неуспешный логин
    @Test
    void test01WrongPassword1() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("user", "Password");
        loginPage.isLoginUnsuccessful();
    }
}
