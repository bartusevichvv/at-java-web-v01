package work.part08.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class LoginPage {
    SelenideElement
            username,
            password,
            loginButton,
            errorMessage,
            okMessage,
            outButton;

    public LoginPage() {
        username = $("#username");
        password = $("#password");
        loginButton = $x("//input[@name='commit']");
        errorMessage = $("#flash_alert");
        okMessage = $("#flash_notice");
        outButton = $x("//a[@href='/logout']");
    }

    @Step("Вход в систему")
    public void login(String username, String password) {
        this.username.setValue(username);
        this.password.setValue(password);
        this.loginButton.click();
    }

    @Step("Выход из системы")
    public void loginOut() {
        this.outButton.click();
    }

    @Step("Неуспешный логин")
    public void isLoginUnsuccessful() {
        this.errorMessage.shouldHave(text("Invalid email or password"));
    }

    @Step("Успешный логин")
    public void isLoginSuccessful() {
        this.okMessage.shouldHave(text("Signed in!"));
    }
}