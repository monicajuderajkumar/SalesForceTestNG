package com.salesForce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SalesForce.Base.BasePage;

public class CheckYourEmailPage extends BasePage{
	
	public CheckYourEmailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//h1[text()='Check Your Email']")
	WebElement chkurmail;
	
	public Boolean verifyChkEmailPgisDisplayed() {
		explicitWait(chkurmail);
		Boolean chkurmailstatus = chkurmail.isDisplayed();
		return chkurmailstatus;
	}
	

}
