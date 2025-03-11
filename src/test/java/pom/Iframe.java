package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Iframe extends BasePage {

    public Iframe(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void goToPage() {

    }

    private void scrollToIFrame() {
        scrollToElementUsingActions(driver.findElement(By.cssSelector("div[class*='demoWrap']")));
//        OR
        //        scrollToElementUsingActions(driver.findElement(By.xpath("//iframe[@title='Demo']")));
    }

    private void switchToIFrame() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Demo']")));
    }

    public void moveToIFrame() {
        scrollToIFrame();
        switchToIFrame();
    }
}
