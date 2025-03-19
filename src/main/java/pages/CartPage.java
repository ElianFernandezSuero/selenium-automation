package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {
    private WebDriver driver;

    private By cartItems = By.className("cart_item");
    private By removeButtons = By.xpath("//button[contains(text(),'Remove')]");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getCartItemCount() {
        List<WebElement> items = driver.findElements(cartItems);
        return items.size();
    }

    public void removeItemFromCart() {
        List<WebElement> removeBtns = driver.findElements(removeButtons);
        if (!removeBtns.isEmpty()) {
            removeBtns.get(0).click();
        }
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public boolean isCartDuplicated() {
        List<WebElement> items = driver.findElements(cartItems);
        return items.size() > 1; // Si hay más de un carrito, es un bug
    }
}