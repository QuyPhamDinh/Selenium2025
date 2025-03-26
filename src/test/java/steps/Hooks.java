package steps;


import io.cucumber.java.After;

public class Hooks {

    @After
    public void tearDown() {
//        System.out.println("Closing browser after scenario...");
//        if (DriverManager.getDriver() != null) {
//            DriverManager.getDriver().quit();
//        }
    }
}
