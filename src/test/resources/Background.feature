Feature: Users can purchase, sell & return from the online Amazon website 

	Description: "User can search the iPhone, check the price, and purchase the" 
                         "iPhone with a valid credit card."        
Background: 
	Given Customer can open any browser 
	And Navigate to "https://www.amazon.com/" 
	When Customer can enter "weloveusa4ever@gmail.com" and "SAYEDawan2008" 
	And Click on Submit 
	Then Verify Home page title 
@iphone 
Scenario: User can search the iphone, check the price, and purchase the iphone 
	Given Enter in search box product name As a IPhone 
	When Customer able to see list of the iPhone on screen 
	And Customer can print the entire price 
	And Customer can click on third number iPhone 
	Then Customer verify the iphone price 
@laptop 
Scenario: User can search the laptop, check the price and buy the laptop 
	Given Enter in search box product name As a laptop 
	When Customer able to see list of the laptop on screen 
	And Customer can print the entire laptop price 
	And Customer can click on third number laptop 
	Then Customer verify the laptop price 
	
