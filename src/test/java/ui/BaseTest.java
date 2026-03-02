package ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import org.testng.annotations.BeforeClass;
import io.qameta.allure.selenide.AllureSelenide;

import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeClass
    public void setUp() {
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

}
