package com.usa.loginpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.usa.basepage.SupperClass;

public class LoginPage extends SupperClass {

	// Page factory initialize
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@class='button button--tertiary-dark account-link__text']")
	@CacheLookup
	private WebElement ClickSignInBTN;

	public WebElement getClickSignInBTN() {
		return ClickSignInBTN;

	}

	@FindBy(id = "signin_email")
	@CacheLookup
	private WebElement enterTheEmail;

	public WebElement getenterTheEmail() {
		return enterTheEmail;

	}

	@FindBy(id = "signin_password")
	@CacheLookup
	private WebElement enterThePassword;

	public WebElement getenterThePassword() {
		return enterThePassword;

	}

	@FindBy(id = "signin_submit")
	@CacheLookup
	private WebElement submitBTN;

	public WebElement getsubmitBTN() {
		return submitBTN;

	}

	public String validatePageTitle() {
		return driver.getTitle();

	}

	public void login(String un, String pwd) {
		logger.info("*** As a User i can click on signin BTN ***");
		ClickSignInBTN.click();
		logger.info("*** As a User i can enter user name ***");
		enterTheEmail.sendKeys(un);
		logger.info("*** As a User i can enter password ***");
		enterThePassword.sendKeys(pwd);
		logger.info("*** As a User i can click on submit btn ***");
		submitBTN.click();

	}

}
