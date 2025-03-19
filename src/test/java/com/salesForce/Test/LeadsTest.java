package com.salesForce.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SalesForce.Base.BaseTest;
import com.salesForce.Pages.HomePage;
import com.salesForce.Pages.LeadsPage;
import com.salesForce.Pages.MyProfilePage;
import com.salesForce.Pages.SDLCLoginPage;

public class LeadsTest extends BaseTest{
	
	WebDriver driver;
	HomePage homePg;
	MyProfilePage profilePg;
	SDLCLoginPage loginPage;
	LeadsPage leadspage;
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
	leadspage = new LeadsPage(driver);
	}
	
	@Test
	public void VerifyLeadsPage() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonLeadsTab();
		String LeadHeading = leadspage.getLeadsHeading();
		Assert.assertEquals(LeadHeading, "Leads");
	}
	
	@Test
	public void VerifyLeadsDropDown() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonLeadsTab();
		String LeadHeading = leadspage.getLeadsHeading();
		Assert.assertEquals(LeadHeading, "Leads");
		Boolean leadDropDownFlag = leadspage.verifyLeadsDropDown();
		Assert.assertTrue(leadDropDownFlag);
	}
	
	@Test
	public void VerifyLeadsDropDownAfterLogout() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonLeadsTab();
		String LeadHeading = leadspage.getLeadsHeading();
		Assert.assertEquals(LeadHeading, "Leads");
		Boolean leadDropDownFlag = leadspage.verifyLeadsDropDown();
		Assert.assertTrue(leadDropDownFlag);
		leadspage.selectleadsDropDown();
		homePg.clickUserMenu();
		homePg.clickLogout();
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		homePg.clickonLeadsTab();
		Boolean selLeadsDD = leadspage.verifyselectedOptionleadsDropDown("My Unread Leads");
		Assert.assertTrue(selLeadsDD);
		leadspage.clickonGoBtn();
	}
	
	@Test
	public void createNewLead() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonLeadsTab();
		leadspage.clickonnewBtnCreateLeads();
		leadspage.enterfirstNameTxt("AABB");
		leadspage.enterlastNameTxt("CCDD");
		leadspage.entercompanyNameTxt("Jolly");
		leadspage.clickonsaveNewLead();
		String actualCompanyName = leadspage.getNewlyCreatedLeadData();
		Assert.assertEquals(actualCompanyName, "Jolly");
	}
	
	@Test
	public void verifyTodaysLead() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonLeadsTab();
		leadspage.selectleadsDropDownTodaysLead();
		leadspage.clickonGoBtn();
		String actualCompanyNameTD = leadspage.getTodaysLeadData();
		//Assert.assertEquals(actualCompanyNameTD, "Jolly");
	}
	
	//@AfterMethod
	public void tearDown() {
		System.out.println("Step 5: @AfterTestMethod is called to close the browser");
		closeBrowser();
	}

}
