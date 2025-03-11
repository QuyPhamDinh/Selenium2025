package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import report.AllureListener;
import screenshot.TestListener;

import java.net.MalformedURLException;

@Listeners({AllureListener.class, TestListener.class})
public class BaseTest {

    protected WebDriver driver;
    public CapabilityFactory capabilityFactory = new CapabilityFactory();

    @BeforeClass
    public void beforeClass(ITestContext context) throws MalformedURLException {
        // Get the name of the currently executing test class
        String testClassName = context.getCurrentXmlTest().getClasses().get(0).getName();
        System.out.println("🚀 Running Test Class: " + testClassName);
    }

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setup(@Optional("chrome") String browser, ITestResult result) throws MalformedURLException {
        System.out.println("---------------------------------------------Starting TEST " + result.getMethod().getMethodName());
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();

    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        System.out.println("---------------------------------------------Finish TEST " + result.getMethod().getMethodName());
        DriverManager.quitDriver();
    }
}