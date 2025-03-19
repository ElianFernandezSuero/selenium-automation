package com.seleniumAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import com.seleniumAutomation.utils.BaseTest;

public class InventoryTests extends BaseTest {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void testInventoryLoad() {
        Assert.assertTrue(
                inventoryPage.areProductsDisplayed(),
                "Los productos no se están mostrando en el inventario"
        );
    }
}