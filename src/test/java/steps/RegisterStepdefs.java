package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Users;
import pom.parabank.LeftPanel;
import pom.parabank.RegistrationPage;
import testCases.DriverManager;
import testDataManagement.TestDataManager;

public class RegisterStepdefs extends Steps {

    RegistrationPage registrationPage;
    Faker faker;
    Users randomUser;

    @Given("the user navigates to the registration page")
    public void theUserNavigatesToTheRegistrationPage() {
        System.out.println("Step theUserNavigatesToTheRegistrationPage");
        registrationPage = new RegistrationPage(DriverManager.getDriver());
        faker = new Faker();
    }

    @When("the user fills in the registration form with generated data")
    public void theUserFillsInTheRegistrationFormWithGeneratedData() {
        String username = faker.name().firstName() + "." + faker.name().lastName();

        randomUser = new Users(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.address().streetAddress(),
                faker.address().city(),
                faker.address().state(),
                faker.address().zipCode(),
                faker.phoneNumber().cellPhone(),
                faker.idNumber().ssnValid(),
                username,
                faker.internet().password(),
                faker.internet().password()
        );


        registrationPage.fillRegistrationForm(randomUser);
        TestDataManager.getInstance().setData("registeredUser", randomUser);
    }

    @And("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String arg0) {
        registrationPage.clickRegister();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Then("the user should see a successful registration message")
    public void theUserShouldSeeASuccessfulRegistrationMessage() {
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        String welcomeMessage = "Welcome " + randomUser.getUsername();

        softAssert.assertEquals(registrationPage.getWelcomeMessage(), welcomeMessage);
        softAssert.assertEquals(registrationPage.getSuccessfulMessage(), expectedMessage);

        softAssert.assertAll();
    }

    @And("the user clicks on the Logout link")
    public void theUserClicksOnTheLogoutLink() {
        registrationPage.clickLogout();
    }

    @And("the user clicks on the open new account link")
    public void theUserClicksOnTheOpenNewAccountLink() {
        LeftPanel leftPanel = new LeftPanel(DriverManager.getDriver());
        leftPanel.clickOpenNewAccount();
//        registrationPage.saveCookies();
        registrationPage.saveLocaStorage();
    }
}
