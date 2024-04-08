Feature: Account Registration

  Scenario: Successful Account Registration
    Given the user navigates to login page
    When the user clicks on Continue button to register
    When the user enters the details into below fields
      | firstName | Soutik     |
      | lastName  | Bera       |
      | telephone | 9000793211 |
      | password  | 12365478   |
    And the user selects Privacy Policy
    And the user clicks on Continue button
    Then the user account should get created successfully