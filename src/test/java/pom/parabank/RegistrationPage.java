package pom.parabank;

import model.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.BasePage;

public class RegistrationPage extends BasePage {


    @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @FindBy(id = "customer.address.street")
    private WebElement address;

    @FindBy(id = "customer.address.city")
    private WebElement city;

    @FindBy(id = "customer.address.state")
    private WebElement state;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCode;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneNumber;

    @FindBy(id = "customer.ssn")
    private WebElement ssn;

    @FindBy(id = "customer.username")
    private WebElement username;

    @FindBy(id = "customer.password")
    private WebElement password;

    @FindBy(id = "repeatedPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@type='submit' and @value='Register']")
    private WebElement registerButton;

    @FindBy(css = "#rightPanel h1")
    private WebElement welcomeMessage;

    @FindBy(css = "#rightPanel p")
    private WebElement successfulMessage;

    @Override
    protected void goToPage() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String fName) {
        firstName.sendKeys(fName);
    }

    public void enterLastName(String lName) {
        lastName.sendKeys(lName);
    }

    public void enterAddress(String addr) {
        address.sendKeys(addr);
    }

    public void enterCity(String cityName) {
        city.sendKeys(cityName);
    }

    public void enterState(String stateName) {
        state.sendKeys(stateName);
    }

    public void enterZipCode(String zip) {
        zipCode.sendKeys(zip);
    }

    public void enterPhoneNumber(String phone) {
        phoneNumber.sendKeys(phone);
    }

    public void enterSSN(String ssnValue) {
        ssn.sendKeys(ssnValue);
    }

    public void enterUsername(String user) {
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void enterConfirmPassword(String confirmPass) {
        confirmPassword.sendKeys(confirmPass);
    }

    public void clickRegister() {
        registerButton.click();
    }

    public void fillRegistrationForm(Users user) {
        enterFirstName(user.getFirstName());
        enterLastName(user.getLastName());
        enterAddress(user.getAddress());
        enterCity(user.getCity());
        enterState(user.getState());
        enterZipCode(user.getZipCode());
        enterPhoneNumber(user.getPhoneNumber());
        enterSSN(user.getSsn());
        enterUsername(user.getUsername());
        enterPassword(user.getPassword());
        enterConfirmPassword(user.getPassword());
    }

    public String getSuccessfulMessage() {
        return wait.until(ExpectedConditions.visibilityOf(successfulMessage)).getText();
    }

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }
}