package testCases.practiceExpand;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.practiceExpandTesting.ShadowDom;
import testCases.BaseTest;
import testCases.DriverManager;

public class ShadowDomTest extends BaseTest {

    @Test
    void testShadowDomButton() {
        ShadowDom shadowDom = new ShadowDom(DriverManager.getDriver());
        WebElement e = shadowDom.hoverMouseShadowDomButton();

//        shadowDom.waitForElementToHaveColor(e, "rgba(236, 114, 17, 1)");
        Assert.assertEquals(shadowDom.getShadowDomButtonColor(), "rgba(236, 114, 17, 1)");
    }
}
