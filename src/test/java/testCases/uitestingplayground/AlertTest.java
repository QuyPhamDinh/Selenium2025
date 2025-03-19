package testCases.uitestingplayground;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.uitestingplayground.AlertPage;
import testCases.BaseTest;
import testCases.DriverManager;

public class AlertTest extends BaseTest {

    @Test
    void testAlert() {

        AlertPage alertPage = new AlertPage(DriverManager.getDriver());
        alertPage.clickAlert();
        Assert.assertEquals(alertPage.getAlertMessage(), "Today is a working day.\n" +
                "Or less likely a holiday.");
        alertPage.acceptAlert();
    }
}
