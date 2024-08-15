package pages;

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

    public CheckOutPage fillForm (String firstName, String lastName, String zip) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipField).sendKeys(zip);
        return this;
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
