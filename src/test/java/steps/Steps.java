package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;

public class Steps {

    protected final Logger logger = LogManager.getLogger(this.getClass());
    SoftAssert softAssert = new SoftAssert();
}
