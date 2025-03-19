package com.salesForce.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SalesForce.Base.BaseTest;
import com.salesForce.Pages.HomePage;
import com.salesForce.Pages.MyProfilePage;
import com.salesForce.Pages.SDLCLoginPage;

public class MyProfileTest extends BaseTest{

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
	driver = lauchApplication();
	homePg = new HomePage(driver);
	loginPage  = new SDLCLoginPage(driver);
	profilePg = new MyProfilePage(driver);
	}
	
	@Test
	public void myProfileChanges() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickUserMenu();
		Boolean menuListFlag = homePg.verifyUserMenu();
		Assert.assertTrue(menuListFlag, "User Menu is not displayed correctly");
		Boolean MyProfileLinkDisplayed =homePg.verifyProfileLink();
		Assert.assertTrue(MyProfileLinkDisplayed, "My profile link is not displayed");
		homePg.clickMyProfileLink();
		profilePg.clickEditProfileimg();
		Boolean profileTextDisplayed =profilePg.verifyeditProfilepageDisplayed();
		Assert.assertTrue(profileTextDisplayed, "EditProfile is not displayed");
		profilePg.switchToEditProfileFrame();
	   profilePg.clickOnAboutsTab();
		profilePg.editLastNameAboutTab("Rajan");
		String AboutFullName =profilePg.getEditedFullNameAboutsTab();
		profilePg.clickSaveBtnAboutsTab();
		profilePg.switchTodefaultContent();
		String profileNameStr= profilePg.getProfileNameTxt();
		Assert.assertEquals (AboutFullName, profileNameStr, "Profile Name is not updated");
		profilePg.clickonPostLink();
		profilePg.switchToPostFrame();
		profilePg.postTxT("I like to drink juice");
		profilePg.switchTodefaultContent();
		profilePg.clickonSharepostTxt();
		profilePg.clickonFileLink();
		profilePg.clickonUploadFileFromComputerLink();
		profilePg.pathToBrowse(picpath);
		profilePg.clickonFileShareBtn();
		profilePg.moveToWebElement();
		profilePg.clickonAddPhotoLink();
		profilePg.switchTophotoBrowserFrame();
		profilePg.pathToBrowseImg(picpath);
		profilePg.clickonSaveBtnAddProfileImg();
		profilePg.cropProfileImg();
		profilePg.clickonCropSaveBtn();
	}
	
	@Test
	//TC -33 UserName
	public void verifyProfileName() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		String userNameHome = homePg.getUserName();
		Assert.assertEquals(userNameHome, "Monica Jude");
		homePg.clickUserMenu();
		homePg.clickMyProfileLink();
		String userNameProfilepg = profilePg.getUserNameProfilePg();
		Assert.assertEquals(userNameProfilepg, "Monica Jude");
		Assert.assertEquals(userNameHome, userNameProfilepg);
	}
	
	@Test
	//TC -34 Edited LastName
	public void editLastNameProfile() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickUserMenu();
		Boolean menuListFlag = homePg.verifyUserMenu();
		Assert.assertTrue(menuListFlag, "User Menu is not displayed correctly");
		Boolean MyProfileLinkDisplayed =homePg.verifyProfileLink();
		Assert.assertTrue(MyProfileLinkDisplayed, "My profile link is not displayed");
		homePg.clickMyProfileLink();
		profilePg.clickEditProfileimg();
		Boolean profileTextDisplayed =profilePg.verifyeditProfilepageDisplayed();
		Assert.assertTrue(profileTextDisplayed, "EditProfile is not displayed");
		profilePg.switchToEditProfileFrame();
	   profilePg.clickOnAboutsTab();
		profilePg.editLastNameAboutTab("Rajan");
		String AboutFullName =profilePg.getEditedFullNameAboutsTab();
		profilePg.clickSaveBtnAboutsTab();
		profilePg.switchTodefaultContent();
		String profileNameStr= profilePg.getProfileNameTxt();
		Assert.assertEquals (AboutFullName, profileNameStr, "Profile Name is not updated");
		homePg.clickOnHomeTab();
		String userNameHome = homePg.getUserName();
		Assert.assertEquals(userNameHome, "Monica Rajan");
		
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("Step 5: @AfterTestMethod is called to close the browser");
		closeBrowser();
	}
}
