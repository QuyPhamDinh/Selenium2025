package pom.shahid;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.BasePage;

import java.time.Duration;
import java.util.List;

public class ShahidHomePage extends BasePage {

    private By dynamicElementBy = By.cssSelector("[data-container-id^='Main/WW/home/WW-Home-Kids~'] a");
    private WebElement dynamicElement;

    private By contactUs = By.cssSelector("#shahid-light-footer a[href='/en/contact-us']");

    private By okCookies = By.cssSelector("#onetrust-accept-btn-handler");

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

    public void clickContact() {
        driver.findElement(contactUs).click();
    }

    public void scrollTillNoNewDynamicElementGenerated(By dynamicElementLocator) {
        List<WebElement> eleBefore;
        int eleSizeBefore = 0;
        int eleSizeAfter = 0;
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofMillis(300));
        do {

            JavascriptExecutor je = (JavascriptExecutor) driver;
            eleBefore = driver.findElements(dynamicElementLocator);
            eleSizeBefore = eleBefore.size();
            je.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            try {
                myWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(dynamicElementLocator, eleSizeBefore));
//                wait.until(ExpectedConditions.elementToBeClickable(contactUs));
            } catch (TimeoutException e) {
                return;
            }

            eleSizeAfter = driver.findElements(dynamicElementLocator).size();

        } while (eleSizeBefore != eleSizeAfter);
    }

    public WebElement scrollTillDynamicElementFound() {

        int maxScroll = 30;
        int scrollTimes = 0;
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofMillis(100));
        while (scrollTimes < maxScroll) {
            JavascriptExecutor je = (JavascriptExecutor) driver;
            try {
                dynamicElement = myWait.until(ExpectedConditions.elementToBeClickable(dynamicElementBy));
                System.out.println("scrollTimes : " + scrollTimes);
                return dynamicElement;

            } catch (TimeoutException e) {
                je.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                scrollTimes++;
                continue;
            }
        }

        return null;
    }

    public void clickOKCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(okCookies)).click();
    }

    public WebElement getDynamicElementBy() {
        return driver.findElement(dynamicElementBy);
    }

    public void clickDynamicElement() {
        getDynamicElementBy().click();
    }


    public boolean waitForURLContainsDynamicElementHef() {

        return wait.until(driver -> driver.getCurrentUrl().contains(this.dynamicElement.getDomAttribute("href")));
    }


}
