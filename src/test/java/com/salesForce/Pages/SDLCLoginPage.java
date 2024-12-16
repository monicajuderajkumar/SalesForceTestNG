package com.salesForce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SalesForce.Base.BasePage;

public class SDLCLoginPage extends BasePage{
	
	public SDLCLoginPage(WebDriver driver) {
		super(driver);	
	}

	@FindBy(id="username")
    WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="Login")
	WebElement loginButton;
	
	@FindBy(xpath="//div[text()='Please enter your password.']")
	WebElement withoutPswError;
	
	@FindBy(id="rememberUn")
	WebElement remMeChkBox;
	
	@FindBy(css="span#idcard-identity")
	WebElement savedUserName;
	
	@FindBy(linkText="Forgot Your Password?")
	WebElement frogotPswlink;
	
	@FindBy(xpath="//div[@id='error']")
	WebElement errorMsg;
	
	@FindBy(xpath="//div[@class='steps-header']")
	WebElement buildAppTxt;
	
	public String verifyBuildAppTxt() {
		explicitWait(buildAppTxt);
		String actualbuildAppTxt = buildAppTxt.getText();
		System.out.println(actualbuildAppTxt);
		return actualbuildAppTxt;
	}
	
	public String verifyErrorMsg() {
		explicitWait(errorMsg);
		String actualincorrectCredErrorMsg = errorMsg.getText();
		System.out.println(actualincorrectCredErrorMsg);
		return actualincorrectCredErrorMsg;
	}
	public void clickForgotPswLink() {
		explicitWait(frogotPswlink);
		frogotPswlink.click();
	}
	
	public void enterUsername(String userNameValue) {
		explicitWait(username);
		username.sendKeys(userNameValue);
	}
	
	public void enterPassword(String passwordValue) {
		explicitWait(password);
		password.sendKeys(passwordValue);
	}
	
	public void clickLogin() {
		explicitWait(loginButton);
		loginButton.click();
	}
	
	public void clearPassword() {
		password.clear();
	}
	
	public String verifyWithoutPswError() {
		explicitWait(withoutPswError);
		String actualerrormsg = withoutPswError.getText();
		System.out.println(actualerrormsg);
		return actualerrormsg;
	}
	
	public void clickRememberMe() {
		explicitWait(remMeChkBox);
		remMeChkBox.click();
	}
	
	public String verifyRememberMe() { 
		System.out.println("Attribut Checked Value After click" + remMeChkBox.getAttribute("checked"));
		String verifyChecked = remMeChkBox.getAttribute("checked");
		return verifyChecked;
	}
	
	public String verifyUserName() {
		explicitWait(savedUserName);
		String actualusername = savedUserName.getText();
		System.out.println("Actual Username is:" + actualusername);
		return actualusername;
	}
}
