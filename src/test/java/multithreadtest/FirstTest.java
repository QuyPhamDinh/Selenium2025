package multithreadtest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcases.BaseTest;
import testcases.DriverManager;


public class FirstTest extends BaseTest {
    final String URL = "http://google.com/";


    @Test
    public void google1() {
        WebDriver driver = DriverManager.getDriver();
        logger.info("Google1 Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.get(URL);
        logger.info("Google1 Test's Page title is: " + driver.getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Google");
        logger.info("Google1 Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    }

    @Test
    public void google2() {
        WebDriver driver = DriverManager.getDriver();
        logger.info("Google2 Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to(URL);
        logger.info("Google2 Test's Page title is: " + driver.getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Google");
        logger.info("Google2 Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    }

    @Test
    public void google3() {
        WebDriver driver = DriverManager.getDriver();
        logger.info("Google3 Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to(URL);
        logger.info("Google3 Test's Page title is: " + driver.getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Google");
        logger.info("Google3 Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    }
}