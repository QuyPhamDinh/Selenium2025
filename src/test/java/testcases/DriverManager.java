package testcases;

import conf.ConfigData;
import conf.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import logging.SeleniumEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ConfigData config = ConfigReader.getInstance().getConfig();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(initDriver());
        }
        return driver.get();
    }

    private static WebDriver initDriver() {
        String browser = config.getBrowser().toLowerCase();
        String gridUrl = config.getGridUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        try {
            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    capabilities.merge(chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    capabilities.merge(firefoxOptions);
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    capabilities.merge(edgeOptions);
                    break;
                case "local":

                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptionsLocal = new ChromeOptions();
                    capabilities.merge(chromeOptionsLocal);
                    return new ChromeDriver(chromeOptionsLocal);
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            WebDriver remoteDriver = new RemoteWebDriver(new URL(gridUrl), capabilities);
            // Wrap with Event Listener for logging
            return new EventFiringDecorator<>(new SeleniumEventListener()).decorate(remoteDriver);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Selenium Grid URL: " + gridUrl, e);
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

