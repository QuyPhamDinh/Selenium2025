package pom.practiceExpandTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v132.emulation.Emulation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.BasePage;

import java.util.Optional;

public class GeoLocationPage extends BasePage {


    private final By whereButton = By.id("geoBtn");
    private final By latValue = By.id("lat-value");
    private final By longValue = By.cssSelector("#long-value");

    public final double latitude = 48.8566;
    public final double longitude = 2.3522;
    public final int accuracy = 100;

    public GeoLocationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void goToPage() {
        driver.get("https://practice.expandtesting.com/geolocation");
    }

    public void clickWhereButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(whereButton)).click();
    }

    public String getLatValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(latValue)).getText();
    }

    public String getLongValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(longValue)).getText();
    }

    public void emulateLocation() {
        if (driver instanceof ChromeDriver) {
            DevTools devTools = ((ChromeDriver) driver).getDevTools();
            devTools.createSession();
            devTools.send(Emulation.setGeolocationOverride(Optional.of(latitude),  // Latitude
                    Optional.of(longitude),   // Longitude
                    Optional.of(accuracy)       // Accuracy
            ));
        }
    }
}
