package testBase.telerikKendo;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.AngularDropDownPage;
import testBase.BaseTest;
import testBase.DriverManager;

public class DropDownTest extends BaseTest {

    @Test
    public void testDropDown() {
        AngularDropDownPage angularDropDownPage = new AngularDropDownPage(DriverManager.getDriver());
        angularDropDownPage.clickDropdown();

        String expectedItem = "Tennis";
        angularDropDownPage.selectDropDown(expectedItem);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(angularDropDownPage.getDropDownSelectedText(), expectedItem);
    }
}
