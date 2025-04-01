package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Users;
import org.openqa.selenium.WebDriver;
import pom.parabank.LeftPanel;
import pom.parabank.LoginForm;
import testcases.DriverManager;
import testdatamanagement.TestDataManager;

public class LoginStepdefs extends Steps {
    private WebDriver driver;
    private LoginForm loginForm;
    private LeftPanel leftPanel;


    @Given("the user is on the login page")
    public void theUserIsOnTheLoginForm() {
        this.driver = DriverManager.getDriver();
        this.loginForm = new LoginForm(driver);
        this.leftPanel = new LeftPanel(driver);
        this.loginForm.goToPage();
    }

    @When("the user enters the credentials from registration form")
    public void theUserEntersAnd() {
        Users registeredUser = TestDataManager.getInstance().getData("registeredUser", Users.class);
        loginForm.enterUsername(registeredUser.getUsername());
        loginForm.enterPassword(registeredUser.getPassword());
    }

    @When("clicks the login button")
    public void clicksTheLoginButton() {
        loginForm.clickLogin();
    }

    @Then("the user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() {
        softAssert.assertTrue(driver.getCurrentUrl().contains("overview"));
        softAssert.assertTrue(leftPanel.isLogoutLinkPresent());
        softAssert.assertAll();
    }
}

