@registerLogin
Feature: Registration Form

  @registration
  Scenario: User registers with generated valid data
    Given the user navigates to the registration page
    When the user fills in the registration form with generated data
    And the user clicks on the "Register" button
    Then the user should see a successful registration message
    And the user clicks on the open new account link
#    And the user clicks on the Logout link

  @login @dependsOnRegister @cookies
  Scenario: Login with store Cookies
    Given the user is on the login page
    Then the user should be logged in successfully

#  @login @dependsOnRegister
#  Scenario: Login with valid credentials
#    Given the user is on the login page
#    When the user enters the credentials from registration form
#    And clicks the login button
#    Then the user should be logged in successfully
