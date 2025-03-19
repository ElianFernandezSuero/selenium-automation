package com.seleniumAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;
import com.seleniumAutomation.utils.BaseTest;

public class CartTests extends BaseTest {
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void setUpTest() {
        LoginPage loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void testAddToCart() {
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "1", "El contador del carrito no es correcto");
    }

    @Test
    public void testRemoveFromCart() {
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.removeProductFromCart("Sauce Labs Backpack");
        Assert.assertTrue(inventoryPage.isCartEmpty(), "El carrito no está vacío después de eliminar el producto");
    }

}
