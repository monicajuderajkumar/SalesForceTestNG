package com.salesForce.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SalesForce.Base.BaseTest;
import com.salesForce.Pages.HomePage;
import com.salesForce.Pages.MyProfilePage;
import com.salesForce.Pages.MySettingPage;
import com.salesForce.Pages.SDLCLoginPage;

public class MySettingTest extends BaseTest{
	WebDriver driver;
	HomePage homePg;
	MyProfilePage profilePg;
	SDLCLoginPage loginPage;
	MySettingPage mySetting;
	String usernamevalue = getLoginCredential("UserName");
	String pswValue = getLoginCredential("Password");
	String picpath ="C:/Users/Monica Jude/Desktop/TekArch/MyPic.PNG";
	String newEmailName = "Monica Jude Rajkumar";
	
 @BeforeMethod
 public void passDriver() {
		System.out.println("Step 1: As soon as test is triggered @BeforeMethod is called ");
	driver = lauchApplication();
	homePg = new HomePage(driver);
	loginPage  = new SDLCLoginPage(driver);
	profilePg = new MyProfilePage(driver);
	mySetting = new MySettingPage(driver);
	}
 
 @Test
	public void mySettingChanges() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickUserMenu();
		Boolean menuListFlag = homePg.verifyUserMenu();
		Assert.assertTrue(menuListFlag, "User Menu is not displayed correctly");
		mySetting.clickonMySettingLink();
		//mySetting.clickonpersonalLink();
		//mySetting.clickonLoginHistoryLink();
		//mySetting.clickonDownLoadFileLink();
		//Boolean downloadFlag = mySetting.verifyDownloadedFile();
		//Assert.assertTrue(downloadFlag, "File is not downloaded");
		//mySetting.clickonDisplayAndLayoutLink();
		//mySetting.clickonCustomizeMyTabLink();
		mySetting.selectCustomAppDropDown();
		//mySetting.selectValuesinAvailableTabs();
		//mySetting.clickonAddButtonCustMyTab();
		//Boolean isSelectedOption = mySetting.verifyeleinSelectedTab();
		//Assert.assertTrue(isSelectedOption, "Selected option is not listed");
		//mySetting.clickonSaveBtnCustMyTab();
		//mySetting.clickonemailLink();
		//mySetting.clickonemailSettingLink();
		//mySetting.editemailName(newEmailName);
		//mySetting.clickonRadioButton();
		//mySetting.clickonEmailSettingSaveBtn();
		//Boolean verifyEmailSettingFlag = mySetting.verifyEmailSettingInput();
		//Assert.assertTrue(verifyEmailSettingFlag, "Edited changes are not updated in Email Setting");
		mySetting.clickonCalendarAndReminder();
		mySetting.clickonActivityReminder();
		mySetting.clickonOpenTestReminderBtn();
		Boolean childWindowDisplayed = mySetting.verifyReminderPageisDisplayed();
		Assert.assertTrue(childWindowDisplayed);
 }
 

 @AfterMethod
	public void tearDown() {
		System.out.println("Step 5: @AfterTestMethod is called to close the browser");
		closeBrowser();
	}
 
}
