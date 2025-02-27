package testBase;

import java.net.MalformedURLException;
import java.net.URL;

import logging.SeleniumEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class BaseTest {
    // Declare ThreadLocal Driver (ThreadLocalMap) for Thread-Safe Tests
    protected static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
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
        // Create RemoteWebDriver
        RemoteWebDriver baseDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                capabilityFactory.getCapabilities(browser));

        // Wrap with Event Listener for logging
        WebDriver eventDriver = new EventFiringDecorator<>(new SeleniumEventListener()).decorate(baseDriver);

        // Store the WebDriver in ThreadLocal
        driverThread.set(eventDriver);
    }

    public WebDriver getDriver() {
        return driverThread.get();
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

    @AfterClass
    public void terminate() {
        driverThread.remove();
    }

}