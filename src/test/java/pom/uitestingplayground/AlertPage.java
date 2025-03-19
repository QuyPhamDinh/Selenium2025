package pom.uitestingplayground;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

public class AlertPage extends BasePage {


    By alertButton = By.id("alertButton");

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void goToPage() {
        driver.get("http://uitestingplayground.com/alerts");
    }

    public void clickAlert() {
        WebElement e = driver.findElement(alertButton);
        e.click();

    }

    public String getAlertMessage() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert() {

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
