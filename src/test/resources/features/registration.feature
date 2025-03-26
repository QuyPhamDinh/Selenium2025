Feature: Registration Form

  @registration
  Scenario: User registers with generated valid data
    Given the user navigates to the registration page
    When the user fills in the registration form with generated data
    And the user clicks on the "Register" button
    Then the user should see a successful registration message
