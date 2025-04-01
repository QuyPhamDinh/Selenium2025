package multiThreadingCheck;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testCases.BaseTest;
import testCases.DriverManager;


public class FirstTest extends BaseTest {
    final String URL = "URL";

    @Test
    public void google1() {
        WebDriver driver = DriverManager.getDriver();
        System.out.println("Google1 Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.get("URL");
        System.out.println("Google1 Test's Page title is: " + driver.getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Google");
        System.out.println("Google1 Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    }

    @Test
    public void google2() {
        WebDriver driver = DriverManager.getDriver();
        System.out.println("Google2 Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to("URL");
        System.out.println("Google2 Test's Page title is: " + driver.getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Google");
        System.out.println("Google2 Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    }

    @Test
    public void google3() {
        WebDriver driver = DriverManager.getDriver();
        System.out.println("Google3 Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to("URL");
        System.out.println("Google3 Test's Page title is: " + driver.getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Google");
        System.out.println("Google3 Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    }
}