package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@ExtendWith(TextReportExtension.class)
public class UAMTest {

    @Test
    public void searchForTextInUamPage() {
        clearBrowserCookies();
        open("https://amu.edu.pl/");

        $(By.name("queries_global_search_query")).setValue("informatyka");
        $(By.name("search_page_6856_submit_button")).click();

        $$(By.className("search-result__list-item")).get(3).shouldHave(Condition.text("Kryteria-kwalifikacji_informatyka_2020.pdf"));

    }

    @Test
    public void searchForTextInUamPageEasierWay() {
        clearBrowserCookies();
        open("https://amu.edu.pl/");

        $(By.name("queries_global_search_query")).setValue("informatyka");
        $(By.name("search_page_6856_submit_button")).click();

        $$(By.className("search-result__list-item")).findBy(Condition.text("Kryteria-kwalifikacji_informatyka_2020.pdf")).should(Condition.exist);

    }

}
