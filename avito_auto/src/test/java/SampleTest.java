import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SampleTest {
    private static final String BASE_URL = "https://www.avito.ru";
    private static final String EMAIL = "test_email";
    private static final String PASSWORD = "test_password";


    @Test
    public void logoutTest() {
        System.out.println("hello");
    }

    @Test
    public void loginAvitoTest() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = BASE_URL;
        Configuration.pageLoadTimeout = 150000;
        Selenide.open("/profile/settings");

        $("[name='login']").sendKeys(EMAIL);
        $("[name='password']").sendKeys(PASSWORD);
        $("[name='submit']").click();
        Selenide.open("/sochi/lichnye_veschi?cd=1&d=1");
        $$("[data-marker='catalog-serp']  [itemprop='name']").get(5).click();
        $(byText("Купить с доставкой")).click();
        $("[name='phone']").shouldHave(Condition.value(""));
    }
}
