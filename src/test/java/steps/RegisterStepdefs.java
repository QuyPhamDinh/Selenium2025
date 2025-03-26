package steps;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Users;
import pom.parabank.RegistrationPage;
import testCases.DriverManager;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RegisterStepdefs extends Steps {

    Users randomUser;
    RegistrationPage registrationPage;
    Faker faker;

    public RegisterStepdefs(Users randomUser) {
        this.randomUser = randomUser;
    }

    @Given("the user navigates to the registration page")
    public void theUserNavigatesToTheRegistrationPage() {
        System.out.println("Step theUserNavigatesToTheRegistrationPage");
        registrationPage = new RegistrationPage(DriverManager.getDriver());
        faker = new Faker();
    }

    @When("the user fills in the registration form with the following details:")
    public void theUserFillsInTheRegistrationFormWithTheFollowingDetails(DataTable dataTable) {
// Convert DataTable to List of Maps for easy access to data
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        // Access each row in the data table and fill the form
        Map<String, String> userData = data.get(0);

        String firstName = userData.get("firstName");
        String lastName = userData.get("lastName");
        String address = userData.get("address");
        String city = userData.get("city");
        String state = userData.get("state");
        String zipCode = userData.get("zipCode");
        String phoneNumber = userData.get("phoneNumber");
        String ssn = userData.get("ssn");
        String username = userData.get("username");
        String password = userData.get("password");
        String confirmPassword = userData.get("confirmPassword");

        // Fill in the registration form
        registrationPage.fillRegistrationForm(randomUser);
    }

    @When("the user fills in the registration form with generated data")
    public void theUserFillsInTheRegistrationFormWithGeneratedData() {
        String randomString = UUID.randomUUID().toString().substring(0, 8);
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
    }

    @And("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String arg0) {
        registrationPage.clickRegister();
    }

    @Then("the user should see a successful registration message")
    public void theUserShouldSeeASuccessfulRegistrationMessage() {
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        String welcomeMessage = "Welcome " + randomUser.getUsername();

        softAssert.assertEquals(registrationPage.getWelcomeMessage(), welcomeMessage);
        softAssert.assertEquals(registrationPage.getSuccessfulMessage(), expectedMessage);

        softAssert.assertAll();
    }
}
