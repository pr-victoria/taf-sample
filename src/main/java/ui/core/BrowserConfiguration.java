package ui.core;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserConfiguration {

    public void configureBrowser() {
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));

        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.timeout = Long.parseLong(System.getProperty("timeout", "8000"));
        Configuration.pageLoadTimeout = Long.parseLong(System.getProperty("pageLoadTimeout", "20000"));
        Configuration.headless = headless;

        if ("chrome".equalsIgnoreCase(Configuration.browser)) {
            ChromeOptions chromeOpts = new ChromeOptions();
            if (headless) {
                chromeOpts.addArguments("--headless=new", "--disable-gpu", "--window-size=1920,1080",
                        "--no-sandbox", "--disable-dev-shm-usage");
            }
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(ChromeOptions.CAPABILITY, chromeOpts);
            Configuration.browserCapabilities = caps;
        }

        System.out.printf("[Setup] browser=%s, headless=%s, size=%s%n",
                Configuration.browser, headless, Configuration.browserSize);
    }

}
