Feature: place the order for Products

@place
Scenario Outline: products
Given user landed on the landing page
    When user serach the short text <text> on the landing page and extract the product
    And Added "3" items of the selected product to cart
    Then User Proceeds to checkout anf validate the <name> items in checkout page
    And Verify usrt has ability to enter promo code and place the order

    Examples: 
      | text |
      | Bri  |
      
