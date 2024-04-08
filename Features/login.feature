Feature: Login with Valid Credentials

  @sanity
  Scenario: Successful Login with Valid Credentials
    Given the user navigates to login page
    When user enters email as "soutikbera@yopmail.com" and password as "Bera@2002"
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page

  Scenario Outline: Login Data Driven
    Given the user navigates to login page
    When user enters email as "<email>" and password as "<password>"
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page
    Examples:
      | email                  | password  |
      | soutikbera@yopmail.com | Bera@2002 |
      | soutik@yopmail.com     | 123456789 |

