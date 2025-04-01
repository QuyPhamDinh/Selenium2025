package pom.parabank;

import model.Users;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.BasePage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

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

    private LeftPanel leftPanel;

    @Override
    protected void goToPage() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        leftPanel = new LeftPanel(driver);
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

    public LeftPanel getLeftPanel() {
        return leftPanel;
    }

    public boolean isLogoutPresent() {
        return leftPanel.isLogoutLinkPresent();
    }

    public void clickLogout() {
        leftPanel.clickLogoutLink();
    }

    public void saveCookies() {
        Set<Cookie> cookies = driver.manage().getCookies();

        // Save cookies to a JSON file
        try (FileWriter writer = new FileWriter("cookies.txt")) {
            for (Cookie cookie : cookies) {
                writer.write(cookie.getName() + ";" + cookie.getValue() + ";" +
                        cookie.getDomain() + ";" + cookie.getPath() + ";" +
                        cookie.getExpiry() + ";" + cookie.isSecure() + ";" +
                        cookie.isHttpOnly() + ";" + cookie.getSameSite() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveLocaStorage() {
        //Saving Local storage
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String localStorage = (String) js.executeScript("return JSON.stringify(window.localStorage);");
        try (FileWriter writer = new FileWriter("localStorage.txt")) {
            writer.write(localStorage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}