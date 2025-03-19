package com.seleniumAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import com.seleniumAutomation.utils.BaseTest;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage(driver);
    }

    @Test(dataProvider = "validUsers")
    public void testSuccessfulLogin(String username) {
        loginPage.login(username, "secret_sauce");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "Login fallido para el usuario: " + username
        );
    }

    @DataProvider(name = "validUsers")
    public Object[][] getValidUsers() {
        return new Object[][] {
                { "standard_user" },
                { "problem_user" },
                { "performance_glitch_user" },
                { "error_user" },
                { "visual_user" }
        };
    }

    @Test
    public void testLockedOutUserLogin() {
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Sorry, this user has been locked out."),
                "No se mostró el mensaje de error esperado"
        );
    }


    @Test(dataProvider = "invalidLoginData")
    public void testInvalidLogin(String username, String password) {
        loginPage.login(username, password);
        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Epic sadface"),
                "No se mostró el mensaje de error esperado"
        );
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] getInvalidLoginData() {
        return new Object[][] { { "fake_user", "wrong_pass" } };
    }

    @Test
    public void testEmptyLogin() {
        loginPage.clickLogin();
        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Username is required"),
                "No se mostró el mensaje de error esperado para campos vacíos"
        );
    }
}