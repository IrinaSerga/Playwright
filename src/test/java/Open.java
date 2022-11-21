
import com.microsoft.playwright.*;

public class Open {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions());
            Page page = browser.newPage();
            page.navigate("https://datatables.net/examples/data_sources/dom.html");
            System.out.println("Вывод названия страницы " + page.title());
        }
    }
}