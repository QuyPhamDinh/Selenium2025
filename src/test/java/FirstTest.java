import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseTest;
import testBase.DriverManager;


public class FirstTest extends BaseTest {
    @Test
    public void GOOGLE1() {
        WebDriver driver = DriverManager.getDriver();
        System.out.println("Google1 Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.get("http://www.google.com");
        System.out.println("Google1 Test's Page title is: " + driver.getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Google");
        System.out.println("Google1 Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    }

    @Test
    public void GOOGLE2() {
        WebDriver driver = DriverManager.getDriver();
        System.out.println("Google2 Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to("http://www.google.com");
        System.out.println("Google2 Test's Page title is: " + driver.getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Google");
        System.out.println("Google2 Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    }

    @Test
    public void GOOGLE3() {
        WebDriver driver = DriverManager.getDriver();
        System.out.println("Google3 Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to("http://www.google.com");
        System.out.println("Google3 Test's Page title is: " + driver.getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Google");
        System.out.println("Google3 Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    }
}