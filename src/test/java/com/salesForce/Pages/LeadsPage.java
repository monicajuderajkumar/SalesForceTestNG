package com.salesForce.Pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SalesForce.Base.BasePage;

public class LeadsPage extends BasePage{

	 public LeadsPage(WebDriver driver) {
		 super(driver);
	 }
	 
		
	
		@FindBy(xpath="//div[@id='lea3_ileinner']")
		WebElement newlyCreatedCompany;
		
		@FindBy(xpath="//table[@class='x-grid3-row-table']/tbody/tr/td[5]/div/a")
		WebElement newlyCreatedLeadCompanyNameinTodaysDeal;
		
		public String getTodaysLeadData(){
			explicitWait(newlyCreatedLeadCompanyNameinTodaysDeal);
			return (newlyCreatedLeadCompanyNameinTodaysDeal.getText().trim());
		}
		public String getNewlyCreatedLeadData(){
			explicitWait(newlyCreatedCompany);
			return (newlyCreatedCompany.getText().trim());
		}
		
		@FindBy(xpath="//td[@id='bottomButtonRow']//input[@name='save']")
		WebElement saveBtn;
		
		public void clickonsaveNewLead(){
			explicitWait(saveBtn);
			saveBtn.click();
		}
		
		 @FindBy(xpath="//input[@name='new']")
			WebElement newBtnCreateLeads;
		 
		 @FindBy(xpath="//input[@id='name_firstlea2']")
			WebElement firstNameTxt;
		 
		 @FindBy(xpath="//input[@id='name_lastlea2']")
			WebElement lastNameTxt;
		 
		 @FindBy(xpath="//input[@id='lea3']")
			WebElement companyNameTxt;
		 
		 public void entercompanyNameTxt(String companyName){
				explicitWait(companyNameTxt);
				companyNameTxt.sendKeys(companyName);
			}
		 
		 public void enterfirstNameTxt(String firstName){
				explicitWait(firstNameTxt);
				firstNameTxt.sendKeys(firstName);
			}
		 
		 public void enterlastNameTxt(String lastName){
				explicitWait(lastNameTxt);
				lastNameTxt.sendKeys(lastName);
			}
		 
		 public void clickonnewBtnCreateLeads(){
				explicitWait(newBtnCreateLeads);
				newBtnCreateLeads.click();
			}
		 
	 @FindBy(xpath="//h1[@class='pageType']")
		WebElement Leadsheading;
	 
	 @FindBy(xpath="//select[@id='fcf']//option")
		List<WebElement> leadsDropDownList;
	 
	 @FindBy(css="span#userNavLabel")
		WebElement userMenu;
	
	 
	 @FindBy(xpath="//select[@id='fcf']")
		WebElement leadsDropDown;
	 
	 
	 @FindBy(xpath="//input[@title='Go!']")
		WebElement goBtn;
	 
	 public void clickonGoBtn(){
			explicitWait(goBtn);
			goBtn.click();
		}
	 
	 public void selectleadsDropDown() {
		  explicitWait(leadsDropDown);
		  selectDropDown(leadsDropDown, "My Unread Leads" , "selectByVisibleText");
	  }
	 
	 public void selectleadsDropDownTodaysLead() {
		  explicitWait(leadsDropDown);
		  selectDropDown(leadsDropDown, "Today's Leads" , "selectByVisibleText");
	  }
	 
	 public boolean verifyselectedOptionleadsDropDown(String expectedSelectedOption) {
		 Boolean selLeadsDD=false; 
		 explicitWait(leadsDropDown);
		  String selectedoptionDropDown = verifySelOptioninDropDown(leadsDropDown);
		 if(selectedoptionDropDown.equalsIgnoreCase(expectedSelectedOption)) {
			 selLeadsDD = true; 
		 }
		 return selLeadsDD;
	  }
	 
	 public String getLeadsHeading(){
			explicitWait(Leadsheading);
			String LeadHeading = Leadsheading.getText();
			return LeadHeading;
		}
	 
	 public List<String> expectedLeadMenu() {
			List<String> expectedLeadMenuList = new ArrayList<String>(Arrays.asList("All Open Leads", "My Unread Leads", "Recently Viewed Leads", "Today's Leads", "View - Custom 1", "View - Custom 2"));
		    System.out.println("Lead Menu List: "+ expectedLeadMenuList.size()); 
			return expectedLeadMenuList;
		}
	 public List<String> getActualUserMenu() {
			List<String> actualLeadMenuList = new ArrayList<String>();
			 for (WebElement ele:leadsDropDownList) {
				 String menuList = ele.getText();
				 actualLeadMenuList.add(menuList);
			 }
			 return actualLeadMenuList;
		}
		
	 public Boolean verifyLeadsDropDown() {
		 Boolean leadDropDownFlag = false;
		 List<String> expectedLeadMenuList = expectedLeadMenu();
		 List<String> actualLeadMenuList = getActualUserMenu();
		 if(expectedLeadMenuList.equals(actualLeadMenuList)) {
			 leadDropDownFlag = true;
		 }
		return leadDropDownFlag;
	 }
}
