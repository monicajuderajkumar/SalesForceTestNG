package com.salesForce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SalesForce.Base.BasePage;

public class MyProfilePage extends BasePage{
	
   public MyProfilePage(WebDriver driver) {
	   super(driver);
   }
   
   @FindBy(xpath="//img[@alt='Edit Profile']")
	WebElement editProfile;
	
	@FindBy(xpath="//div[@id='contactInfo']//h2[@id='contactInfoTitle']")
	WebElement editProfileText;
	
	@FindBy(xpath="//iframe[@id='contactInfoContentId']")
	WebElement midframe;
	
	@FindBy(xpath="//li[@id='aboutTab']")
	WebElement aboutTab;
	
	@FindBy(xpath="//li[@id='contactTab']")
	WebElement contactTab;
	
	@FindBy(css="input#firstName")
	WebElement firstnametxtbox;
	
	@FindBy(css="input#lastName")
	WebElement lastnametxtbox;
	
	@FindBy(xpath="//input[@value='Save All']")
	WebElement saveAllBtn;
	
	@FindBy(xpath="//div[@class='chatterBreadcrumbs']//span[@id='tailBreadcrumbNode']")
	WebElement MyProfilename;
	
	@FindBy(xpath="//a[@id='publisherAttachTextPost']")
	WebElement postLink;
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement postFrame;
	
	@FindBy(xpath="//html[@dir='ltr']//body")
	WebElement postTxtBox;
	
	@FindBy(xpath="//span[@class='publisherShareButtonPlaceholder']//input[@id='publishersharebutton']")
	WebElement shareBtn;
	
	@FindBy(xpath="//a[@id='publisherAttachContentPost']")
	WebElement fileLink;
	
	@FindBy(xpath="//a[@id='chatterUploadFileAction']")
	 WebElement UploadFile;
	
	@FindBy(xpath="//input[@id='chatterFile']")
	WebElement BrowseBtn;
	
	@FindBy(xpath="//input[@id='publishersharebutton']")
	WebElement fileShareBtn;
	
	@FindBy(xpath="//div[@id='photoSection']")
	WebElement profilephotoimg;
	
	@FindBy(id="uploadLink")
	WebElement AddPhotoLink;
	
	@FindBy(id="uploadPhotoContentId")
	WebElement photoBrowseFrame;
	
	@FindBy(xpath="//input[@class='fileInput']")
	WebElement ImgBrowserButton;
	
	@FindBy(xpath="//input[@name='j_id0:uploadFileForm:uploadBtn']")
	WebElement SaveButton;
	
	@FindBy(xpath="//div[@class='imgCrop_dragArea']")
	WebElement cropImgPhoto;
	
	@FindBy(xpath="//input[@class='btn saveButton']")
	WebElement CropSaveButton;
	
	public void clickonCropSaveBtn(){
		explicitWait(CropSaveButton);
		CropSaveButton.click();
	}
	
	public void moveToWebElement(){
		explicitWait(profilephotoimg);
		moveToElement(profilephotoimg); 
	}
	public void cropProfileImg() {
		cropImg(cropImgPhoto, 173,173);
	}
	public void clickonSaveBtnAddProfileImg(){
		explicitWait(SaveButton);
		SaveButton.click();
	}
	public void pathToBrowseImg(String path){
		explicitWait(ImgBrowserButton);
		sendpathToBrowsweinWindows(ImgBrowserButton, path);
	}
	
	public void switchTophotoBrowserFrame(){
		explicitWait(photoBrowseFrame);
		switchToFrame(photoBrowseFrame);
		System.out.println(" Switched to photoBrowseFrame");
	}
	
	public void clickonAddPhotoLink(){
		explicitWait(AddPhotoLink);
		AddPhotoLink.click();
		System.out.println("AddPhotoLink is clicked");
	}
	public void clickonFileShareBtn(){
		explicitWait(fileShareBtn);
		System.out.println("Click on share button");
		fileShareBtn.click();
		System.out.println("Done");
	}
	public void pathToBrowse(String path){
		System.out.println(path);
		explicitWait(BrowseBtn);
		System.out.println("Browse btn is displayed: " + BrowseBtn.isDisplayed());
	
		sendpathToBrowsweinWindows(BrowseBtn, path);
		System.out.println("Path has been sent");
	}
	
	public void clickonUploadFileFromComputerLink(){
		explicitWait(UploadFile);
		System.out.println("clickonUploadFileFromComputerLink");
		UploadFile.click();
		System.out.println("Upload file is clicked");
	}
	
	
	public void clickonFileLink(){
		explicitWait(fileLink);
		fileLink.click();
		System.out.println("File link is clicked");
	}
	
	
	public void clickonSharepostTxt(){
		explicitWait(shareBtn);
		shareBtn.click();
	}
	public void postTxT(String txt){
		explicitWait(postTxtBox);
		postTxtBox.sendKeys(txt);
	}
	
	public void switchToPostFrame(){
		explicitWait(postFrame);
		switchToFrame(postFrame);
	}
	
	public void clickonPostLink(){
		explicitWait(postLink);
		postLink.click();
	}
	
	public String getProfileNameTxt(){
		explicitWait(MyProfilename);
		String profileNameStr = MyProfilename.getText().trim();
		return profileNameStr;
	}
	
	public void clickSaveBtnAboutsTab(){
		explicitWait(saveAllBtn);
		saveAllBtn.click();
	}
	public void editLastNameAboutTab(String newLastName){
		explicitWait(lastnametxtbox);
		lastnametxtbox.clear();
		lastnametxtbox.sendKeys(newLastName);
	}
	
	public String getFirstNameAboutTab(){
		explicitWait(firstnametxtbox);
		String firstNamestr = firstnametxtbox.getAttribute("value");
		System.out.println("FirstName" + firstNamestr);
		return firstNamestr;
	}
	
	public String getLastNameAboutTab(){
		explicitWait(lastnametxtbox);
		String lastNamestr = lastnametxtbox.getAttribute("value");
		System.out.println("LastName" + lastNamestr);
		return lastNamestr;
	}
	
	public String getEditedFullNameAboutsTab() {
		String firstNamestr = getFirstNameAboutTab();
		String lastNamestr = getLastNameAboutTab();
		String FullName = (firstNamestr +" " + lastNamestr).trim();
		System.out.println(FullName);
		return FullName;
	}
	
	public void clickOnAboutsTab(){
		explicitWait(aboutTab);
		aboutTab.click();
	}
	
	public void clickOnContactTab(){
		explicitWait(contactTab);
		contactTab.click();
	}
	public void switchToEditProfileFrame() {
		explicitWait(midframe);
		switchToFrame(midframe);
	}
	
	public Boolean verifyeditProfilepageDisplayed(){
		Boolean profileTextDisplayed = editProfileText.isDisplayed();
		return profileTextDisplayed;
	}
	
	public void clickEditProfileimg(){
		explicitWait(editProfile);
		editProfile.click();
	}
	
}
