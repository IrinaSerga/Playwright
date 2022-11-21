import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.nio.file.Paths;


import static com.codeborne.selenide.Selenide.*;

/*Файл HAR представляет собой журнал или лог, в котором содержится информация о взаимодействии браузера с веб-страницей,
на базе которой был создан журнал этого типа. Для обычных пользователей файлы HAR не представляют интереса,
но не для веб-мастеров, которые могут создавать HAR-файлы для их последующей отправки в службу технической поддержки,
специалисты которой проанализируют их содержимое и помогут на основе полученной
информации выявить и устранить проблему некорректного отображения контента на веб-странице сайта.*/
public class Har {
    public static void main(String[] args) {


        open("https://datatables.net/examples/api");
    Playwright playwright = Playwright.create();
    // коннект  к сессии селенида по cdp
    Browser browser = playwright.chromium().connectOverCDP(
            ((RemoteWebDriver)webdriver().object())
                    .getCapabilities()
                    .getCapability("se:cdp").toString());

    BrowserContext context = browser.newContext(new Browser.NewContextOptions()
            .setRecordHarPath(Paths.get("example.har"))
            .setRecordHarUrlFilter("**/api/**"));

      Page page =  browser.newPage();
      page.navigate("https://datatables.net/examples/data_sources/dom.html");

      //  $x(".//a[@href=\"./form.html\"]").click();
     page.click("body > div.fw-container > div.fw-nav > div.nav-main > ul > li.sub-active.sub > ul > li:nth-child(5) > a");

// ... Perform actions ...

// Close context to ensure HAR is saved to disk.
      context.close();
      browser.close();
}
}