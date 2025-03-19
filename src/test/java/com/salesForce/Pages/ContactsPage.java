package com.salesForce.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SalesForce.Base.BasePage;

public class ContactsPage extends BasePage{

	String rowSizeXpath = "//table[@class='list']//tbody//tr";
	String newContactNameBeforeXpath = "//table[@class='list']//tbody//tr[";
     String newContactNameAfterXpath = "]//th";
  
   
	public ContactsPage(WebDriver driver) {
		super(driver);
	}
	
	 @FindBy(xpath="//input[@title='New']")
		WebElement newBtn;
	 
	 @FindBy(linkText="Create New View")
		WebElement createNewViewLink;
	 
	 @FindBy(xpath="//input[@id='fname']")
		WebElement viewNameTxt;
	 
	 @FindBy(xpath="//input[@id='devname']")
		WebElement viewUniqueNameTxt;
	 
	 @FindBy(xpath="//div[@class='pbBottomButtons']//input[@title='Save']")
		WebElement saveCreateViewContactBtn;
	 
	 @FindBy(xpath="//select[@name='fcf']")
		WebElement contactDropDown;
	 
	 @FindBy(xpath="//div[@id='con2_ileinner']")
		WebElement contactName;
	 
	 @FindBy(xpath="//div[@id='con4_ileinner']")
		WebElement contactAccName;
	 
	 @FindBy(xpath="//div[@class='errorMsg']")
		WebElement errMsg;
	 
	 @FindBy(xpath="//div[@class='pbBottomButtons']//input[@title='Cancel']")
		WebElement cancelBtn;
	 
	 @FindBy(xpath="//select[@name='fcf']/option")
		List<WebElement> ContactViewListDDList;
	 
	 @FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save & New']")
		WebElement savendNewBtn;
	 
	 @FindBy(xpath="//h2[@class='mainTitle']")
		WebElement CreateContactPageheading;
	 
	 public String getCreateNewPgHeading() {
		 explicitWait(CreateContactPageheading);
		 return CreateContactPageheading.getText();
	 }
	 public void clickonSavendNewBtn() {
		 savendNewBtn.click();
	 }
	 public boolean verifyOptionsNotPresentList(String option) {
		Boolean optionPresent = false;
			for (WebElement ele : ContactViewListDDList) {
				String eachItem = ele.getText();
				System.out.println(eachItem);
				if(eachItem.equals(option)) {
					optionPresent = true;
				}
			}	
			return optionPresent;
			}
			
	 public void clickonCancelBtn() {
		 cancelBtn.click();
	 }
	 public String geterrorMsg() {
		 explicitWait(errMsg);
		 return errMsg.getText();
	 }
	 public String getContactName() {
		 explicitWait(contactName);
		 return contactName.getText();
	 }
	 
	 public String getContactAccountName() {
		 explicitWait(contactAccName);
		 return contactAccName.getText();
	 }
	 public void selectcontactDropDown() {
		  explicitWait(contactDropDown);
		  selectDropDown(contactDropDown, "My Contacts" , "selectByVisibleText");
	  }
	 
	 public String verifyContactDropDown(){
			explicitWait(contactDropDown);
			String selectedoptionDropDown =verifySelOptioninDropDown(contactDropDown);
			return selectedoptionDropDown;
		} 
	 
	 public String getValuefromContactTable(String accName) {
		 //String OriginalXpath = "//table[@class='list']//tbody//tr["+i+"]//th";
		// System.out.println(OriginalXpath.split(""+""));
		 String elementName = getValueFromTable(rowSizeXpath, newContactNameBeforeXpath, newContactNameAfterXpath, accName); 
		 System.out.println("***getValuefromContactTable:" + elementName);
		 return elementName;
		} 
	 
	 public void selectValuefromContactTable(String accName) {
		
		 selectValueFromTable(rowSizeXpath, newContactNameBeforeXpath, newContactNameAfterXpath, accName); 
		 
		} 
	
	 public void clickonsaveCreateViewContactBtn(){
			explicitWait(saveCreateViewContactBtn);
			saveCreateViewContactBtn.click();
		} 
	 public void enterViewUniqueNameContactTxt(String txt){
			explicitWait(viewUniqueNameTxt);
			viewUniqueNameTxt.clear();
			viewUniqueNameTxt.sendKeys(txt);
		}
	 
	 public void enterViewNameContactTxt(String txt){
			explicitWait(viewNameTxt);
			viewNameTxt.sendKeys(txt);
		}
	 
	 public void clickoncreateNewViewLink(){
			explicitWait(createNewViewLink);
			createNewViewLink.click();
		}
	 
	 public void clickonNewBtnCreateContact(){
			explicitWait(newBtn);
			newBtn.click();
		}
	 @FindBy(xpath="//input[@id='name_lastcon2']")
		WebElement lastnameTxt;
	 
	 public void enterLastNameContactsPage(String txt){
			explicitWait(lastnameTxt);
			lastnameTxt.sendKeys(txt);
		}
	 
	 @FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save']")
		WebElement saveBtn;
	 
	 public void clickonSaveBtnContactsPage(){
			explicitWait(saveBtn);
			saveBtn.click();
		}
	 
	 @FindBy(css="h2.topName")
		WebElement fullName;
	 
	 public String getContactsName(){
			explicitWait(fullName);
			return fullName.getText().trim();
		}
		
	 
}
