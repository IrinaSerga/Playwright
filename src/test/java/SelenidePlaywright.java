import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.microsoft.playwright.*;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SelenidePlaywright {

    public static void main(String[] args) {
        // false - полная тяжеловесная версия страницы
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        open("https://datatables.net/examples/api");

        Playwright playwright = Playwright.create();
        // коннект  к сессии селенида по cdp
        playwright.chromium().connectOverCDP(
                ((RemoteWebDriver)webdriver().object())
                        .getCapabilities()
                        .getCapability("se:cdp").toString());


        $x(".//a[@href=\"./form.html\"]").click();

        List<SelenideElement> inputs = $$x(".//table[@id=\"example\"]//input");
        inputs.forEach(s -> s.setValue("1"));



    }
}
