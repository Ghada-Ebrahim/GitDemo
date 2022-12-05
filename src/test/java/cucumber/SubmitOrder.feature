
@tag
Feature: Purchase the order from E-Commerce
  I want to use this template for my feature file
  
  Background:
  Given I landed on E-Commerce page

  @Regression
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add the product <productName> to Cart
    And Checkout this <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

    Examples: 
      | name                      | password | productName |
      | ghadaebrahim875@yahoo.com | Dodo@1997| ZARA COAT 3 |
