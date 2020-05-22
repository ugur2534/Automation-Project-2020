Feature: Users can purchase, sell & return from the online Amazon website 

	Description: "User can search the iPhone, check the price, and purchase the" 
                         "iPhone with a valid credit card."  
Scenario Outline: 
	Login with valid authentication and can check the price of an iphone 

	Given Customer can open any browser 
	And  Put"<URL>"and go to login page 
    And User able to use valid username"<userNames>" 
	And User able to put valid  password"<passwords>" 
	And Click on Submit button 
	And Verify Home page title
	 	
	Examples: 
		|userName                 |password      |productName|url                    |
		|weloveusa4ever@gmail.com |SAYEDawan2008 |IPhone     |https://www.amazon.com/|
		|weloveusa4ever@gmail.com |SAYEDawan2008 |laptop     |https://www.amazon.com/|
