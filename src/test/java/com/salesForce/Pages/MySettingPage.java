package com.salesForce.Pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.SalesForce.Base.BasePage;

public class MySettingPage extends BasePage{

	String projDir = System.getProperty("user.dir");
	String pathToDownload = projDir +"\\Downloads";
	
	  public MySettingPage(WebDriver driver) {
		  super(driver);
	  }
	  
	  @FindBy(css="a[title='My Settings']")
	  WebElement MySettingsLink;
	  
	  @FindBy(css="span#PersonalInfo_font")
	  WebElement personalLink;
	  
	  @FindBy(css="span#LoginHistory_font")
	  WebElement loginHistory;
	  
	  @FindBy(css="div.pShowMore a")
	  WebElement downloadHistory;
	  
	  @FindBy(css="span#DisplayAndLayout_font")
	  WebElement DisplayLayoutLink;
	  
	  @FindBy(css="span#CustomizeTabs_font")
	  WebElement customizeMyTabLink;
	  
	  @FindBy(css="select#p4")
	  WebElement customAppDropDown;
	  
	  @FindBy(css="select#duel_select_0")
	  WebElement AvailableTabs;
	  
	  @FindBy(css="img.rightArrowIcon")
	  WebElement AddButton;
	  
	  @FindBy(css="select#duel_select_1")
	  WebElement SelectedTabs;
	  
	  @FindBy(xpath="//input[@title='Save']")
	  WebElement saveBtn;
	  
	  // Email
	  @FindBy(css="span#EmailSetup_font")
	  WebElement emailLink;
	  
	  @FindBy(css="span#EmailSettings_font")
	  WebElement emailSettingLink;
	  
	  @FindBy(css="input#sender_name")
	  WebElement emailName;
	  
	  @FindBy(xpath="//div[@class='requiredInput']//input[following-sibling::label[text()='Yes']]")
	  WebElement automaticBCCRadioYes;
	  
	  @FindBy(xpath="//input[@name='save']")
	  WebElement SaveBtnEmailSetting;
	  
	  @FindBy(css="div.messageText")
	  WebElement successMsgEleEmailSetting;
	  
	  //Calendar
	  @FindBy(css="span#CalendarAndReminders_font")
	  WebElement CalendarReminderLink;
	  
	  @FindBy(css="span#Reminders_font")
	  WebElement ActivityReminderLink;
	  
	  @FindBy(css="input#testbtn")
	  WebElement openTestReminderBtn;
	  
	  public boolean verifyReminderPageisDisplayed() {
		  Boolean childWindowDisplayed = false;
		  explicitWaitforChildWindow(2);
		  int windowsize = verifyChildWindowisDisplayed();
		  if(windowsize>1) {
			  childWindowDisplayed = true;
		  }
		  return childWindowDisplayed;
	  }
	  public void clickonOpenTestReminderBtn(){
		  explicitWait(openTestReminderBtn);
		  openTestReminderBtn.click();
	  }
	  public void clickonActivityReminder(){
		  explicitWait(ActivityReminderLink);
		  ActivityReminderLink.click();
	  }
	  
	  public void clickonCalendarAndReminder(){
		  explicitWait(CalendarReminderLink);
		  CalendarReminderLink.click();
	  }
	  public void clickonEmailSettingSaveBtn(){
		  explicitWait(SaveBtnEmailSetting);
		  SaveBtnEmailSetting.click();
	  }
	  
	  public Boolean verifyEmailSettingInput(){
		  explicitWait(successMsgEleEmailSetting);
		  boolean verifyEmailSettingFlag = false;
		  boolean successMsgFlag = false;
		  boolean editedeUserNameFlag = false;
		  boolean radioButtonYes = false;
		  String expectedsuccessMsg = "Your settings have been successfully saved.";
		  String successMsg = successMsgEleEmailSetting.getText();
		  if(successMsg.equals(expectedsuccessMsg)) {
			  successMsgFlag = true;
		  }
		  String actualemailUserName = emailName.getAttribute("value");
		  if (actualemailUserName.equals("Monica Jude Rajkumar")) {
			  editedeUserNameFlag = true;
		  }
		  if(automaticBCCRadioYes.getAttribute("checked").equalsIgnoreCase("true")) {
			  radioButtonYes = true;
		  }
		  
		 if (successMsgFlag == true && editedeUserNameFlag == true && radioButtonYes == true) {
			 verifyEmailSettingFlag = true;
		 }
		 
		 return verifyEmailSettingFlag;
	  }
	  
	  public void clickonRadioButton(){
			explicitWait(automaticBCCRadioYes);
			
			if (automaticBCCRadioYes.getAttribute("checked")== null) {
				System.out.println("Yes Radio button is not selected ");
				automaticBCCRadioYes.click();
				System.out.println("Yes Radio button  selected ");
			}
		}
	  public void editemailName(String newEmailName){
			explicitWait(emailName);
			emailName.clear();
			emailName.sendKeys(newEmailName);
		}
	  
	  public void clickonemailSettingLink(){
			explicitWait(emailSettingLink);
			emailSettingLink.click();
		}
	  
	  public void clickonemailLink(){
			explicitWait(emailLink);
			emailLink.click();
		}
	  
	  public void clickonSaveBtnCustMyTab(){
			explicitWait(saveBtn);
			saveBtn.click();
		}
	  
	  public boolean verifyeleinSelectedTab(){
			explicitWait(SelectedTabs);
			Boolean isSelectedOption = false;
			Select sel2 = new Select(SelectedTabs);
			   List<WebElement> selectedlist = sel2.getOptions();
			   for(WebElement ele : selectedlist) {
				   System.out.println(ele.getText());
				   if(ele.getText().equalsIgnoreCase("Reports")) {
					   System.out.println(ele.getText() + "got added.");
					   isSelectedOption = true;
				   }
			   }
			   return isSelectedOption;
		}
	  
	  public void clickonAddButtonCustMyTab(){
			explicitWait(AddButton);
			AddButton.click();
		}
	  
	  public void selectCustomAppDropDown() {
		  explicitWait(customAppDropDown);
		  selectDropDown(customAppDropDown, "Salesforce Chatter" , "selectByVisibleText");
	  }
	  
	  public void selectValuesinAvailableTabs() {
		  explicitWait(AvailableTabs);
		  selectDropDown(AvailableTabs, "report" , "selectByValue");
	  }
	  
	  public void clickonCustomizeMyTabLink(){
			explicitWait(customizeMyTabLink);
			customizeMyTabLink.click();
		}
	  
	  public void clickonDisplayAndLayoutLink(){
			explicitWait(DisplayLayoutLink);
			DisplayLayoutLink.click();
		}
	  public void clickonMySettingLink(){
			explicitWait(MySettingsLink);
			MySettingsLink.click();
		}
	  
	  public void clickonpersonalLink(){
			explicitWait(personalLink);
			personalLink.click();
		}
	  
	  public void clickonLoginHistoryLink(){
			explicitWait(loginHistory);
			loginHistory.click();
		}
	  
	  public void clickonDownLoadFileLink(){
			explicitWait(downloadHistory);
			removeAllFilesDownload();
			downloadHistory.click();
			
		}
	  
	  public void removeAllFilesDownload() {
		  File folder = new File(pathToDownload);
		  if(folder.isDirectory()) {
				 File[] listofFiles = folder.listFiles();
				 System.out.println("No.of files in folder: " + listofFiles.length);
				 if (listofFiles.length == 0) {
					 System.out.println("No files exist");
				 }else {
					 System.out.println("File is present");
					 for (File f : listofFiles) {
						 System.out.println("Deleting file : " + f.getName().toString());
						 f.delete();
					 }
				 }
			 }
	  }
	  public Boolean verifyDownloadedFile() {
		  //fluentWait();
		  boolean downloadFlag = false;
		 File folder = new File(pathToDownload);
		 System.out.println(pathToDownload);
		 System.out.println("Path is a directory" + folder.isDirectory());
		 
		 if(folder.isDirectory()) {
			 
			 File[] listofFiles = folder.listFiles();
			 System.out.println("No.of files in folder: " + listofFiles.length);
			 if (listofFiles.length > 0) {
				 downloadFlag = true;
			 }
		 }
		 return downloadFlag;
	  }
}
