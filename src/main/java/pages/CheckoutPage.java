package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By cartIcon = By.id("shopping_cart_container");
    private By checkoutButton = By.id("checkout");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By confirmationMessage = By.className("complete-header");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        waitForElement(locator).click();
    }

    private void enterText(By locator, String text) {
        WebElement element = waitForElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void startCheckout() {
        clickElement(cartIcon);
        clickElement(checkoutButton);
    }

    public void enterShippingDetails(String firstName, String lastName, String postalCode) {
        enterText(firstNameField, firstName);
        enterText(lastNameField, lastName);
        enterText(postalCodeField, postalCode);
        clickElement(continueButton);
    }

    public void completePurchase(String firstName, String lastName, String postalCode) {
        startCheckout();
        enterShippingDetails(firstName, lastName, postalCode);
        clickElement(finishButton);
    }

    public String getConfirmationMessage() {
        return waitForElement(confirmationMessage).getText();
    }

    public void clickContinueWithoutInfo() {
        clickElement(continueButton);
    }

    public String getErrorMessage() {
        return waitForElement(errorMessage).getText();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public boolean isFinishButtonClickable() {
        return driver.findElement(finishButton).isEnabled();
    }
}
