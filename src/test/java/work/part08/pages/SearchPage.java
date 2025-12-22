package work.part08.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;

public class SearchPage {
    SelenideElement
            cityFrom = $x("//select[@name='fromPort']"),
            cityTo = $x("//select[@name='toPort']"),
            tripType = $x("//input[@value='oneway']"),
            departDay = $("#departDay"),
            departMonth = $("#departMonth"),
            continueButton = $x("//input[@value='Continue']"),
            message = $("#body");


    public void search(String departureDate, String departureMonth, String from, String to) {
        this.tripType.click();
        this.departDay.selectOption(departureDate);
        this.departMonth.setValue(departureMonth);
        this.cityFrom.selectOption(from);
        this.cityTo.selectOption(to);
        this.continueButton.click();
    }

    public void isPassengerDetails() {
        this.message.shouldHave(text("Passenger Details"));
    }
}