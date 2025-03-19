package com.seleniumAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;
import com.seleniumAutomation.utils.BaseTest;

public class CheckoutTests extends BaseTest {
    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUpTest() {
        LoginPage loginPage = new LoginPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void testSuccessfulCheckout() {
        checkoutPage.completePurchase("Elian", "Fernandez", "12345");
        Assert.assertTrue(checkoutPage.getConfirmationMessage().contains("Thank you for your order!"),"El mensaje de confirmación de compra no es el esperado");
    }

    @Test
    public void testCheckoutWithoutInfo() {
        checkoutPage.startCheckout();
        checkoutPage.clickContinueWithoutInfo();
        Assert.assertTrue(checkoutPage.getErrorMessage().contains("First Name is required"),"El mensaje de error no indica que falta el nombre");
    }
}