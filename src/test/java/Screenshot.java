import com.microsoft.playwright.*;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;


public class Screenshot {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser chromium = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
            //.setSlowMo(50) - замедлить
            Page page = chromium.newPage();
            page.navigate("https://datatables.net/examples/data_sources/dom.html");

            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("ChromeScreen.png")));
            System.out.println("Скриншот от chromium готов");

            Browser firefox = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
            //.setSlowMo(50) - замедлить
            Page pagefirefox = firefox.newPage();
            pagefirefox.navigate("https://datatables.net/examples/data_sources/dom.html");

            pagefirefox.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("firefoxScreen.png")));
            System.out.println("Скриншот от firefox готов");

            Browser webkit = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            //.setSlowMo(50) - замедлить
            Page pagewebkit = webkit.newPage();
            pagewebkit.navigate("https://datatables.net/examples/data_sources/dom.html");

            pagewebkit.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("webkitScreen.png")));
            System.out.println("Скриншот от webkit готов");


            CompletableFuture.runAsync(() -> {
                // method call or code to be asynch.
            });
            //-- для нескольких браузеров

        }
    }
}