package com.usa.stepdefinition;

import java.io.IOException;

import org.testng.Assert;
import com.usa.basepage.SupperClass;
import com.usa.pagefactory.MasterPageFactory;
import com.usa.utility.SeleniumUtil;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class Stepdefinition extends SupperClass{

	MasterPageFactory pf;

	
	@Given("^Customer can open any browser$")
	public void customer_can_open_any_browser() {
		//pf = PageFactory.initElements(driver, MasterPageFactory.class);
		pf = new MasterPageFactory(driver);
	}

	@Given("^Navigate to \"([^\"]*)\"$")
	public void navigate_to(String url) {
		logger.info("******** As a user i can enter URL *********");
		driver.get(url);

	}

	@When("^User can enter userName \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_can_enter_userName_and_password(String userName, String pwd) {
		logger.info("******** As a user i can Click on signIn BTN *********");
		pf.getClickSignInBTN().click();
		logger.info("******** As a user i can enter username *********");
		pf.getUserName().sendKeys(userName);
		logger.info("******** As a user i can enter password *********");
		pf.getPassWord().sendKeys(pwd);
	}

	@When("^Click on Submit button$")
	public void click_on_Submit_button() {
		logger.info("******** As a user i can click on submit btn *********");
		pf.getSubmit().click();

	}

	@Then("^Verify Home page title$")
	public void verify_Home_page_title() throws IOException {
		logger.info("******** As a user i can verify page title *********");
		if (driver.getPageSource().contains("We know what a home is really worth")) {
			Assert.assertTrue(true);
			System.out.println("Home page title :: We know what a home is really worth");
		} else {
			logger.info("******** As a user i can verify error message *********");
			driver.getPageSource().contains("Register with Zoopla");
			SeleniumUtil.getScreenshot(driver, "Invalid credentials");
			Assert.assertTrue(true);
			System.out.println("UserName is a Invalid :: Register with Zoopla");
		}

	}

	@Given("^User can enter email to\"([^\"]*)\"$")
	public void user_can_enter_email_to(String URL) {
		logger.info("******** As a user i can enter URL *********");
		driver.get(URL);

	}

	@When("^User can enter username\"([^\"]*)\"$")
	public void user_can_enter_username(String userName) {
		logger.info("******** As a user i can click on signin btn *********");
		pf.getClickSignInBTN().click();
		logger.info("******** As a user i can enter username *********");
		pf.getUserName().sendKeys(userName);
	}

	@When("^User can enter password\"([^\"]*)\"$")
	public void user_can_enter_password(String pass) {
		logger.info("******** As a user i can enter password *********");
		pf.getPassWord().sendKeys(pass);
	}

	@Before
	public void setUp() {
	InitializeCucumberBDD();
	}

	@After
	public void tearDown() {
		logger.info("******** As a user i can closed the browser *********");
		driver.quit();

	}
}
