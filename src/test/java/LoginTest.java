import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends BaseTest{

    @Test (testName = "Проверка логина с позитивным кредами")
    public void checkLoginWithPositiveCredentional() throws InterruptedException {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue( driver.findElement(By.className("title")).isDisplayed());
    }

    @Test ()
    public void checkLoginWithEmptyUsername() {
        loginPage.openPage();
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is ");
    }

    @Test
    public void checkLoginWithNegativeUsername() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("1111");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
        Assert.assertEquals(driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText(),
                "Epic sadface: Username and password do not match any user in this service");
    }
}
