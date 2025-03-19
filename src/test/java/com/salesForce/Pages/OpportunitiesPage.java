package com.salesForce.Pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SalesForce.Base.BasePage;

public class OpportunitiesPage extends BasePage{

	public OpportunitiesPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//select[@id='fcf']//option")
	List<WebElement> OptyDropDowntList;
	
	@FindBy(xpath="//select[@id='fcf']")
	WebElement OptyDropDown;
	
	@FindBy(linkText="Opportunity Pipeline")
	WebElement OppPipelinelink;
	
	@FindBy(xpath="//input[@name='new']")
	WebElement newBtnCreateOpty;
	
	@FindBy(xpath="//div[@id='status']")
	WebElement oppPipelinepagestatus;
	
	@FindBy(linkText="Stuck Opportunities")
	WebElement stuckOpplink;
	
	@FindBy(xpath="//h1[text()='Stuck Opportunities']")
	WebElement stuckOppHeading;
	
	@FindBy(xpath="//div[@id='status']")
	WebElement stuckOpppagestatus;
	
	
	@FindBy(css="select#quarter_q")
	WebElement OptyintervalDropDown;
	
	@FindBy(xpath="//input[@value='Run Report']")
	WebElement runReportBtn;
	
	public void clickonrunReportBtn(){
		explicitWait(runReportBtn);
		runReportBtn.click();
	}
	public void selectOptyintervalDropDown() {
		  explicitWait(OptyintervalDropDown);
		  selectDropDown(OptyintervalDropDown, "Current and Next FQ" , "selectByVisibleText");
	  }
	
	public String getstuckOpppagestatus(){
		explicitWait(stuckOpppagestatus);
		String actualValueStatus = stuckOpppagestatus.getText();
		return actualValueStatus;
	}
	
	public String getoppstuckOppHeading(){
		explicitWait(stuckOppHeading);
		String actualValue = stuckOppHeading.getText();
		return actualValue;
	}
	
	public void clickonstuckOpplink(){
		explicitWait(stuckOpplink);
		stuckOpplink.click();
	}
	
	public String getoppPipelinepagestatus(){
		explicitWait(oppPipelinepagestatus);
		String actualValue = oppPipelinepagestatus.getText();
		return actualValue;
	}
	
	public void clickonOppPipelinelink(){
		explicitWait(OppPipelinelink);
		OppPipelinelink.click();
	}
	
	public void clickonCreateOptyBtn(){
		explicitWait(newBtnCreateOpty);
		newBtnCreateOpty.click();
	}
	
	public void clickonOptyDropDown(){
		explicitWait(OptyDropDown);
		OptyDropDown.click();
	}
	
	@FindBy(xpath="//input[@id='opp3']")
	WebElement opportunityNameTxt;
	
	public void enteropportunityName(String TXT){
		explicitWait(opportunityNameTxt);
		opportunityNameTxt.sendKeys(TXT);
	}
	
	@FindBy(xpath="//span[@class='dateFormat']/a")
	WebElement todaydate;
	
	public void clickTodaysDate(){
		todaydate.click();
	}
	
	@FindBy(css="select#opp11")
	WebElement stageDropDown;
	
	@FindBy(xpath="//a[@id='opp17_lkwgt']")
	WebElement PrimaryCampaignSearch;
	
	public void clickonCampaignSearch(){
		explicitWait(PrimaryCampaignSearch);
		PrimaryCampaignSearch.click();
	}

	
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@name='save']")
	WebElement bottomSaveBtnCreateOpty;
	
	public void clickonSaveBtnCreateOpty(){
		explicitWait(bottomSaveBtnCreateOpty);
		bottomSaveBtnCreateOpty.click();
	}
	
	@FindBy(css="h2.pageDescription")
	WebElement createdOptyName;
	
	public String getnewlyCreateOpty(){
		explicitWait(createdOptyName);
		String actualValue = createdOptyName.getText();
		return actualValue;
	}
	
	@FindBy(css="frame#resultsFrame")
	WebElement PrimaryCampaignresultFrame;
	
	public void switchToPrimaryCampaignresultFrame() {
		explicitWait(PrimaryCampaignresultFrame);
		switchToFrame(PrimaryCampaignresultFrame);
	}
	
	public boolean verifyPrimaryCampaignSearchChildWindow() {
		  Boolean childWindowDisplayed = false;
		  explicitWaitforChildWindow(2);
		  int windowsize = verifyChildWindowisDisplayed();
		  if(windowsize>1) {
			  childWindowDisplayed = true;
		  }
		  return childWindowDisplayed;
	  }
	
	@FindBy(xpath="//table[@class='list']/tbody/tr[2]/th/a")
	WebElement CampaignName;
	
	public void clickonCampaignName(){
		explicitWait(CampaignName);
		CampaignName.click();
	}
	
	public void selectstageDropDown() {
		  explicitWait(stageDropDown);
		  selectDropDown(stageDropDown, "Qualification" , "selectByVisibleText");
	  }
	
		public List<String> expectedOptyDropDown() {
			List<String> expectedOptyDropDownlist = new ArrayList<String>(Arrays.asList("All Opportunities", "Closing Next Month", "Closing This Month", "My Opportunities", "New Last Week","New This Week", "Opportunity Pipeline","Private","Recently Viewed Opportunities","Won"));
		     return expectedOptyDropDownlist;
		}
		
		public List<String> getActualOptyDropDownList() {
			List<String> actualList = new ArrayList<String>();
			 for (WebElement ele:OptyDropDowntList) {
				 String eachEleTxt = ele.getText();
				 actualList.add(eachEleTxt);
			 }
			 return actualList;
		}
		
		
		
	 public Boolean verifyOptyDropDownList() {
		 Boolean ListFlag = false;
		 List<String> expectedOptyDropDownlist = expectedOptyDropDown();
		 List<String> actualList = getActualOptyDropDownList();
		 if(expectedOptyDropDownlist.equals(actualList)) {
			 ListFlag = true;
		 }
		return ListFlag;
	 }
	 
	 
	}

