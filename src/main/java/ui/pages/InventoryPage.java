package ui.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class InventoryPage {
    private static final SelenideElement cartIcon = $(By.id("shopping_cart_container"));
    private static final SelenideElement addBackpackToCartBtn = $("[data-test='add-to-cart-sauce-labs-backpack']");
    private static final SelenideElement backpackInCart = $("[data-test='item-4-title-link']");
    private static final SelenideElement menuBtn = $(By.id("react-burger-menu-btn"));
    private static final SelenideElement logOutBtn = $("[data-test='logout-sidebar-link']");

    public void verifyInventoryPageOpened() {
        cartIcon.shouldBe(visible);
    }
    public void clickAddBackpackToCartBtn() {
        addBackpackToCartBtn.click();
    }
    public void goToCartPage() {
        cartIcon.click();
    }
    public void verifyBackpackItemAddedToCart() {
        backpackInCart.shouldBe(visible);
    }

    public void openMenu() {
        menuBtn.click();
    }

    public void clickLogoutBtn() {
        logOutBtn.click();
    }


}