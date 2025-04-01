package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiting {

    private static final Logger logger = LogManager.getLogger(Waiting.class);
    private final WebDriverWait wait;

    public Waiting(WebDriver driver, int timeout) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public <T> T until(ExpectedCondition<T> expectedConditions) {
        return wait.until(expectedConditions);
    }


    public void waitForAngularRequestsToFinish() {
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (Boolean) js.executeScript(
                        "return window.angular !== undefined && " +
                                "window.angular.element(document).injector() !== undefined && " +
                                "window.angular.element(document).injector().get('$http').pendingRequests.length === 0"
                );
            }
        });
    }

    /**
     * Try to click locator by ignoring ElementClickInterceptedException
     *
     * @param locator
     */

    public void clickByIgnoringElementIntercepted(By locator) {

        wait.until(driver -> {
            try {
                WebElement element = driver.findElement(locator);
                element.click(); // Attempt to click
                return true; // Click successful, exit wait
            } catch (ElementClickInterceptedException e) {
                logger.info("Click intercepted, retrying...");
                return false; // Continue waiting and retrying
            }
        });
    }

    public void clickByIgnoringElementIntercepted(WebElement e) {
        wait.until(driver -> {
            try {
                e.click(); // Attempt to click
                return true; // Click successful, exit wait
            } catch (ElementClickInterceptedException ex) {
                logger.info("Click intercepted, retrying...");
                return false; // Continue waiting and retrying
            }
        });
    }
}
