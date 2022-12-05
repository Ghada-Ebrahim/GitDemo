@tag
Feature: ErrorValidation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on E-Commerce page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed 

    Examples: 
      | name                      | password | 
      | ghadaebrahim875@yahoo.com | Dodo1997| 
     
