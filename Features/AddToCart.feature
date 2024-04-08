Feature: Product Added to Cart

  Scenario: Add to cart
    Given the user navigates to login page
    And the user login with valid credentials
    And the user search product as <"iMac"> in searchbar
    And the user clicked on product
    And the user clicked on add to cart button
    And the user clicked on view cart button
    Then the user should see the product added on cart
    When the user removes the product from cart
    Then the user should see the empty cart message