package pom;

//public class CookiesOverlay {
//}
//
//import pom.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookiesOverlay extends BasePage {
    private final By cookiesAcceptButton = By.cssSelector(".ot-sdk-container #onetrust-accept-btn-handler");

    public CookiesOverlay(WebDriver driver) {
        super(driver);
    }

    public void clickAcceptCookies() {
//        wait.waitUntil(ExpectedConditions.presenceOfElementLocated(cookiesAcceptButton));
//        wait.waitUntil(ExpectedConditions.visibilityOfElementLocated(cookiesAcceptButton));
//        wait.waitUntil(ExpectedConditions.elementToBeClickable(cookiesAcceptButton));

//        After trying wait for the above conditions it still throw ElementClickInterceptedException when clicked
//        as it does not finish rendering
//        then we must retry by ignoring this exception by a custom wait
        wait.waitAndClick(cookiesAcceptButton);
    }

    @Override
    void goToPage() {
        driver.get("https://www.telerik.com/kendo-angular-ui/components/");
    }
}
