package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import testCases.DriverManager;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunners extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setup() {
        System.out.println("Starting the test suite...");
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Test suite execution completed.");
        DriverManager.getDriver().quit();
    }
}

