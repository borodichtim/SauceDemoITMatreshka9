package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    By title = By.xpath("//span[@class = 'title']");
    String addToCartButton = "//div[text() = '%s']/ancestor::div[@class = 'inventory_item']//button";
    By cartButton = By.xpath("//a[@class = 'shopping_cart_link']");

    public ProductPage clickAddToCart(String productName) {
        driver.findElement(By.xpath(String.format(addToCartButton, productName))).click();
        return this;
    }

    public CartPage clickCart() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    public ProductPage isPageOpened() {
        driver.findElement(title).isDisplayed();
        return this;
    }
}
