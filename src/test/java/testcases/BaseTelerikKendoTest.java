package testcases;

import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pom.CookiesOverlay;

public class BaseTelerikKendoTest extends BaseTest {

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setup(@Optional("chrome") String browser, ITestResult result) {
        super.setup(browser, result);

        CookiesOverlay cookiesOverlay = new CookiesOverlay(driver);
        cookiesOverlay.clickAcceptCookies();
    }
}
