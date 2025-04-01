package screenshot;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testcases.DriverManager;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());

        WebDriver driver = DriverManager.getDriver();

        ScreenshotUtil.takeScreenshot(driver, result.getName());
    }
}

