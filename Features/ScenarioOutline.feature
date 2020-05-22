Feature: Users can buy the Property sell the Property & compaire the Property price from the online https://www.zoopla.co.uk/ website 

	Description: "User can search the Property, check the Property price, and buy the" 
                         "Property with a valid user."   
Scenario Outline: 
	Login with valid authentication and can check the price of an iphone 

	Given Customer can open any browser 
	And User can enter email to"<URL>"
	When User can enter username"<userName>"
	And User can enter password"<password>"
	And Click on Submit button 
	Then Verify Home page title 	
	Examples: 
		|userName                 |password       |URL                      |
		|alammohammed79@gmail.com |SAYEDawan2008@ |https://www.zoopla.co.uk/|
		|alammohammed79@gmail.com |SAYEDawan2008  |https://www.zoopla.co.uk/|

		
		
		