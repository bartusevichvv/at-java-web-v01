package work.part05;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class KinoTest {
    @BeforeEach
    void setUp() {

        Configuration.pageLoadStrategy = "eager";
    }
    @ParameterizedTest
    @CsvFileSource(resources = "cinema_test.csv", numLinesToSkip = 1)
    void test01(String film, String date, String start, String age, String result) {

        open("http://92.51.36.108:7777/sl.qa/cinema/index.php");
        $("input[name=age]").setValue(age);
        $("input[name='date']").setValue(date); // Дата в формате YYYY-MM-DD
        $("input[name=session][value='" + start + "']").click();
        $("input[name=film][value=" + film + "]").click();
        $("input[type=submit").click();
        $("div").shouldHave(text(result));
        sleep(1_000);
    }
}
