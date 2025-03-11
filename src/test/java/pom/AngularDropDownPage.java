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
    

    public AngularDropDownPage(WebDriver driver) {
        super(driver);

    }

    @Override
    protected void goToPage() {
        driver.get(url);
    }

    public String getDropDownSelectedText() {
        return wait.until(ExpectedConditions.elementToBeClickable(dropDownMain)).getText();
    }

    public void clickDropdown() {

        wait.until(ExpectedConditions.elementToBeClickable(dropDownMain)).click();
    }

    public void selectDropDown(String name) {
        List<WebElement> elementList = driver.findElements(By.cssSelector("kendo-list span"));
        List<WebElement> dropdownItems = wait.until(ExpectedConditions.visibilityOfAllElements(elementList));

        Actions action = new Actions(driver);
        for (WebElement item : dropdownItems) {
            if (item.getText().equals(name)) {
//     OR            action.moveToElement(item).click().perform();
                item.click();
                break;
            }

        }
    }

}
