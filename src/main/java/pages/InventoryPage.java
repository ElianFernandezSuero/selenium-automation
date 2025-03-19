package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class InventoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By cartBadge = By.className("shopping_cart_badge");
    private By inventoryItems = By.className("inventory_item");
    private By addToCartButtons = By.xpath("//button[contains(text(),'Add to cart')]");
    private By cartIcon = By.id("shopping_cart_container");
    private By removeButtons = By.xpath("//button[contains(text(),'Remove')]");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutButton = By.id("logout_sidebar_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private List<WebElement> waitForElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    private void clickElement(By locator) {
        waitForElement(locator).click();
    }

    private WebElement getProductButton(String productName) {
        String xpath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button";
        return waitForElement(By.xpath(xpath));
    }

    public void addProductToCart(String productName) {
        getProductButton(productName).click();
    }

    public void removeProductFromCart(String productName) {
        getProductButton(productName).click();
    }

    public boolean isCartEmpty() {
        return driver.findElements(cartBadge).isEmpty();
    }

    public String getCartBadgeCount() {
        if (isCartEmpty()) {
            return "0";
        }
        return waitForElement(cartBadge).getText();
    }

    public boolean areProductsDisplayed() {
        return !waitForElements(inventoryItems).isEmpty();
    }

    public void addItemToCart(int index) {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        if (index < buttons.size()) {
            buttons.get(index).click();
        }
    }

    public void removeItemFromCart() {
        List<WebElement> removeBtns = driver.findElements(removeButtons);
        if (!removeBtns.isEmpty()) {
            removeBtns.get(0).click();
        }
    }

    public void addMultipleItemsToCart(int count) {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        for (int i = 0; i < count && i < buttons.size(); i++) {
            buttons.get(i).click();
        }
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public void openMenu() {
        clickElement(menuButton);
    }

    public void logout() {
        clickElement(logoutButton);
    }
}
