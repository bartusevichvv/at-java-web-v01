package work.part08.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;

public class PassengerPage {
    SelenideElement
            FirstName = $x("//input[@name='passengerFirstName']"),
            LastName = $x("//input[@name='passengerLastName']"),
            nextButton = $x("//input[@value='Next']"),
            messagePass = $("#body");

    public void passPage(String FName, String LName) {
        this.FirstName.sendKeys(FName);
        this.LastName.selectOption(LName);
        this.nextButton.click();
    }

    public void isPassengerDetails() {
        this.messagePass.shouldHave(text("Pay by Credit Card"));
    }


}

