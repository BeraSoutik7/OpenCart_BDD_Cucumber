Feature: Compare Products

  Scenario: Compare product
    Given the user navigates to login page
    When the user login with valid credentials
    And the user search product as <"iMac"> in searchbar
    And the user clicked on product
    And the user clicked on compare product button
    And the user clicked on product compare and redirected to product compare page
    Then the user should see the product and remove the product from product compare

