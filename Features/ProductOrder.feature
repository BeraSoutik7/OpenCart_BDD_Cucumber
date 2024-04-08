Feature: Order a Product


  Scenario: Order a product from existing address
    Given the user navigates to login page
    When the user login with valid credentials
    And the user search product as <"iMac"> in searchbar
    And the user clicked on product
    And the user clicked on buy now button
    And the user clicked on check box
    And the user clicked on continue button and goto confirmation page
    And the user clicked on confirm order button
    Then the user should see the confirmation message


  Scenario: Order a product from new address
    Given the user navigates to login page
    When the user login with valid credentials
    And the user search product as <"iMac"> in searchbar
    And the user clicked on product
    And the user clicked on buy now button
    And the user clicked on I want to use new address
    And the user entered the address
    And the user clicked on check box
    And the user clicked on continue button and goto confirmation page
    And the user clicked on confirm order button
    Then the user should see the confirmation message
