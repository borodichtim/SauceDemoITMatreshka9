package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By checkOutButton = By.id("checkout");

    @Override
    public CartPage isPageOpened() {
       waitElement(checkOutButton);
       return this;
    }

    @Step("Нажимаем на кнопку чекаут")
    public CheckOutPage clickCheckOutButton() {
        driver.findElement(checkOutButton).click();
        return new CheckOutPage(driver);
    }
}
