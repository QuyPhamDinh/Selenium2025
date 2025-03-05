import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testCases.BaseTest;
import testCases.DriverManager;


public class SecondTest extends BaseTest {
    @Test
    public void GOOGLE4() {

        WebDriver driver = DriverManager.getDriver();
        System.out.println("Google4 Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to("http://www.google.com");
        System.out.println("Google4 Test's Page title is: " + driver.getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Google");
        System.out.println("Google4 Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("User can log in with valid credentials")
    public void YANDEX() {
        WebDriver driver = DriverManager.getDriver();
        System.out.println("Yandex Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to("http://www.yandex.com");
        System.out.println("Yandex Test's Page title is: " + driver.getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Allure.step("Verify ...");
        Assert.assertEquals(driver.getTitle(), "Yandex");
        System.out.println("Yandex Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    }
}