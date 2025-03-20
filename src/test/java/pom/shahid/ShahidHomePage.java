package pom.shahid;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.BasePage;

import java.util.List;

public class ShahidHomePage extends BasePage {

    private By contactUs = By.cssSelector("#shahid-light-footer a[href='/en/contact-us']");

    public ShahidHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void goToPage() {
        driver.get("https://shahid.mbc.net/en");
    }

    public boolean isContactUsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactUs)).isDisplayed();
    }

    public void scrollTillNoNewDynamicElementGenerated(By dynamicElementLocator) {
        List<WebElement> eleBefore;
        int eleSizeBefore = 0;
        int eleSizeAfter = 0;
        while (true) {

            JavascriptExecutor je = (JavascriptExecutor) driver;
            eleBefore = driver.findElements(dynamicElementLocator);
            eleSizeBefore = eleBefore.size();
            je.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            try {
                wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(dynamicElementLocator, eleSizeBefore));
            } catch (TimeoutException e) {
                return;
            }

            eleSizeAfter = driver.findElements(dynamicElementLocator).size();

            if (eleSizeBefore == eleSizeAfter) break;

        }
    }
}
