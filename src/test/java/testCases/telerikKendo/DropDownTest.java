package testCases.telerikKendo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.AngularDropDownPage;
import pom.Iframe;
import testCases.BaseTelerikKendoTest;
import testCases.DriverManager;

public class DropDownTest extends BaseTelerikKendoTest {

    @Test
    public void testDropDown() {
        WebDriver driver = DriverManager.getDriver();
        AngularDropDownPage angularDropDownPage = new AngularDropDownPage(driver);
        Iframe iframe = new Iframe(driver);
        iframe.moveToIFrame();
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
