Feature: Users can buy the Property sell the Property & compaire the Property price from the online https://www.zoopla.co.uk/ website 

	Description: "User can search the Property, check the Property price, and buy the" 
                         "Property with a valid user."  
                         
Scenario:
Login with valid authentication and can check the Property price, also can verify Property price 
	Given Customer can open any browser 
	And Navigate to "https://www.zoopla.co.uk/" 
	When User can enter userName "alammohammed79@gmail.com" and password "SAYEDawan2008@" 
	And Click on Submit button 
	Then Verify Home page title 
	

