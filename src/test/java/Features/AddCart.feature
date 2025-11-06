Feature: verrify add cart funnctionality

Scenario Outline: verify list of product in an given String 
Given launch the browser 
When user enters "<username>" and "<password>"
Then user is able to login to appliaction
 When user adds the following products to the cart
      | ADIDAS ORIGINAL |
      | iphone 13 pro |
      | ZARA COAT 3 |
Then the cart should contain the following products:
    | ADIDAS ORIGINAL |
    | iphone 13 pro |
    | ZARA COAT 3 |
Examples:
|username        ||    password|
|sharanpatil377@gmail.com||Sharan@1234|


Scenario Outline: caluculate price 
Given launch the browser 
When user enters "<username>" and "<password>"
Then user is able to login to appliaction
 When user adds the following products to the cart and get the price
      | ADIDAS ORIGINAL |
      | iphone 13 pro |
      | ZARA COAT 3 |
Then total amount should be "78000"

Examples:
|username        ||    password|
|sharanpatil377@gmail.com||Sharan@1234|


@shop
Scenario Outline: caluculate price after deleting products 
Given launch the browser 
When user enters "<username>" and "<password>"
Then user is able to login to appliaction
 When user adds the following products to the cart and get the price
      | ADIDAS ORIGINAL |
      | iphone 13 pro |
      | ZARA COAT 3 |
Then delete the follwoing products
	 | ADIDAS ORIGINAL |
And The Price should Match correctly " "

Examples:
|username        ||    password|
|sharanpatil377@gmail.com||Sharan@1234|

