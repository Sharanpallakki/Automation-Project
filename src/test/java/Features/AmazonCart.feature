Feature: add items with only iphone

Scenario: addelemnt with same title
Given  user open the amzon
When user search "Apple iPhone 15 (256 GB) -"
When user serch i phone and add phones which contain "Apple iPhone 15 (256 GB) -"
Then user add the phones to cart and get the size
 
 

@amazon
Scenario: addelemnt  and delete ee
Given  user open the amzon
When user search "Apple iPhone 15 (256 GB) -"
When user serch i phone and add phones which contain "Apple iPhone 15 (256 GB) -"
Then user add the phones to cart and get the size 
And I delete the following products
      | Apple iPhone 15 (256 GB) - Black |
      |Apple iPhone 15 (256 GB) - Blue|
    When I calculate the total price
    Then the calculated price should match
