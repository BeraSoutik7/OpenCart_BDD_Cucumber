Feature: Product add to wish list


  Scenario: Product added to wishlist
    Given the user navigates to login page
    When the user login with valid credentials
    And the user search product as <"iMac"> in searchbar
    And the user clicked on add to wish list
    And the user clicked on the wishlist button
    Then the user should see the product displayed on the wishlist and remove the product from wish list
