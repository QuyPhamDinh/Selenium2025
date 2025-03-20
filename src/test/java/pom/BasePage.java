package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiting;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected Waiting wait;

    abstract protected void goToPage();

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new Waiting(driver, 10);
        goToPage();
    }

    protected void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    protected void scrollToElementUsingActions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    protected void scrollToElementUsingJS(WebElement element) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    protected void waitForAngularReady(int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        ExpectedCondition<Boolean> angularLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (Boolean) js.executeScript(
                        "return window.getAllAngularTestabilities && " +
                                "window.getAllAngularTestabilities().findIndex(x => !x.isStable()) === -1;");
            }
        };
        wait.until(angularLoad);
    }

    protected void waitForReadyState(int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        ExpectedCondition<Boolean> readyState = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return "complete".equals(js.executeScript("return document.readyState"));
            }
        };
        wait.until(readyState);
    }


    protected void scrollUntilElementVisible(String centerPartLocator, String targetElementLocator, int maxScrolls) {
        Actions actions = new Actions(driver);
        WebElement centerPart = driver.findElement(By.cssSelector(centerPartLocator));
        int scrollCount = 0;

        while (scrollCount < maxScrolls) {
            try {
                // Check if the expected element is visible
                WebElement targetElement = driver.findElement(By.cssSelector(targetElementLocator));
                if (targetElement.isDisplayed()) {
                    System.out.println("Element found: " + targetElementLocator);
                    return;
                }
            } catch (NoSuchElementException e) {
                // Element not found, continue scrolling
            }

            // Scroll using PAGE_DOWN
            actions.moveToElement(centerPart).click().sendKeys(Keys.PAGE_DOWN).perform();

            // Increment scroll count
            scrollCount++;

            // Small delay to allow new content to load
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Reached max scroll limit, element not found: " + targetElementLocator);
    }


}
