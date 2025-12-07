package work.part02;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class testPageH1 {

    @Test
    public void test01() {
        open("https://slqamsk.github.io/tmp/xPath01.html");
        $x("//h1").shouldHave(text("Учебная страница для XPath"));
    }

    @Test
    public void testFindByText() {
        open("https://slqa.ru/cases/xPathSimpleForm/");
        $x("//*[starts-with(.,'Казахстан')]").shouldHave(text("площадь 2 724 902"));
        $x("//*[contains(., 'Москва')]").shouldHave(text("250 единиц"));
        $x("//*[contains(., 'Питер')]").shouldHave(text("180 единиц"));
    }


}
