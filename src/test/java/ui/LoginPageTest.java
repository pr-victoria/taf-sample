package ui;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import ui.pages.InventoryPage;
import ui.pages.LoginPage;

@Slf4j
public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        loginPage.fillUsername("standard_user");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickLoginBtn();
        inventoryPage.verifyInventoryPageOpened();
    }

    @Test(priority = 2)
    public void addToCartTest() {
        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.clickAddBackpackToCartBtn();
        inventoryPage.goToCartPage();
        inventoryPage.verifyBackpackItemAddedToCart();
    }

    @Test(priority = 3)
    public void successfulLogoutTest() {
        InventoryPage inventoryPage = new InventoryPage();
        LoginPage loginPage = new LoginPage();
        inventoryPage.openMenu();
        inventoryPage.clickLogoutBtn();
        loginPage.verifyLoginPageIsOpened();
    }
}
