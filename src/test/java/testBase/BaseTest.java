package testBase;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.ConfigData;
import utils.ConfigReader;

import java.net.MalformedURLException;

//@Listeners({AllureListener.class, TestListener.class})
public class BaseTest {
    private static ConfigData config = ConfigReader.getInstance().getConfig();
    public CapabilityFactory capabilityFactory = new CapabilityFactory();

    @BeforeClass
    public void beforeClass(ITestContext context) throws MalformedURLException {
        // Get the name of the currently executing test class
        String testClassName = context.getCurrentXmlTest().getClasses().get(0).getName();
        System.out.println("🚀 Running Test Class: " + testClassName);
    }

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setup(String browser) throws MalformedURLException {
        DriverManager.getDriver().manage().window().maximize();
    }


    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}