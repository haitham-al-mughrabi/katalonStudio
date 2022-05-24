Feature: add to cart

  Background: 
    When user open browser
    When user navigates to https://www.amazon.com

  @TestA
  Scenario: user is able to add an item to cart
    When user clicks on Keyboards on Games accessories categorie
    Then user see results of keyboard item
    When close browser
