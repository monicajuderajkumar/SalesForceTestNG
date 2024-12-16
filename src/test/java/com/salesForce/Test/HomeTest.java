package com.salesForce.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SalesForce.Base.BaseTest;
import com.salesForce.Pages.CheckYourEmailPage;
import com.salesForce.Pages.ForgorPswPage;
import com.salesForce.Pages.HomePage;
import com.salesForce.Pages.MyProfilePage;
import com.salesForce.Pages.SDLCLoginPage;

public class HomeTest extends BaseTest{
      
	WebDriver driver;
	HomePage homePg;
	MyProfilePage profilePg;
	SDLCLoginPage loginPage;
	String usernamevalue = getLoginCredential("UserName");
	String pswValue = getLoginCredential("Password");
	String picpath ="C:/Users/Monica Jude/Desktop/TekArch/MyPic.PNG";
	
	
	@BeforeMethod
	public void passDriver() {
		System.out.println("Step 1: As soon as test is triggered @BeforeMethod is called ");
	driver = getDriver();
	homePg = new HomePage(driver);
	loginPage  = new SDLCLoginPage(driver);
	profilePg = new MyProfilePage(driver);
	}
	
	@Test
	public void UserMenuDropDown() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickUserMenu();
		Boolean menuListFlag = homePg.verifyUserMenu();
		Assert.assertTrue(menuListFlag, "User Menu is not displayed correctly");
	}

	
	@AfterMethod
	public void tearDown() {
		System.out.println("Step 5: @AfterTestMethod is called to close the browser");
		closeBrowser();
	}
}
