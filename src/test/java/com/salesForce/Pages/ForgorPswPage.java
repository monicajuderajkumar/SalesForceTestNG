package com.salesForce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SalesForce.Base.BasePage;

public class ForgorPswPage extends BasePage{

	public ForgorPswPage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy(xpath ="//h1[text()='Forgot Your Password']")
	WebElement forgotPswPageHeader;
	
	@FindBy(xpath ="//div[@class='verifyform']//input[@type='email']")
	WebElement frgtPswUserName;
	
	@FindBy(xpath ="//div[@class='verifyform']//input[@id='continue']")
	WebElement continueBtn;
	
	public Boolean verifyForgotPswPageDisplayed() {
		explicitWait(forgotPswPageHeader);
		Boolean frgtpswdisplayed = forgotPswPageHeader.isDisplayed();
		return frgtpswdisplayed;
	}
	
	public void enterUsernameFrgPsw() {
		explicitWait(frgtPswUserName);
		frgtPswUserName.sendKeys("monica@mjr.com");
	}
	
	public void clickContineFrgPsw() {
		explicitWait(continueBtn);
		continueBtn.click();
	}
}
