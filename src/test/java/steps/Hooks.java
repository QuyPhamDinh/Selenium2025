package steps;


import io.cucumber.java.After;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {
    protected final Logger logger = LogManager.getLogger(this.getClass());

    @After
    public void tearDown() {
//        logger.info("Closing browser after scenario...");
//        if (DriverManager.getDriver() != null) {
//            DriverManager.getDriver().quit();
//        }
    }
}
