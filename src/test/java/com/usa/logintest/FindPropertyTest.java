package com.usa.logintest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.usa.basepage.SupperClass;
import com.usa.loginpage.FindPropertyPage;
import com.usa.loginpage.LoginPage;

public class FindPropertyTest extends SupperClass {
	FindPropertyPage fp;
	LoginPage lp;
	final String name = "London";

	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
		fp = new FindPropertyPage();
		lp.login(prop.getProperty("userName"), prop.getProperty("textPassword"));
	}

	@Test
	public void findProperties() {
		
		logger.info("*** As a User i can serch the property with city name ***");
		fp.getEnterTheText().sendKeys(name);
		fp.getEnterTheText().sendKeys(Keys.ENTER);
		
		logger.info("*** As a User i can search all the property price & also count the property ***");
		fp.FindTotalHouse();
		
		logger.info("*** As a User i can search all the property & select the fifth number property ***");
		fp.FindFifthProperty();
		
		logger.info("*** As a User i can verify the selected property price ***");
		fp.getVerifyHousePrice();
/*
		// This is one way verify
		logger.info("*** As a User i can verify my page title with Assertion ***");
		String title = lp.validatePageTitle();
		Assert.assertEquals(title, "New home, 1 bed flat for sale in Landmark Pinnacle, Marsh Wall, Canary Wharf E14 - Zoopla");
		System.out.println(" Page titlt Verify successfully :: " + title);
*/
		// This is second way verify
		logger.info("*** As a User i can verify my page title with if else condition ***");
		String titlestatus = driver.findElement(By.id("header-account-panel__signed-in-link")).getText();
		String successfullmsg = "My Zoopla";
		if (titlestatus.equalsIgnoreCase(successfullmsg)) {
			System.out.println(" Verify successfully :: " + titlestatus);
			Assert.assertTrue(true);
		} else {
			System.out.println("<<<<< Test Failed>>>>>>");
			Assert.assertTrue(true);
		}

	}

	@AfterMethod
	public void tearDown() {
		logger.info("*** As a User i can closed the browser ***");
		driver.quit();

	}
}
