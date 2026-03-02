package ui.tests;

import org.testng.annotations.Test;
import ui.pages.InventoryPage;
import ui.pages.LoginPage;

public class LoginPageTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        loginPage.fillUsername("standard_user");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickLoginBtn();
        inventoryPage.verifyInventoryPageOpened();
    }

    @Test
    public void addToCartTest() {
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        loginPage.logIn("standard_user", "secret_sauce");
        inventoryPage.clickAddBackpackToCartBtn();
        inventoryPage.goToCartPage();
        inventoryPage.verifyBackpackItemAddedToCart();
    }

    @Test
    public void successfulLogoutTest() {
        InventoryPage inventoryPage = new InventoryPage();
        LoginPage loginPage = new LoginPage();
        loginPage.logIn("standard_user", "secret_sauce");
        inventoryPage.openMenu();
        inventoryPage.clickLogoutBtn();
        loginPage.verifyLoginPageIsOpened();
    }
}
