package pages;

import dto.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage{

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By zipField = By.id("postal-code");
    By continueButton = By.id("continue");
    By errorMessage = By.xpath("//h3[@data-test = 'error']");

    @Override
    public CheckOutPage isPageOpened() {
        waitElement(continueButton);
        return this;
    }

    public CheckOutPage fillForm (Customer customer) {
        driver.findElement(firstNameField).sendKeys(customer.getFirstName());
        driver.findElement(lastNameField).sendKeys(customer.getLastName());
        driver.findElement(zipField).sendKeys(customer.getZipCode());
        return this;
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
