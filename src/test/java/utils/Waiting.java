package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiting {

    private WebDriverWait wait;

    public Waiting(WebDriver driver, int timeout) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public <T> T waitUntil(ExpectedCondition<T> expectedConditions) {
        return wait.until(expectedConditions);
    }
}
