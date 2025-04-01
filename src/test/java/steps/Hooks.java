package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import testCases.DriverManager;

public class Hooks {

    @Before
    public void setup() {
        DriverManager.getDriver();
    }

    @After
    public void tearDown() {
        System.out.println("Closing browser after scenario...");
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
    }
}
