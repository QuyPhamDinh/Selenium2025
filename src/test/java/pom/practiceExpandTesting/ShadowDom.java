package pom.practiceExpandTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pom.BasePage;

import java.time.Duration;

public class ShadowDom extends BasePage {


    private final By shadowDomButton = By.cssSelector("#my-btn");

    public ShadowDom(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void goToPage() {
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

    public void hoverMouseShadowDomButton() {

        Actions actions = new Actions(driver);

        // Pause to make transition of color happen
        actions.moveToElement(findElementInShadowDom(shadowDomButton)).pause(Duration.ofSeconds(1)).perform();
    }

    public String getShadowDomButtonColor() {

        return findElementInShadowDom(shadowDomButton).getCssValue("background-color");
    }
}
