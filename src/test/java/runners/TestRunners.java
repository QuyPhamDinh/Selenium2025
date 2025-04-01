package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import testcases.DriverManager;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunners extends AbstractTestNGCucumberTests {

    protected final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeClass
    public void setup() {
        logger.info("Starting the test suite...");
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        logger.info("Test suite execution completed.");
        DriverManager.getDriver().quit();
    }
}

