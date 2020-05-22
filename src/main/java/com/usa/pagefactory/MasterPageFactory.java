package com.usa.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterPageFactory {

	public MasterPageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='button button--tertiary-dark account-link__text']")
	@CacheLookup
	private WebElement ClickSignInBTN;

	public WebElement getClickSignInBTN() {
		return ClickSignInBTN;

	}

	@FindBy(id = "signin_email")
	private WebElement userName;

	public WebElement getUserName() {
		return userName;

	}

	@FindBy(id = "signin_password")
	private WebElement password;

	public WebElement getPassWord() {
		return password;

	}

	@FindBy(id = "signin_submit")
	private WebElement submit;

	public WebElement getSubmit() {
		return submit;

	}
}
