package pom.parabank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

public class LeftPanel extends BasePage {

    @FindBy(css = "#leftPanel a[href='logout.htm']")
    WebElement logoutLink;

    @FindBy(css = "#leftPanel a[href='openaccount.htm']")
    WebElement openNewAccount;


    public LeftPanel(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void goToPage() {

    }

    public boolean isLogoutLinkPresent() {
        return logoutLink.isDisplayed();
    }

    public LeftPanel clickLogoutLink() {
        logoutLink.click();
        return this;
    }

    public LeftPanel clickOpenNewAccount() {
        openNewAccount.click();
        return this;
    }

}
