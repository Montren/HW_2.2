package service;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


class SelenideSecondTest {


    public String dateGood() {
        LocalDate.now().plusDays(5);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.YYYY");
        String dayPlus5 = format.format(LocalDate.now().plusDays(5));
        return dayPlus5;
    }

    @Test
    void shouldBeSuccessTest() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Кемерово");
        $(".menu-item__control").click();
        List<SelenideElement> input = new ArrayList<>();
        input = $$(".input__control");
        SelenideElement myData = input.get(1);
        myData.click();
        myData.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        myData.setValue(dateGood());
        $("[data-test-id=name] input").setValue("Иванов Иван");
        $("[data-test-id=phone] input").setValue("+79169161616");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id=notification]").waitUntil(visible, 12000);
    }

    public String dateGoodWeek() {
        LocalDate.now().plusDays(7);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.YYYY");
        String dayPlus7 = format.format(LocalDate.now().plusDays(5));
        return dayPlus7;
    }

    @Test
    void shouldBeSuccessTestWithPopupWindows() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Ке");
        $$(".menu-item__control").find(exactText("Кемерово")).click();
        $$("button").first().click();
        $(withText("Вт")).waitUntil(visible, 2000);
        List<SelenideElement> inputCalendar = new ArrayList<>();
        inputCalendar = $$("[data-day]");
        inputCalendar.get(4).click();
        $("[data-test-id=name] input").setValue("Иванов Иван");
        $("[data-test-id=phone] input").setValue("+79169161616");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id=notification]").waitUntil(visible, 12000);
    }
}



