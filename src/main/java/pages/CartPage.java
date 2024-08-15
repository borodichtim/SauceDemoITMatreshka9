package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By checkOutButton = By.id("checkout");

    public CheckOutPage clickCheckOutButton() {
        driver.findElement(checkOutButton).click();
        return new CheckOutPage(driver);
    }
}
