package com.seleniumAutomation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import com.seleniumAutomation.utils.BaseTest;

import java.time.Duration;

public class LogoutTests extends BaseTest {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void testLogout() {
        inventoryPage.openMenu();
        inventoryPage.logout();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/",
                "El usuario no fue redirigido a la página de login tras cerrar sesión");
    }
}