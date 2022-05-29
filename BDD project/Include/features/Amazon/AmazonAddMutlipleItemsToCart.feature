Feature: Add multiple items to the cart.

  Background: 
    Given open browser
    And navigate to https://www.amazon.com

  Scenario Outline: Add multiple item to the cart from different categories
    When clicking on -See more- in the bottom of <CatergoriesCollection> card wrapper
    Then I should see different item categories under selected <CatergoriesCollection>
    When clicking on <Catergorie> card
    Then I should see number of items under the selected <Catergorie> categories collection
    And <Catergorie> keyword must be contained in the information text on the header
    When selecting <PriceRange> from Price list
    Then I should see items between low and high of the <PriceRange> price range
    When I click on <SelectedItemToBuy> to select the item
    Then I should see <SelectedItemToBuy> item page
    And <SelectedItemToBuy>'s price should match <Price>
    When Adding <SelectedItemToBuy> to the cart
    Then Item should be added to the cart
    And Item count of the cart should be increased by 1
    When Back to home screen
    When I close the browser

    Examples: 
      | CatergoriesCollection | Catergorie | PriceRange   | SelectedItemToBuy                                                 | Price   |
      | Gaming accessories    | Oculus     | $100 to $200 | GearIT USB 3.0                                                    | $137.99 |
      
