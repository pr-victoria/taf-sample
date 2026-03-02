package ui.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ui.core.BrowserConfiguration;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    BrowserConfiguration browserConfiguration = new BrowserConfiguration();


    @BeforeMethod
    public void setUp() {
        browserConfiguration.configureBrowser();
        open("https://www.saucedemo.com/");
    }

    @BeforeSuite
    public void setUpAllure() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)       // Скриншоты при падении
                        .savePageSource(true)    // HTML страницы при падении
                        .includeSelenideSteps(true) // Логи шагов Selenide (клики, ввод текста)
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }




}
