#SIPHOKAZI
Feature: Demo Web Shop


  Scenario: Home page purchase item
    Given Home page is populated and user search for "book"
    When User clicks addtocart on the Displayed product
    Then User open cart
