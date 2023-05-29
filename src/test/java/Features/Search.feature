Feature: #THEMBELIHLE
  Scenario: Adding to cart
    Given User is on Items home page
    When User search for "computer"
    Then User adds product to cart
    And User Goes to shopping cart