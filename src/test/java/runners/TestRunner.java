package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
//    @BeforeClass
//    public void setup() {
//        System.out.println("Starting the test suite...");
//        WebDriver driver = DriverManager.getDriver();
//        driver.manage().window().maximize();
//    }
//
//    @AfterClass
//    public void tearDown() {
//        System.out.println("Test suite execution completed.");
//        DriverManager.getDriver().quit();
//    }
}