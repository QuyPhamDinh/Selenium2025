package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AngularDropDownPage extends BasePage {
    private final String url = "https://www.telerik.com/kendo-angular-ui/components/dropdowns";

    private final By dropDownMain = By.cssSelector("kendo-dropdownlist .k-input-value-text");


    public AngularDropDownPage() {
        super();

    }

    public AngularDropDownPage(WebDriver driver) {
        super(driver);

    }

    @Override
    void goToPage() {
        driver.get(url);
    }

    public String getDropDownSelectedText() {
        return wait.waitUntil(ExpectedConditions.elementToBeClickable(dropDownMain)).getText();
    }

    public void clickDropdown() {

//      This scroll is needed to activate iframe loading its content
        scrollToIFrame();
        switchToIFrame();

        wait.waitUntil(ExpectedConditions.elementToBeClickable(dropDownMain)).click();
    }

    public void selectDropDown(String name) {
        List<WebElement> elementList = driver.findElements(By.cssSelector("kendo-list span"));
        List<WebElement> dropdownItems = wait.waitUntil(ExpectedConditions.visibilityOfAllElements(elementList));

        Actions action = new Actions(driver);
        for (WebElement item : dropdownItems) {
            if (item.getText().equals(name)) {
//                action.moveToElement(item).click().perform();
                item.click();
                break;
            }

        }
    }

    private void scrollToIFrame() {
        scrollToElementUsingActions(driver.findElement(By.cssSelector("div[class*='demoWrap']")));
//        OR
        //        scrollToElementUsingActions(driver.findElement(By.xpath("//iframe[@title='Demo']")));
    }

    private void switchToIFrame() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Demo']")));
    }


}
