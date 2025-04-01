Feature: User Login

  @login @dependsOnRegister
  Scenario: Login with valid credentials
    Given the user is on the login page
    When the user enters the credentials from registration form
    And clicks the login button
    Then the user should be logged in successfully

  @login @dependsOnRegister @cookies
  Scenario: Login with store Cookies
    Given the user is on the login page
    Then the user should be logged in successfully

