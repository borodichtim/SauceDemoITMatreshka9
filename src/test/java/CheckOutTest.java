import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        loginPage.openPage()
                .login("standard_user", "secret_sauce")
                .isPageOpened()
                .clickAddToCart("Sauce Labs Bike Light")
                .clickAddToCart("Sauce Labs Onesie")
                .clickCart()
                .clickCheckOutButton()
                .fillForm("Ivan", "", "1244")
                .clickContinue();
        Assert.assertEquals(checkOutPage.getErrorMessage(), "Error: Last Name is required");
    }
}
