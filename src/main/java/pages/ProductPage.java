package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    By title = By.xpath("//span[@class = 'title']");
    String addToCartButton = "//div[text() = '%s']/ancestor::div[@class = 'inventory_item']//button";
    By cartButton = By.xpath("//a[@class = 'shopping_cart_link']");
    By sort = By.xpath("//select[@class = 'product_sort_container']");



    @Step("Добавляем товар в корзину")
    public ProductPage clickAddToCart(String productName) {
        driver.findElement(By.xpath(String.format(addToCartButton, productName))).click();
        return this;
    }

    @Step("Кликаеи на корзину")
    public CartPage clickCart() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    public ProductPage isPageOpened() {
        waitElement(title);
        return this;
    }

    @Step("Выполняем сортировку")
    public ProductPage selectSort(String sorting) {
        Select select = new Select(driver.findElement(sort));
        select.selectByVisibleText(sorting);
        return this;
    }
 }
