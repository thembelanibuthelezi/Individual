#SIPHOKAZI
Feature: Demo Web Shop

  Scenario: Home Page Default Login
    Given User is on DemoWEbShop landing page and login button is visible
    When User login  with Thembelani@gmail.com and Admin@123
    Then Home page is populated and user search for "book"


  Scenario: Home page purchase item
    Given Searched product is displayed
    When User clicks addtocart on the Displayed product
    Then User open cart












