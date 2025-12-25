package work.part08;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import work.part08.pages.LoginPage;
import work.part08.pages.PassengerPage;
import work.part08.pages.SearchPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;




@TestMethodOrder(MethodOrderer.DisplayName.class)
public class POMAgileTravelTests {
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        //Configuration.timeout = 6000;
    }

    @BeforeEach
    void setUp() {
        Configuration.browser = Browsers.FIREFOX;
        open("https://travel.agileway.net/");
        getWebDriver().manage().window().maximize();
    }
    // ... Автотесты
    // 1. Неуспешный логин
    @Test
    void test01WrongPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("user", "Password");
        loginPage.isLoginUnsuccessful();
    }

    // 2. Успешный логин
    @Test
    void test01OkPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("agileway", "test$W1se");
        sleep(15000);
        loginPage.isLoginSuccessful();
    }

    // 3. Выход из системы
    @Test
    void test01OLoginOut() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("agileway", "test$W1se");
        loginPage.isLoginSuccessful();
        loginPage.loginOut();
    }

    //4. Успешный поиск рейсов
    @Test
    void test02SuccessSearchFlight() {
        // Страница логина
        LoginPage loginPage = new LoginPage();
        loginPage.login("agileway", "test$W1se");
        loginPage.isLoginSuccessful();

        // Страница поиска рейсов
        SearchPage searchPage = new SearchPage();
        searchPage.search("01", "January 2026", "New York", "Sydney");
    }

    //5. Ввод фамилии и имени
    @Test
    void test02EnterName() {
        // Страница логина
        LoginPage loginPage = new LoginPage();
        loginPage.login("agileway", "test$W1se");
        //loginPage.isLoginSuccessful();

        // Страница поиска рейсов
        SearchPage searchPage = new SearchPage();
        searchPage.search("01", "January 2026", "New York", "Sydney");

        // Ввод фамилии и имени
        PassengerPage passengerPage = new PassengerPage();
        passengerPage.passPage("Ivan", "Ivanov");

    }
}
