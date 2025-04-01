package pom.parabank;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginForm extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    @Override
    public void goToPage() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    public LoginForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void loadCookies() {

        try (BufferedReader reader = new BufferedReader(new FileReader("cookies.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String name = parts[0];
                String value = parts[1];
                String domain = parts[2];
                String path = parts[3];
                String sameSite = parts[7];
                Date expiry = null;
                if (!parts[4].equals("null")) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                    try {
                        expiry = dateFormat.parse(parts[4]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                boolean isSecure = Boolean.parseBoolean(parts[5]);
                boolean isHttpOnly = Boolean.parseBoolean(parts[6]);

                Cookie cookie = new Cookie.Builder(name, value)
                        .domain(domain)
                        .path(path)
                        .expiresOn(expiry)
                        .isSecure(isSecure)
                        .isHttpOnly(isHttpOnly)
                        .sameSite(sameSite)
                        .build();

                driver.manage().addCookie(cookie);

                String url = driver.getCurrentUrl();
                driver.get(url);
                Thread.sleep(3000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadLocalStorage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Loading Local storage
        try (BufferedReader reader = new BufferedReader(new FileReader("localStorage.txt"))) {
            String localStorage = reader.readLine();
            js.executeScript("window.localStorage.clear();");
            js.executeScript("window.localStorage.setItem('localStorage', arguments[0]);", localStorage);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
