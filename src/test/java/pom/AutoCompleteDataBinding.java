package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AutoCompleteDataBinding extends BasePage {

    By autoCompleteItems = By.cssSelector("kendo-list li");
    By autoCompleteInput = By.cssSelector("kendo-autocomplete input");
    String inputText;

    public AutoCompleteDataBinding(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void goToPage() {
        driver.get("https://www.telerik.com/kendo-angular-ui/components/dropdowns/autocomplete/data-binding");
    }

    public void typeAutoCompleteTextbox(String text) {

        WebElement autoComplete = wait.until(ExpectedConditions.elementToBeClickable(autoCompleteInput));
        autoComplete.sendKeys(text);

        this.inputText = text;
    }

    public WebElement getItemFocused() {

        List<WebElement> elementList = driver.findElements(autoCompleteItems);
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));

        for (WebElement e : elementList) {

            if (e.getText().startsWith(this.inputText)) {
                String aClass = e.getDomAttribute("class");
                if (aClass.contains("k-focus"))
                    return e;
            }
        }

        return null;
    }
}
