Feature: Logint to lest application 
@shop
Scenario Outline: verify is abale to login
Given  launch the browser 
When user enters "<username>" and "<password>"
Then user is able to login to appliaction
And verify the title should be "https://rahulshettyacademy.com/client/#/dashboard/dash"
Examples:
|username        ||    password|
|sharanpatil377@gmail.com||Sharan@1234|