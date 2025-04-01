package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import testcases.DriverManager;

public class Hooks {
    protected final Logger logger = LogManager.getLogger(this.getClass());

    @Before
    public void setup() {
        DriverManager.getDriver();
    }

    @After
    public void tearDown() {
        logger.info("Closing browser after scenario...");
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
    }
}
