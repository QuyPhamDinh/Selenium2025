package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import report.AllureListener;
import screenshot.TestListener;

@Listeners({AllureListener.class, TestListener.class})
public class BaseTest {

    protected final Logger logger = LogManager.getLogger(this.getClass());
    protected WebDriver driver;
    public CapabilityFactory capabilityFactory = new CapabilityFactory();

    @BeforeClass
    public void beforeClass(ITestContext context) {
        // Get the name of the currently executing test class
        String testClassName = context.getCurrentXmlTest().getClasses().get(0).getName();
        logger.info("🚀 Running Test Class: " + testClassName);
    }

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setup(@Optional("chrome") String browser, ITestResult result) {
        logger.info("----Starting TEST " + result.getMethod().getMethodName());
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();

    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        logger.info("-----Finish TEST " + result.getMethod().getMethodName());
        DriverManager.quitDriver();
    }
}