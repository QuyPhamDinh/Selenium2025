package multithreadtest;

import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcases.BaseTest;
import testcases.DriverManager;


public class SecondTest extends BaseTest {
    @Test
    public void google4() {

        WebDriver driver = DriverManager.getDriver();
        logger.info("Google4 Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to("http://www.google.com");
        logger.info("Google4 Test's Page title is: " + driver.getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Google");
        logger.info("Google4 Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("User can log in with valid credentials")
    public void yandex() {
        WebDriver driver = DriverManager.getDriver();
        logger.info("Yandex Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to("http://www.yandex.com");
        logger.info("Yandex Test's Page title is: " + driver.getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Allure.step("Verify ...");
        Assert.assertEquals(driver.getTitle(), "Yandex");
        logger.info("Yandex Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    }
}