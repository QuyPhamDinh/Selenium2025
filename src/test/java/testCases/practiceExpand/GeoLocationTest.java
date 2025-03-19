package testCases.practiceExpand;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.practiceExpandTesting.GeoLocationPage;
import testCases.BaseTest;
import testCases.DriverManager;

public class GeoLocationTest extends BaseTest {

    @Test
    void testGeoLocation() {

        GeoLocationPage geoLocationPage = new GeoLocationPage(DriverManager.getDriver());
        geoLocationPage.emulateLocation();
        geoLocationPage.clickWhereButton();

        Assert.assertEquals(geoLocationPage.getLongValue(), String.valueOf(geoLocationPage.longitude));
        Assert.assertEquals(geoLocationPage.getLatValue(), String.valueOf(geoLocationPage.latitude));
    }
}
