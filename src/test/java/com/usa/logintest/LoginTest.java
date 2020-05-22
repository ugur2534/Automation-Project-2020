package com.usa.logintest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.usa.basepage.SupperClass;
import com.usa.loginpage.LoginPage;
import com.usa.utility.SeleniumUtil;

public class LoginTest extends SupperClass {
	LoginPage lp;

	@BeforeMethod
	public void setUp() {
		initialization();
		// lp = PageFactory.initElements(driver, LoginPage.class);
		lp = new LoginPage();
	}

	@Test
	public void getLoginValidation() throws InterruptedException {
		// lp.login(prop.getProperty("userName"), prop.getProperty("textPassword"));

		logger.info("*** As a User i can click on signin BTN ***");
		SeleniumUtil.getExplicitWait(lp.getClickSignInBTN(), driver);
		lp.getClickSignInBTN().click();

		logger.info("*** As a User i can enter user name ***");
		SeleniumUtil.getExplicitWait(lp.getenterTheEmail(), driver);
		lp.getenterTheEmail().sendKeys(prop.getProperty("userName"));

		logger.info("*** As a User i can enter password ***");
		SeleniumUtil.getExplicitWait(lp.getenterThePassword(), driver);
		lp.getenterThePassword().sendKeys(prop.getProperty("textPassword"));

		logger.info("*** As a User i can click on submit btn ***");
		SeleniumUtil.getExplicitWait(lp.getsubmitBTN(), driver);
		lp.getsubmitBTN().click();

		logger.info("*** As a User i can verify my page title ***");
		String title = lp.validatePageTitle();
		Assert.assertEquals(title, "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");

	}

	@AfterMethod
	public void tearDown() {
		logger.info("*** As a User i can closed the browser ***");
		driver.quit();

	}

}
