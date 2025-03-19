package com.seleniumAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import com.seleniumAutomation.utils.BaseTest;

public class ProblemUserTests extends BaseTest {
    private LoginPage loginPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage(driver);
        checkoutPage = new CheckoutPage(driver);

        loginPage.login("problem_user", "secret_sauce");
    }


    @Test
    public void testErrorFormularioLastName() {
        checkoutPage.startCheckout();
        checkoutPage.enterFirstName("Juan");
        checkoutPage.enterLastName("Perez");
        checkoutPage.enterPostalCode("12345");
        checkoutPage.clickContinueWithoutInfo();

        String errorMessage = checkoutPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Error: Last Name is required", "El error esperado no se mostró.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
