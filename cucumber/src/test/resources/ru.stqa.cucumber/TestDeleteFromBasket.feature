
Feature: Basket

  Scenario: Add product and delete then
    When Go to the shop
    And Add 3 product in basket
    And Go to the basket
    Then There no items
