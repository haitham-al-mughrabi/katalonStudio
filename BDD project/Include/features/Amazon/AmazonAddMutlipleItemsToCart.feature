Feature: Add multiple items to the cart.

  Background: 
    Given open browser
    And navigate to https://www.amazon.com

  Scenario Outline: Add multiple item to the cart from different categories
    When clicking on See more in the bottom of <Categorie> card
    Then I should see different item categories under selected <Categorie>
    When clicking on <item> card
    Then I should see number of items under the selected <item> categorie
    And The categorie name must be contained in the information text on the header
    When selecting <PriceRange> from Price list
    Then I should see items between low and high of the selected range
    When I click on <SelectedItemToBuy> to select the item
    Then I should see <SelectedItemToBuy> item page
    And <SelectedItemToBuy>'s price should match <Price>
    When Adding <SelectedItemToBuy> to the cart
    Then Item should be added to the cart
    And Item count of the cart should be increased by 1
    When Back to home screen
    When I close the browser

    Examples: 
      | Categorie          | Item      | PriceRange   | SelectedItemToBuy                                                 | Price   |
      | Gaming accessories | Oculus    | $100 to $200 | GearlT USB 3.0                                                    | $137.99 |
      | Gaming accessories | Chairs    | $50 to $100  | YSSOA Backrest and Seat Height                                    | $99.99  |
      | Gaming accessories | Apparel   | Up to $25    | 2 Pairs Do Not Disturb Funny Short Sock Gamer                     | $7.99   |
      | Gaming accessories | Keyboards | $35 & Above  | SteelSeries Apex 3 RGB Gaming Keyboard – 10-Zone RGB Illumination | $49.99  |
