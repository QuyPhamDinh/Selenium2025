package report;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testCases.DriverManager;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = DriverManager.getDriver();

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "screenshots/" + result.getTestName() + "_" + timestamp + ".png";
        Allure.addAttachment(fileName, new ByteArrayInputStream(saveScreenshot(driver)));
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {

        if (driver == null) {
            return new byte[0];
        }
        System.out.println("Allure saveScreenshot.....");
        System.out.println("Thread Id: " + Thread.currentThread().getId());
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
