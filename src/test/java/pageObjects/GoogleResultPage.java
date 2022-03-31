package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleResultPage {

    private ElementsCollection elements() {
        return $$(By.className("LC20lb"));
    }


    public GoogleResultPage searchForTextInElement(int index, String text) {
        this.elements().get(index).shouldHave(text(text));
        return this;
    }

}
