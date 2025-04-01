package testcases.shahid;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.shahid.ShahidHomePage;
import testcases.BaseTest;
import testcases.DriverManager;

public class ScrollWithDynamicElementsTest extends BaseTest {

    @Test
    void scrollToBottomWhileDynamicElementGenerated() {
        By dynamicElementLocator = By.cssSelector(".carousel-group");
        ShahidHomePage shahidHomePage = new ShahidHomePage(DriverManager.getDriver());
        shahidHomePage.scrollTillNoNewDynamicElementGenerated(dynamicElementLocator);

        logger.info("Scrolling is DONE");
        Assert.assertTrue(shahidHomePage.isContactUsDisplayed());

    }


    @Test
    void scrollToBottomWhileDynamicElementGenerated2() {

        ShahidHomePage shahidHomePage = new ShahidHomePage(DriverManager.getDriver());
        shahidHomePage.clickOKCookies();
        shahidHomePage.scrollTillDynamicElementFound();

        shahidHomePage.clickDynamicElement();
        shahidHomePage.waitForURLContainsDynamicElementHef();
    }
}
