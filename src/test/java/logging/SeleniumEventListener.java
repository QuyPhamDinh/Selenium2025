package logging;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SeleniumEventListener implements WebDriverListener {
    private static final Logger logger = LogManager.getLogger(SeleniumEventListener.class);

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        logger.info("Attempting to find element: " + locator);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        logger.info("Successfully found element: " + locator);
    }

    @Override
    public void beforeClick(WebElement element) {
        logger.info("Attempting to click on element: " + element);
    }

    @Override
    public void afterClick(WebElement element) {
        logger.info("Clicked on element: " + element);
    }

    @Override
    public void beforeTo(WebDriver.Navigation navigation, String url) {
        logger.info("Navigating to URL: " + url);
    }

    @Override
    public void afterTo(WebDriver.Navigation navigation, String url) {
        logger.info("Navigating to URL: " + url);
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        logger.error("Error occurred in method: " + method.getName() + " - " + e.getMessage());
    }

}
