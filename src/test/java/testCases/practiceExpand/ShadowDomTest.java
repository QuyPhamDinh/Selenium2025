package testCases.practiceExpand;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.practiceExpandTesting.ShadowDom;
import testCases.BaseTest;
import testCases.DriverManager;

public class ShadowDomTest extends BaseTest {

    @Test
    void testShadowDomButton() {
        ShadowDom shadowDom = new ShadowDom(DriverManager.getDriver());
        shadowDom.hoverMouseShadowDomButton();
        Assert.assertEquals(shadowDom.getShadowDomButtonColor(), "rgba(236, 114, 17, 1)");
    }
}
