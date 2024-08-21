package pages;

import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy (id = "user-name")
    WebElement userNameField;

    @FindBy (id = "password")
    WebElement passwordField;

    @FindBy (id = "login-button")
    WebElement loginButton;

    @FindBy (xpath = "//h3[@data-test = 'error']")
    WebElement errorMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public Object isPageOpened() {
        return null;
    }

    @Step("Открываем страницу LoginPage")
    public LoginPage openPage() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    @Step("Выполняем вход в систему")
    public ProductPage login(String userName, String password) {
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
        return new ProductPage(driver);
    }

    @Step("Получаем сообщение об ошибке")
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
