package com.seleniumAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import com.seleniumAutomation.utils.BaseTest;


public class ErrorUserTests extends BaseTest {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);

        loginPage.login("error_user", "secret_sauce");
    }

    @Test
    public void testAddMoreThanTwoArtToTheCart() {
        inventoryPage.addMultipleItemsToCart(3);
        inventoryPage.goToCart();
        Assert.assertEquals(cartPage.getCartItemCount(), 2, "Se agregaron los 3 articulos correctamente");
    }

    @Test
    public void testRemoveOneArt() {
        inventoryPage.addMultipleItemsToCart(1);
        inventoryPage.removeItemFromCart();
        inventoryPage.goToCart();
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Se ha eliminado el articulo correctamente");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
