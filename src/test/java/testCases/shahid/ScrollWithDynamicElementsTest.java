package testCases.shahid;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.shahid.ShahidHomePage;
import testCases.BaseTest;
import testCases.DriverManager;

public class ScrollWithDynamicElementsTest extends BaseTest {

    @Test
    void scrollToBottomWhileDynamicElementGenerated() {
        By dynamicElementLocator = By.cssSelector(".carousel-group");
        ShahidHomePage shahidHomePage = new ShahidHomePage(DriverManager.getDriver());
        shahidHomePage.scrollTillNoNewDynamicElementGenerated(dynamicElementLocator);

        System.out.println("Scrolling is DONE");
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
