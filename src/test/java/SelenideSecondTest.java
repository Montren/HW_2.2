package service;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


class SelenideSecondTest {

    @Test
    void shouldBeSuccessTest() throws InterruptedException {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Москва");
        $(".menu-item__control").click();
        List<SelenideElement> input = new ArrayList<>();
        input = $$(".input__control");
        SelenideElement myData = input.get(1);
        myData.click();
        myData.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

        myData.setValue("05.11.2019");
        $("[data-test-id=name] input").setValue("Иванов Иван");
        $("[data-test-id=phone] input").setValue("+79169161616");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id=notification]").waitUntil(visible, 12000);
    }
}



