package pageObjects;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class GoogleHomePage {

    public GoogleHomePage open() {
        Selenide.open("https://www.google.com");
        return this;
    }

    public GoogleHomePage acceptCookies() {
        $(byId("L2AGLb")).click();
        return this;
    }

    public void search(String text) {
        $("input[name=q]").setValue(text).pressEnter();
    }

}
