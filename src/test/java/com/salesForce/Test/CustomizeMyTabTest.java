package com.salesForce.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SalesForce.Base.BaseTest;
import com.salesForce.Pages.CustomizeMyTabPage;
import com.salesForce.Pages.HomePage;
import com.salesForce.Pages.MyProfilePage;
import com.salesForce.Pages.SDLCLoginPage;

public class CustomizeMyTabTest extends BaseTest{

	WebDriver driver;
	HomePage homePg;
	MyProfilePage profilePg;
	SDLCLoginPage loginPage;
	CustomizeMyTabPage customizeTabPg;
	String usernamevalue = getLoginCredential("UserName");
	String pswValue = getLoginCredential("Password");
	String picpath ="C:/Users/Monica Jude/Desktop/TekArch/MyPic.PNG";
	
	

	@BeforeMethod
	public void passDriver() {
		System.out.println("Step 1: As soon as test is triggered @BeforeMethod is called ");
	driver = lauchApplication();
	homePg = new HomePage(driver);
	loginPage  = new SDLCLoginPage(driver);
	profilePg = new MyProfilePage(driver);
	customizeTabPg = new CustomizeMyTabPage(driver);
	}


	@Test
	public void customizeTab() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickUserMenu();
		homePg.clickOnALLTabPlus();
		customizeTabPg.clickOnCustomizeMyTabs();
		customizeTabPg.selectAvailableDropDown();
		customizeTabPg.clickOnaddBtn();
		customizeTabPg.clickOnsaveBtn();
		Boolean assetTabDisplayed = homePg.AssetTabDisplayed();
		System.out.println("assetTabDisplayed:" + assetTabDisplayed);
		Assert.assertTrue(assetTabDisplayed);
		customizeTabPg.clickOnCustomizeMyTabs();
		customizeTabPg.selectSelectedDropDown();
		customizeTabPg.clickOnRemoveBtn();
		customizeTabPg.clickOnsaveBtn();
		Boolean assetTabDisplayedFalse = homePg.AssetTabDisplayed();
		System.out.println("assetTabDisplayedFalse:" + assetTabDisplayedFalse);
		Assert.assertFalse(assetTabDisplayedFalse);
	}
	
	//@AfterMethod
	public void tearDown() {
		System.out.println("Step 5: @AfterTestMethod is called to close the browser");
		closeBrowser();
	}
}
