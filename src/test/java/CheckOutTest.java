import dto.Customer;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {

    Customer customer = new Customer("Ivan", "", "22222");

    @Test
    @Epic("ITMatreshka - 01")
    @Feature("ITMatreshka - 02")
    @Story("1223")
    @Description("Проверка ввода неккоретных данных при заполнении формы покупателя")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.saucedemo.com/")
    public void test() throws InterruptedException {
        loginPage.openPage()
                .login("standard_user", "secret_sauce")
                .clickAddToCart("Sauce Labs Bike Light")
                .clickAddToCart("Sauce Labs Onesie")
                .selectSort("Name (Z to A)")
                .clickCart()
                .clickCheckOutButton()
                .fillForm(customer)
                .clickContinue();
        Assert.assertEquals(checkOutPage.getErrorMessage(), "Error: Last Name is required");
    }
}
