package work.part08.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CardPage {
    SelenideElement
            CardType = $x("//input[@value='visa']"),
            CardName = $x("//input[@name='card_number']"),
            ExpiryMonth = $x("//select[@name='expiry_month']"),
            ExpiryYear = $x("//select[@name='expiry_year']"),
            ButtonPay = $x("//input[@value='Pay now']"),
            messageCard = $("#confirmation");

    public void card(String CardName, String ExpiryInMonth, String ExpiryInYear) {
        this.CardName.sendKeys(CardName);
        this.CardType.click();
        this.ExpiryMonth.selectOption(ExpiryInMonth);
        this.ExpiryYear.selectOption(ExpiryInYear);
        this.ButtonPay.click();
        this.messageCard.shouldHave(text("Confirmation"));
    }
}