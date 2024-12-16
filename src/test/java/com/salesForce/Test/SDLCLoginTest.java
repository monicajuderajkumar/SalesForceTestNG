package com.salesForce.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SalesForce.Base.BaseTest;
import com.salesForce.Pages.CheckYourEmailPage;
import com.salesForce.Pages.ForgorPswPage;
import com.salesForce.Pages.HomePage;
import com.salesForce.Pages.SDLCLoginPage;
import com.saslesForce.Utilities.ReadPropertiesFile;

public class SDLCLoginTest extends BaseTest{
	
	SDLCLoginPage loginPage;
	HomePage homePg;
	ForgorPswPage frgpswPg;
	CheckYourEmailPage chkEmailPg;
	WebDriver driver;
	ReadPropertiesFile readPropFile;
	String expectedErrorMsg = "Please enter your password.";
	String expectedincorrectCredErrorMsg = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	String usernamevalue = getLoginCredential("UserName");
	String pswValue = getLoginCredential("Password");
	
	@BeforeMethod
	public void passDriver() {
		System.out.println("Step 1: As soon as test is triggered @BeforeMethod is called ");
	driver = getDriver();
	loginPage  = new SDLCLoginPage(driver);
	homePg = new HomePage(driver);
	frgpswPg = new ForgorPswPage(driver);
	chkEmailPg= new CheckYourEmailPage(driver);
	}
	
	@Test(priority=1)
	public void loginErrorMsg() {
		System.out.println("Step 4: @Test Test Case 1 -loginToError method is called");
		loginPage.enterUsername(usernamevalue);
		loginPage.clearPassword();
		loginPage.clickLogin();
		String actualerrormsgdis = loginPage.verifyWithoutPswError();
		Assert.assertEquals(actualerrormsgdis, expectedErrorMsg);
	}
	
	@Test(priority=2)
	public void loginToSalesForce() {
		System.out.println("Step 4: @Test Test Case 2 -loginToSalesForce method is called");
		System.out.println("UserName is :" + usernamevalue);
		System.out.println("Password is: "+ pswValue);
		loginPage.enterUsername(usernamevalue);
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		String actualbuildAppTxt = loginPage.verifyBuildAppTxt();
		Assert.assertEquals(actualbuildAppTxt, "Build App", "Text does not match");
	}
	
	@Test(priority=3)
	public void checkRememberMe() {
		System.out.println("Test Case 3 - checkRememberMe method is called");
		loginPage.enterUsername(usernamevalue);
		loginPage.enterPassword(pswValue);
		loginPage.clickRememberMe();
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickUserMenu();
		homePg.clickLogout();
		String actualusername = loginPage.verifyUserName();
		Assert.assertEquals(actualusername, usernamevalue, "Username is incorrect");
		String verifyChecked = loginPage.verifyRememberMe();
		Assert.assertEquals(verifyChecked, "true", "Rememeber Me is not checked");
		
	}
	
	@Test(priority=4)
	public void forgotPsw() {
		System.out.println("Test Case 4A - forgotPsw method is called");
		loginPage.clickForgotPswLink();
		Boolean frgtpswdisplayed = frgpswPg.verifyForgotPswPageDisplayed();
		Assert.assertTrue(frgtpswdisplayed, "Forgot Page is not displayed");
		frgpswPg.enterUsernameFrgPsw();
		frgpswPg.clickContineFrgPsw();
		Boolean chkurmailstatus = chkEmailPg.verifyChkEmailPgisDisplayed();
		Assert.assertTrue(chkurmailstatus, "Check your Email page is not displayed");
		
	}
	
	
	@Test
	public void inCorrectCredentialErrorMsg() {
		System.out.println(" Test Case 4B -loginErrorMsg method is called");
		loginPage.enterUsername("123");
		loginPage.enterPassword("2231");
		loginPage.clickLogin();
		String actualincorrectCredErrorMsg = loginPage.verifyErrorMsg();
		Assert.assertEquals(actualincorrectCredErrorMsg, expectedincorrectCredErrorMsg, "Incorrect error msg displayed");
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("Step 5: @AfterTestMethod is called to close the browser");
		closeBrowser();
	}

}
