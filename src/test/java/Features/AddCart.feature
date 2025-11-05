Feature: verrify add cart funnctionality
@shop
Scenario Outline: verify list of product in an given String 
Given launch the browser 
When user enters "<username>" and "<password>"
Then user is able to login to appliaction
 When user adds the following products to the cart
      | ADIDAS ORIGINAL |
      | iphone 13 pro |
Then all selected products should be added successfully
Examples:
|username        ||    password|
|sharanpatil377@gmail.com||Sharan@1234|

