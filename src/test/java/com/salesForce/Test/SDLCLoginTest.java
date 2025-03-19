package com.salesForce.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SalesForce.Base.BaseTest;
import com.SalesForce.Listener.customListeners;
import com.salesForce.Pages.CheckYourEmailPage;
import com.salesForce.Pages.ForgorPswPage;
import com.salesForce.Pages.HomePage;
import com.salesForce.Pages.SDLCLoginPage;
import com.saslesForce.Utilities.ExcelDataReader;
import com.saslesForce.Utilities.ExcelReader;
import com.saslesForce.Utilities.JsonReader;
import com.saslesForce.Utilities.ReadPropertiesFile;
import com.saslesForce.Utilities.ScreenShot;
import com.SalesForce.Listener.RetryFailed;

@Listeners(customListeners.class)
public class SDLCLoginTest extends BaseTest{
	
	SDLCLoginPage loginPage;
	customListeners custListeners;
	//HomePage homePg;
	ForgorPswPage frgpswPg;
	CheckYourEmailPage chkEmailPg;
	WebDriver driver;
	//ThreadLocal<WebDriver> driver;
	ReadPropertiesFile readPropFile;
	ScreenShot shot;
	HomePage homePg;
	String expectedErrorMsg = "Please enter your password.";
	String expectedincorrectCredErrorMsg = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	String usernamevalue = getLoginCredential("UserName");
	String pswValue = getLoginCredential("Password");
	public Logger log;
	
	@BeforeMethod
	public void passDriver() {
	//	System.out.println("**Thread ID**: "+ Thread.currentThread().getId());
		log= LogManager.getLogger(BaseTest.class.getClass());
		log.info("Called Before Method");
		System.out.println("Step 1: As soon as test is triggered @BeforeMethod is called ");
	driver = lauchApplication();
	log.info("Obtained Driver");
	ExcelDataReader excel = new ExcelDataReader();
	//loginPage  = new SDLCLoginPage(driver);
	//homePg = new HomePage(driver);
	//frgpswPg = new ForgorPswPage(driver);
	//chkEmailPg= new CheckYourEmailPage(driver);
	loginPage  = new SDLCLoginPage(driver);
	//homePg = new HomePage(driver);
	frgpswPg = new ForgorPswPage(driver);
	chkEmailPg= new CheckYourEmailPage(driver);
	}
	
//@Test(priority=1 , groups="Smoke" , retryAnalyzer=RetryFailed.class)
	
	@Test
	public void loginErrorMsg() {
		log.error("Called loginErrorMsg Test Script");
		System.out.println("Step 4: @Test Test Case 1 -loginToError method is called");
		loginPage.enterUsername(usernamevalue);
		loginPage.clearPassword();
		loginPage.clickLogin();
		String actualerrormsgdis = loginPage.verifyWithoutPswError();
		Assert.assertEquals(actualerrormsgdis, expectedErrorMsg);
		log.error("Incorrect error message: Actual Error Msg"+ actualerrormsgdis + "Expected Error Msg :"+ expectedErrorMsg);
	}
	
	@Test(priority=2)
	public void loginToSalesForce() {
		System.out.println("Step 4: @Test Test Case 2 -loginToSalesForce method is called");
		System.out.println("UserName is :" + usernamevalue);
		System.out.println("Password is: "+ pswValue);
		loginPage.enterUsername(usernamevalue);
		loginPage.enterPassword(pswValue);
		HomePage homePg = loginPage.clickLogin();
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
		HomePage homePg = loginPage.clickLogin();
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
	
	
	@Test(dataProvider = "getUserdata" , enabled=true)
	public void inCorrectCredentialErrorMsg(String userName, String Password , String expectedErrMsg) {
		System.out.println(" Test Case 4B -loginErrorMsg method is called");
		loginPage.enterUsername(userName);
		loginPage.enterPassword(Password);
		loginPage.clickLogin();
		String actualincorrectCredErrorMsg = loginPage.verifyErrorMsg();
		Assert.assertEquals(actualincorrectCredErrorMsg, expectedincorrectCredErrorMsg, expectedErrMsg);
	}
	
	@Test(dataProvider = "getUserdataJson" , enabled=true)
	public void inCorrectCredentialErrorMsgMap(HashMap<String, String> data) {
		System.out.println(" Test Case 4B -loginErrorMsg method is called");
		loginPage.enterUsername(data.get("userName"));
		loginPage.enterPassword(data.get("Password"));
		loginPage.clickLogin();
		String actualincorrectCredErrorMsg = loginPage.verifyErrorMsg();
		Assert.assertEquals(actualincorrectCredErrorMsg, expectedincorrectCredErrorMsg);
	}
	
	@DataProvider
	public Object[][] getUserdata() {
		
		return new Object[][] {{"78655" , "Welcome1" ,"Incorrect error msg displayed"},{"6512" , "Jude", "Incorrect error msg displayed"}, {"7863" , "rhs" , "Incorrect error msg displayed"}};
}
	
	@DataProvider
	public Object[][] getUserdataJson() throws IOException {
		
		List<HashMap<String, String>> data = JsonReader.callJsonReader();
		System.out.println("How many Data: " + data.size());
		//for(int i=0; i<data.size(); i++) {
		return new Object[][] {{data.get(0)}};
		//}
		
}
	
	@DataProvider
	public Object[][] getUserMapdata() {
	
		HashMap<String, String> data1 = new HashMap<String, String>();
		data1.put("userName", "HolySpirt");
		data1.put("Password", "WelcomeHolySpirt");
		//data1.put("expectedErrMsg", "Incorrect error msg displayed");
		
		HashMap<String, String> data2 = new HashMap<String, String>();
		data2.put("userName", "FathAndSon");
		data2.put("Password", "WelcomeHolyFamily");
		//data2.put("expectedErrMsg", "Incorrect error msg displayed");
		
		return new Object[][] {{data1},{data2}};
	}
	
	@Test(dataProvider = "getUserLogindataFromExcel" , enabled=true)
	public void inCorrectCredentialErrorMsgExcel(String Username , String password) {
		System.out.println(" Test Case 4B -loginErrorMsg method is called");
		System.out.println(" UserName: "+ Username);
		System.out.println(" Password: "+ password);
		loginPage.enterUsername(Username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		String actualincorrectCredErrorMsg = loginPage.verifyErrorMsg();
		Assert.assertEquals(actualincorrectCredErrorMsg, expectedincorrectCredErrorMsg);
	}
	
	@Test(dataProvider = "getUserinvalidLogindataFromExcel" , enabled=true)
	public void inCorrectCredentialErrorMsgExcelinvalid(String Username , String password) {
		System.out.println(" Test Case 4B -loginErrorMsg method is called");
		System.out.println(" UserName: "+ Username);
		System.out.println(" Password: "+ password);
		loginPage.enterUsername(Username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		String actualincorrectCredErrorMsg = loginPage.verifyErrorMsg();
		Assert.assertEquals(actualincorrectCredErrorMsg, expectedincorrectCredErrorMsg);
	}
	
	@DataProvider
	//ExcelDataReader - Sheet Wise
	public static Object[][] getUserLogindataFromExcel() throws Exception{
		Object[][] data = ExcelDataReader.readDataFromExcel("UserLogin");
		System.out.println("Data***: " + data.length);
		return data;
	}
	
	@DataProvider
	//ExcelReader - Based on test case name
	public static Object[][] getUserinvalidLogindataFromExcel() throws Exception{
		Object[][] data = ExcelReader.readDataFromExcel("SalesForceData");
		System.out.println("Data***: " + data.length);
		return data;
	}
	
	
	
	@DataProvider
	public static Object[][] getUserdataFromExcel() throws IOException {		
		DataFormatter format = new DataFormatter();
		FileInputStream fis = new FileInputStream("C:\\Workspace\\com.testNGFrameWork.SalesForce\\src\\main\\java\\com\\SalesForce\\Data\\TestData.xlsx");
		Workbook wbook = WorkbookFactory.create(fis);
		int sheetCount = wbook.getNumberOfSheets();
		System.out.println("Sheet Count: "+ sheetCount);
		Sheet wsheet = wbook.getSheetAt(0);
		int rowCount = wsheet.getPhysicalNumberOfRows();
		Row r = wsheet.getRow(0);
		System.out.println("Row Count:"+ rowCount);
		int columnCount = r.getLastCellNum();
		System.out.println("Colum Count:"+ columnCount);
		//int columnCount = firstRow.getPhysicalNumberOfCells();
		Object data[][] =  new Object[rowCount][columnCount];
		// i=1  Row 1 is heading, so ignoring row 0
		for(int m=1; m<rowCount; m++) {
			r = wsheet.getRow(m); 
		    for (int n=0; n<columnCount; n++) {
		    	Cell cdata = r.getCell(n);
		    	format.formatCellValue(cdata);
		    	System.out.println(format.formatCellValue(cdata));
		    	data[m][n] = format.formatCellValue(cdata);	
		    }			    
	   }
		return data;
	}
		/*for(int i=0; i<sheetCount; i++) {
			if(wbook.getSheetName(i).equalsIgnoreCase("UserLogin")) {
				Sheet wsheet = wbook.getSheetAt(i);
				int rowCount = wsheet.getPhysicalNumberOfRows();
				System.out.println("Row Count in sheet: "+ rowCount);
				Row r = wsheet.getRow(1);
				int columnCount = r.getLastCellNum();
				System.out.println("Colum Count:"+ columnCount);
				//int columnCount = firstRow.getPhysicalNumberOfCells();
				Object data[][] =  new Object[rowCount][columnCount];
				// i=1  Row 1 is heading, so ignoring row 0
				for(int m=1; m<rowCount; m++) {
					r = wsheet.getRow(m); 
				    for (int n=0; n<columnCount; n++) {
				    	Cell cdata = r.getCell(n);
				    	format.formatCellValue(cdata);
				    	System.out.println(format.formatCellValue(cdata));
				    	data[m][n] = format.formatCellValue(cdata);	
				    }			    
			   }
				return data;*/
			
				
		
		
		 		
	
	
	
	
	@AfterMethod
	public void tearDown() {
		log.info("Called After Test Method");
		System.out.println("Step 5: @AfterTestMethod is called to close the browser");
		closeBrowser();
	}

}
