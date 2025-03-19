package com.salesForce.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SalesForce.Base.BaseTest;
import com.salesForce.Pages.CreateAccountPage;
import com.salesForce.Pages.DeveloperConsolePage;
import com.salesForce.Pages.HomePage;
import com.salesForce.Pages.MergeAccountsPage;
import com.salesForce.Pages.ReportsPage;
import com.salesForce.Pages.SDLCLoginPage;
import com.saslesForce.Utilities.ExcelDataReader;

public class CreateAccountTest extends BaseTest{
	WebDriver driver;
	HomePage homePg;
	SDLCLoginPage loginPage;
	CreateAccountPage accountsPage;
	MergeAccountsPage mergeAccPage;
	ReportsPage reportsPage;
	
	String usernamevalue = getLoginCredential("UserName");
	String pswValue = getLoginCredential("Password");
	//String newAccName = "ThunderStorm";
	//String expectedAccType ="Technology Partner";
	//String expectedCustomerPriority ="High";
	String viewName = "HeavenlyGod";
	String viewUniqueName = "GodofMercy";
	String accountNameValue = "DemoMerge";
	
	@BeforeMethod
	public void passDriver() {
		System.out.println("Step 1: As soon as test is triggered @BeforeMethod is called ");
	driver = lauchApplication();
	homePg = new HomePage(driver);
	loginPage  = new SDLCLoginPage(driver);
	accountsPage = new CreateAccountPage(driver);
	mergeAccPage = new MergeAccountsPage(driver);
	reportsPage = new ReportsPage(driver);
	}
	
	@Test(dataProvider="getcreateNewAccountdataFromExcel")
	public void createNewAccount(String newAccName, String expectedAccType, String expectedCustomerPriority) {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonAccountsTab();
		accountsPage.clickonCreateNewAccBtn();
		accountsPage.newAccName(newAccName);
		accountsPage.selectAccTypeDropDown();
		accountsPage.selectcustomerPriorityDropDown();
		accountsPage.clickonSaveBtnCreateAct();
		String newlycreatedAccountName = accountsPage.getnewAccName();
		Assert.assertEquals(newlycreatedAccountName, newAccName);
		String newAccType = accountsPage.getnewCreatedAccType();
		Assert.assertEquals(expectedAccType, newAccType);
		String newCustomerPriority = accountsPage.getnewCreatedCustomerPriority();
		Assert.assertEquals(expectedCustomerPriority, newCustomerPriority);
	}
	
	@DataProvider
	public static Object[][] getcreateNewAccountdataFromExcel() throws Exception{
		Object[][] data = ExcelDataReader.readDataFromExcel("CreateAccount");
		return data;
	}
	
	@Test
	public void createNewViewAccount() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonAccountsTab();
		accountsPage.clickonCreateNewView();
		accountsPage.enterviewName(viewName);
		accountsPage.enterviewUniqueName(viewUniqueName);
		accountsPage.clickonSaveBtnCreateNewView();
		String selectedoptionDropDown =  accountsPage.verifySelOptioniviewAccDropDown();
		Assert.assertEquals(viewName, selectedoptionDropDown);
	}
	
	@Test
	public void editViewAccount() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonAccountsTab();
		accountsPage.selectviewAccDropDropDown();
		accountsPage.clickonEditViewLink();
		accountsPage.editviewName("RoseHanse");
		accountsPage.selectfieldDropDown();
		accountsPage.selectoperatorDropDown();
		accountsPage.enterAccNameValue(accountNameValue);
		accountsPage.selectavailablefieldDropDown();
		accountsPage.clickonAddBtn();
		accountsPage.clickonSaveBtnEdit();
		String lastActivityAccountName = accountsPage.getlastActAccNameEdit();
		Assert.assertEquals(lastActivityAccountName, accountNameValue);
	}
	
	
	@Test
	public void mergeAccount() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonAccountsTab();
		accountsPage.clickonmergeAccLink();
		mergeAccPage.entersearchTxtValue("DemoMerge");
		mergeAccPage.clickfindAccBtn();
		Assert.assertTrue(mergeAccPage.verifyMergeTableDisplayed());
		mergeAccPage.clickfirstMergeAcc();
		mergeAccPage.clicksecondMergeAcc();
		mergeAccPage.clickNextBtnMergeAcc();
		mergeAccPage.clickmergeBtnMergeAcc();
		mergeAccPage.acceptAlert();
	}
	
	
	@Test
	public void createReportLast30Activity() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonAccountsTab();
		accountsPage.clickonAccLastActivitylink();
		reportsPage.clickonRangeDropDown();
		reportsPage.moveToSelectAllTimeClick();
		reportsPage.clickonRunReportBtn();
		reportsPage.clickonsaveAsListReport();
		reportsPage.enterreportNameTxt("FinalVersion2024");
		reportsPage.enterreportUniqueNameTxt("FinalVersion2024Book1");
		reportsPage.clickonsaveReturntoReport();
		String reportNameValue = reportsPage.getreportNameSaved();
		Assert.assertEquals("FinalVersion2024", reportNameValue);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Step 5: @AfterTestMethod is called to close the browser");
		closeBrowser();
	}
}
