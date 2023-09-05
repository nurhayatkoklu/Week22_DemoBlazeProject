Feature: Add, Remove, Buy, Product

  Background:
    Given Navigate to Demo Blaze
    When Login to the website
    And Assert that you have successfully logged in

    Scenario: Adding, removing, buying product
    And Click Phones on side navigation menu
    And Add a product
    And Assert that you have successfully added product to your cart
    And Click Home
    And Click Laptops on side navigation menu
    And Add another product
    And Assert that you have successfully added product to your cart
    And Click Home
    And Click Monitors on side navigation menu
    And Add one more product
    And Assert that you have successfully added product to your cart
    And Go to your Cart
    And Remove monitor from your cart
    And Assert that product removed from your cart
    And Click Home
    And Click Next on the right corner
    And Add a product to your cart
    And Assert that you have successfully added product to your cart
    And Go to your Cart
    And Assert that Total is correct
    And Click Place Order
    And Fill the form and click Purchase
    And Assert an Id is assigned to your order. Assert Amount, Card Number, Name and Date is correct
    Then Click Ok


