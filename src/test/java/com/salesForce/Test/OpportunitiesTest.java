package com.salesForce.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SalesForce.Base.BaseTest;
import com.salesForce.Pages.CreateAccountPage;
import com.salesForce.Pages.HomePage;
import com.salesForce.Pages.MergeAccountsPage;
import com.salesForce.Pages.OpportunitiesPage;
import com.salesForce.Pages.ReportsPage;
import com.salesForce.Pages.SDLCLoginPage;

public class OpportunitiesTest extends BaseTest{
	
	WebDriver driver;
	HomePage homePg;
	SDLCLoginPage loginPage;
	CreateAccountPage accountsPage;
	OpportunitiesPage optyPage;
	
	String usernamevalue = getLoginCredential("UserName");
	String pswValue = getLoginCredential("Password");
	
	@BeforeMethod
	public void passDriver() {
		System.out.println("Step 1: As soon as test is triggered @BeforeMethod is called ");
	driver = lauchApplication();
	homePg = new HomePage(driver);
	loginPage  = new SDLCLoginPage(driver);
	optyPage = new OpportunitiesPage(driver);
	}
	
	@Test
	public void verifyOptyDropDown() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonOpportunityTab();
		optyPage.clickonOptyDropDown();
		Boolean listFlag = optyPage.verifyOptyDropDownList();
		Assert.assertTrue(listFlag);
	}
	
	@Test
	public void createNewOpportunity() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonOpportunityTab();
		optyPage.clickonCreateOptyBtn();
		optyPage.enteropportunityName("January2025");
		optyPage.clickTodaysDate();
		optyPage.selectstageDropDown();
		optyPage.clickonCampaignSearch();
		Boolean childWindowDisplayed = optyPage.verifyPrimaryCampaignSearchChildWindow();
		Assert.assertTrue(childWindowDisplayed);
		optyPage.switchToWindow("childWindow");
		optyPage.switchToPrimaryCampaignresultFrame();
		optyPage.clickonCampaignName();
		optyPage.switchToWindow("parentWindow");
		optyPage.clickonSaveBtnCreateOpty();
		String actualValue = optyPage.getnewlyCreateOpty();
		Assert.assertEquals(actualValue, "January2025");
	}
	
	
	@Test
	public void createOpportunityPipelineReport() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonOpportunityTab();
		optyPage.clickonOppPipelinelink();
		String actualValue = optyPage.getoppPipelinepagestatus();
		Assert.assertEquals(actualValue, "Complete");
	}
	

	@Test
	public void createOpportunityStuckReport() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonOpportunityTab();
		optyPage.clickonstuckOpplink();
		String actualValueStuck = optyPage.getoppstuckOppHeading();
		Assert.assertEquals(actualValueStuck, "Stuck Opportunities");
		String actualValueStatus = optyPage.getoppPipelinepagestatus();
		Assert.assertEquals(actualValueStatus, "Complete");
	}
	
	
	@Test
	public void verifyQuarterlySummaryReport() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonOpportunityTab();
		optyPage.selectOptyintervalDropDown();
		optyPage.clickonrunReportBtn();
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Step 5: @AfterTestMethod is called to close the browser");
		closeBrowser();
	}

}
