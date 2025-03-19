package pom.uitestingplayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.BasePage;

public class AnimationButtonPage extends BasePage {


    private By startAnimation = By.cssSelector("#animationButton");
    private By movingButton = By.cssSelector("#movingTarget");
    private By statusText = By.cssSelector("#opstatus");


    public AnimationButtonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void goToPage() {
        driver.get("http://uitestingplayground.com/animation");
    }

    public void clickStartAnimation() {
        wait.until(ExpectedConditions.elementToBeClickable(startAnimation)).click();
    }

    public void clickCompletedAnimationButton() {
        wait.until(d -> {
            WebElement button = d.findElement(movingButton);
            String classButton = button.getDomAttribute("class");
            return !classButton.contains("spin");
        });

        driver.findElement(movingButton).click();
    }

    public String getStatus() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(statusText)).getText();
    }
}
