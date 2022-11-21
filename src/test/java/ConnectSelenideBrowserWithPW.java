import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class ConnectSelenideBrowserWithPW {
    public static void main(String[] args) {


    Playwright playwright = Playwright.create();
    Browser chrome = playwright.chromium().launch(new BrowserType.LaunchOptions()
            .setHeadless(true)
            .setChannel("chrome")
            .setArgs(List.of("--remote-debugging-port=9222"))
    );
     Page page = chrome.newPage();
     page.navigate("https://datatables.net/examples/data_sources/dom.html");
}
}