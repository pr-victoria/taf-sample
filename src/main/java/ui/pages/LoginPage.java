package ui.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement username = $(By.id("user-name"));
    private final SelenideElement password = $(By.id("password"));
    private final SelenideElement loginBtn = $(By.id("login-button"));


    public void fillUsername(String username) {
        this.username.setValue(username);
    }

    public void fillPassword(String password) {
        this.password.setValue(password);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void verifyLoginPageIsOpened() {
        username.shouldBe(visible);
    }

    public void logIn(String username, String password) {
        fillUsername(username);
        fillPassword(password);
        clickLoginBtn();
    }
}

