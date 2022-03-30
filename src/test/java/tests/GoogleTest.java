package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith(TextReportExtension.class)
public class GoogleTest {

    SelenideElement cookieAcceptButton = $(byId("L2AGLb"));
    SelenideElement searchBox = $("input[name=q]");
    SelenideElement searchButton = $("input[name=btnK]");
    SelenideElement numberFive = $("div[jsname=Ax5wH]");
    SelenideElement numberFour = $(by("jsname", "xAP7E"));
    SelenideElement plusButton = $("div[jsname=XSr6wc]");
    SelenideElement equalsButton = $("div[jsname=Pt8tGc]");
    SelenideElement result = $(By.id("cwos"));
    SelenideElement googleLogo = $("img[alt=Google]");

    @BeforeAll
    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.google.com";
    }

    @BeforeEach
    public void prepareEnv() {
        clearBrowserCookies();
    }

    @Test
    public void searchSelenideInGoogle() {
        open("/");

        $(byId("L2AGLb")).click();

        $("img[alt=Google]").shouldBe(visible);

        $("input[name=q]").val("kalkulator");
        $("input[name=btnK]").click();

        $(by("jsname", "xAP7E")).click();
        $("div[jsname=XSr6wc]").click();
        $("div[jsname=Ax5wH]").click();
        $("div[jsname=Pt8tGc]").click();

        $(By.id("cwos")).shouldHave(text("9"));
    }

    @Test
    public void searchSelenideInGoogle2() {
        open("/");

        cookieAcceptButton.click();

        googleLogo.shouldBe(visible);

        searchBox.val("kalkulator");
        searchButton.click();

        numberFour.click();
        plusButton.click();
        numberFive.click();
        equalsButton.click();

        result.shouldHave(text("9"));
    }
}
