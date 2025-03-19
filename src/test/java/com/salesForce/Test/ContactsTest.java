package com.salesForce.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SalesForce.Base.BaseTest;
import com.salesForce.Pages.ContactsPage;
import com.salesForce.Pages.CreateAccountPage;
import com.salesForce.Pages.HomePage;
import com.salesForce.Pages.MergeAccountsPage;
import com.salesForce.Pages.ReportsPage;
import com.salesForce.Pages.SDLCLoginPage;

public class ContactsTest extends BaseTest{

	WebDriver driver;
	HomePage homePg;
	SDLCLoginPage loginPage;
	ContactsPage contactPg;
	
	
	String usernamevalue = getLoginCredential("UserName");
	String pswValue = getLoginCredential("Password");
	
	@BeforeMethod
	public void passDriver() {
		System.out.println("Step 1: As soon as test is triggered @BeforeMethod is called ");
	driver = lauchApplication();
	homePg = new HomePage(driver);
	loginPage  = new SDLCLoginPage(driver);
	contactPg = new ContactsPage(driver);
	}
	
	
	@Test
	public void createContacts() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonContactsTab();
		contactPg.clickonNewBtnCreateContact();
		contactPg.enterLastNameContactsPage("MotherMary");
		contactPg.clickonSaveBtnContactsPage();
		String contacName = contactPg.getContactsName();
		Assert.assertEquals(contacName, "MotherMary");
	}
	
	
	@Test
	public void createNewViewContacts() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonContactsTab();
		contactPg.clickoncreateNewViewLink();
		contactPg.enterViewNameContactTxt("SonOfGod");
		contactPg.enterViewUniqueNameContactTxt("Jesus");
		contactPg.clickonsaveCreateViewContactBtn();
		String selectedoptionDropDown = contactPg.verifyContactDropDown();
		Assert.assertEquals(selectedoptionDropDown, "SonOfGod");
	}
	

	@Test
	public void verifyRecentlyCreatedContact() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonContactsTab();
		String verifyNewlycreatedAccount = contactPg.getValuefromContactTable("MotherMary");
		Assert.assertEquals(verifyNewlycreatedAccount, "MotherMary");
	}
	
	@Test
	public void verifyMyContactsfromDropDowm() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonContactsTab();
		contactPg.selectcontactDropDown();
		String verifyNewlycreatedAccount = contactPg.getValuefromContactTable("MotherMary");
		Assert.assertEquals(verifyNewlycreatedAccount, "MotherMary");
	}
	
	@Test
	public void verifyCreatedContact() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonContactsTab();
		contactPg.selectValuefromContactTable("MotherMary");
		String contactName = contactPg.getContactName();
		Assert.assertEquals(contactName, "MotherMary");
		String contactAccountName =contactPg.getContactAccountName();
		Assert.assertEquals(contactAccountName, "HolySpirit");
	}
	
	
	@Test
	public void verifyErrorMsgwithouViewName() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonContactsTab();
		contactPg.clickoncreateNewViewLink();
		contactPg.enterViewUniqueNameContactTxt("Jesus");
		contactPg.clickonsaveCreateViewContactBtn();
		String errorMsg =contactPg.geterrorMsg();
		Assert.assertEquals(errorMsg, "Error: You must enter a value");
	}
	
	@Test
	public void verifyCancelBtninCreateView() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonContactsTab();
		contactPg.clickoncreateNewViewLink();
		contactPg.enterViewNameContactTxt("ABCD");
		contactPg.enterViewUniqueNameContactTxt("EFGH");
		contactPg.clickonCancelBtn();
		Boolean optionPresent = contactPg.verifyOptionsNotPresentList("ABCD");
		Assert.assertFalse(optionPresent);
	}
	
	
	@Test
	public void verifySaveandNewFun() {
		loginPage.enterUsername(usernamevalue);	
		loginPage.enterPassword(pswValue);
		loginPage.clickLogin();
		Boolean homeTabDisplayed =homePg.HomeTabDisplayed();
		Assert.assertTrue(homeTabDisplayed);
		homePg.clickonContactsTab();
		contactPg.clickonNewBtnCreateContact();
		contactPg.enterLastNameContactsPage("Lourdes");
		contactPg.clickonSavendNewBtn();
		String heading = contactPg.getCreateNewPgHeading();
		Assert.assertEquals(heading, "Contact Edit");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Step 5: @AfterTestMethod is called to close the browser");
		closeBrowser();
	}
}
