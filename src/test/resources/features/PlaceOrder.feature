Feature: Place Order

Scenario: Search item
Given User is on Home Page
When User search an item "Parry Hotter"
Then Item must be listed

Scenario: Add item to cart
Given User should be on search result page
When User add item to the cart
Then Item must be added

Scenario: Buy the item
When User do checkout
Then should navigate to checkout page