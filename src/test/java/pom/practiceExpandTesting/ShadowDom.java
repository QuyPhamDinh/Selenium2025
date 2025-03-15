package pom.practiceExpandTesting;


import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.BasePage;

import java.time.Duration;

public class ShadowDom extends BasePage {


    private final By shadowDomButton = By.cssSelector("button#my-btn");
    private final By expandTestingLink = By.xpath("//a[contains(text(),'Expand Testing')]");

    public ShadowDom(WebDriver driver) {
        super(driver);
    }


    @Override
    protected void goToPage() {
//        setupRoute();
        driver.get("https://practice.expandtesting.com/shadowdom");
    }

    private WebElement findElementInShadowDom(By by) {
        WebElement shadowHost = driver.findElement(By.id("shadow-host"));

        SearchContext shadowRoot = shadowHost.getShadowRoot();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        return shadowRoot.findElement(by);
    }

    public void clickShadowDomButton() {
        findElementInShadowDom(shadowDomButton).click();
    }

    public WebElement hoverMouseShadowDomButton() {
        WebElement button = findElementInShadowDom(shadowDomButton);
        scrollToElementUsingJS(button);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        Solution of clickable not working
//        wait.until(ExpectedConditions.elementToBeClickable(button));
        Actions actions = new Actions(driver);
        actions.moveToElement(button).clickAndHold().pause(Duration.ofSeconds(1)).perform();


        return button;
    }

    public String getShadowDomButtonColor() {

        return findElementInShadowDom(shadowDomButton).getCssValue("background-color");
    }

    public void waitForElementToHaveColor(WebElement element, String expectedColor) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> element.getCssValue("background-color").equals(expectedColor));
    }

}
