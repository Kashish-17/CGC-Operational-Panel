
@feature_user_login
Feature: LoginScreen

  Background: 
    Given the user is on the Login Screen

  @invalid-organization
  Scenario Outline: Verify that the system displays an error message when an invalid Organization is entered
    When the user launches the application URL
    And the user enters <invalid_organization_name> in the Organization field
    And the user enters <valid_email> in the Email field
    And the user enters <valid_password> in the Password field
    And the user clicks the Login button
    Then the system displays the error message "We couldn’t find this organisation"
    And the user remains on the login screen

    Examples:
      | invalid_organization_name | valid_email            | valid_password    |
      | invalid_org_name         | valid_email@example.com | validPassword123  |

@invalid_login
Scenario Outline: Verify that the system displays an error message when an invalid Email or Password is entered
  When the user enters a valid Organization name in the Organization field
  And the user enters an invalid Email address in the Email field
  And the user enters an invalid Password in the Password field
  And the user clicks the Login button
  Then the system displays the error message "Your email or password is invalid"
  And the user remains on the login screen

Examples:
  | organization      | email                   | password |
  | valid_organization | invalid_email@domain    | short    |

@invalid-organization
Scenario Outline: Verify error message for invalid Organization
  When I enter <organization> in the Organization field
  And I enter <email> in the Email field
  And I click the Send button
  Then the system displays an error message indicating the Organization is invalid
  And the user remains on the Forgot Password screen

  Examples:
    | organization          | email                     |
    | InvalidOrgName123!   | valid.email@example.com   |

  @invalid-email
  Scenario Outline: Verify that the system displays an error message when an invalid Email is entered
    Given the user enters a valid Organization name in the Organization field
    And the user enters an invalid Email address in the Email field
    When the user clicks the Send button
    Then the system displays an error message indicating the Email is invalid
    And the user remains on the Forgot Password screen

    Examples:
      | OrganizationName | Email                  |
      | MyOrganization    | invalid_email@domain   |

  @empty-fields-error
  Scenario Outline: Verify error message for empty fields
    When the user leaves all fields (Organization, Email, Password) empty
    And the user clicks the Login button
    Then the system displays an error message indicating that all fields are required
    And the user remains on the login screen

    Examples:
      | Organization | Email | Password |
      |              |       |          |

@invalid-login
Scenario Outline: Verify error message for incorrect password
  When I enter "<organization>" in the Organization field
  And I enter "<email>" in the Email field
  And I enter "<password>" in the Password field
  And I click the Login button
  Then the system should display the error message "Your email or password is invalid"
  And the user should remain on the login screen

  Examples:
    | organization          | email                   | password            |
    | ValidOrganizationName | valid.email@example.com | incorrectPassword123 |

@empty_fields_error
Scenario Outline: Verify error message with empty fields
  When the user leaves all fields (Organization, Email) empty
  And the user clicks the Send button
  Then the system displays an error message indicating that all fields are required
  And the user remains on the Forgot Password screen

Examples:
  | Organization | Email |
  |              |       |

  @login-button-disabled
  Scenario Outline: Verify that the Login button remains disabled when all fields are empty
    Given all fields (Organization, Email, Password) are empty
    Then the Login button is disabled

  Examples:
    | Organization | Email | Password |
    |              |       |          |

  @disabled-login-button
  Scenario Outline: Verify that the Login button remains disabled when only the Organization field is filled
    When I enter a valid Organization name in the Organization field
    And I leave the Email and Password fields empty
    Then the Login button should be disabled

    Examples:
      | Organization Name |
      | ValidOrgName      |

@disabled-login-button
Scenario Outline: Verify that the Login button remains disabled when only the Email field is filled
  When I enter <email> in the Email field
  And I leave the Organization field empty
  And I leave the Password field empty
  Then the Login button should be disabled

Examples:
  | email              |
  | krishna@gmail.com  |

@disabled-login-button
Scenario Outline: Verify that the Login button remains disabled when only the Password field is filled
  When the user enters <password> in the Password field
  And the user leaves the Organization and Email fields empty
  Then the Login button should be disabled

Examples:
  | password          |
  | validPassword123  |

@max-character-limit
Scenario Outline: Verify maximum character limits for Organization, Email, and Password fields
  When I enter a maximum length <organization> in the Organization field
  And I enter a maximum length <email> in the Email field
  And I enter a maximum length <password> in the Password field
  And I click the Login button
  Then the system processes the login request without errors
  And the user is redirected to the home screen if credentials are valid

Examples:
  | organization          | email                   | password            |
  | MaxLengthOrganization | MaxLengthEmail@example.com | MaxLengthPassword |

@special-characters-login
Scenario Outline: Verify system handles special characters in Organization, Email, and Password fields
  When I enter "<organization>" in the Organization field
  And I enter "<email>" in the Email field
  And I enter "<password>" in the Password field
  And I click the Login button
  Then the system processes the login request without errors
  And the user is redirected to the home screen if credentials are valid

Examples:
  | organization      | email                   | password     |
  | Org@ni$ation!     | user+name@example.com   | P@ssw0rd!    |
