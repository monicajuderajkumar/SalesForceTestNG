package com.salesForce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.SalesForce.Base.BasePage;

public class CreateAccountPage extends BasePage{
	
	
   public CreateAccountPage(WebDriver driver) {
	   super(driver);
   }
   
	   @FindBy(css="input[title='New']")
		WebElement CreateNewAccButton;
	   
	   @FindBy(css="input#acc2")
		WebElement NewAccName;
	   
	   @FindBy(css="select#acc6")
		WebElement AccountTypeDropDown;
	   
	   @FindBy(xpath="//select[@id='00Nbm000006TKqR']")
		WebElement customerPriorityDropDown;
	   
	   @FindBy(xpath="//td[@id='topButtonRow'] //input[@title='Save']")
		WebElement saveButton;
	   
	   @FindBy(css="h2.pageDescription")
		WebElement newlycreatedAccName;
	   
	   @FindBy(css="div#acc6_ileinner")
		WebElement newlycreatedAccType;
	   
	   @FindBy(xpath="//div[@id='00Nbm000006TKqR_ileinner']")
		WebElement newlycreatedcustomerPriority;
	   
	   @FindBy(linkText="Create New View")
		WebElement createNewViewLink;
	   
	   @FindBy(css="input#fname")
		WebElement viewNameTXT;
	   
	   @FindBy(css="input#devname")
		WebElement viewUniqueNameTXT;
	   
	   @FindBy(css="input[type='submit']")
		WebElement saveBtnCreateNewView;
	   
	   @FindBy(css="select[name='fcf']")
		WebElement viewAccDropdown;
	   
	   @FindBy(xpath="//span[@class='fFooter']//a[text()='Edit']")
		WebElement EditViewLink;
	   
	   @FindBy(css="select#fcol1")
		WebElement fieldDropDown;
	   
	   @FindBy(xpath="//select[@title='Operator 1']")
		WebElement operatorDropDown;
	   
	   @FindBy(css="input#fval1")
		WebElement AccNameValue;
	   
	   @FindBy(css="select#colselector_select_0")
		WebElement AvailablefieldDropDown;
	   
	   @FindBy(xpath="//img[@alt='Add']")
		WebElement addBtn;
	   
	   @FindBy(xpath="//div[@class='pbBottomButtons']//input[@class='btn primary']")
		WebElement saveBtn;
	   
	   @FindBy(xpath="//div[@id='001bm00000aUF1i_Name']")
		WebElement lastActAccName;
	   
	 //Merge link
	 		 @FindBy(xpath="//a[text()='Merge Accounts']")
	 		WebElement mergeAcclink;
	 		
	 		 @FindBy(xpath="//a[text()='Accounts with last activity > 30 days']")
		 		WebElement AccLastActivitylink;
	 		
	 		public void clickonAccLastActivitylink(){
				explicitWait(AccLastActivitylink);
				AccLastActivitylink.click();
			}
	 		
	 		public void clickonmergeAccLink(){
				explicitWait(mergeAcclink);
				mergeAcclink.click();
			}
	 	   
	   public String getlastActAccNameEdit(){
			explicitWait(lastActAccName);
			String lastActivityAccountName = lastActAccName.getText().trim();
			
			if(lastActivityAccountName.equals("")) {
				lastActivityAccountName = lastActAccName.getAttribute("value").trim();
			}
			System.out.println(lastActivityAccountName);
			return lastActivityAccountName;
		}
	   public void clickonAddBtn(){
			explicitWait(addBtn);
			addBtn.click();
		}
	   
	   public void clickonSaveBtnEdit(){
			explicitWait(saveBtn);
			saveBtn.click();
		}
	   
	   public void selectavailablefieldDropDown() {
			  explicitWait(AvailablefieldDropDown);
			  selectDropDown(AvailablefieldDropDown, "Last Activity" , "selectByVisibleText");
		  }
	   
	   public void enterAccNameValue(String txt){
			explicitWait(AccNameValue);
			AccNameValue.sendKeys(txt);
		}
	   public void selectoperatorDropDown() {
			  explicitWait(operatorDropDown);
			  selectDropDown(operatorDropDown, "contains" , "selectByVisibleText");
		  }
	   public void selectfieldDropDown() {
			  explicitWait(fieldDropDown);
			  selectDropDown(fieldDropDown, "Account Name" , "selectByVisibleText");
		  }
	   public void editviewName(String txt){
			explicitWait(viewNameTXT);
			viewNameTXT.clear();
			viewNameTXT.sendKeys(txt);
		}
	   
	   public void clickonEditViewLink(){
			explicitWait(EditViewLink);
			EditViewLink.click();
		}
	   
	   public void selectviewAccDropDropDown() {
			  explicitWait(viewAccDropdown);
			  selectDropDown(viewAccDropdown, "Roselenaa" , "selectByVisibleText");
		  }
	   
	   public String verifySelOptioniviewAccDropDown() {
			
			 String selectedoptionDropDown = verifySelOptioninDropDown(viewAccDropdown);
			 System.out.println("Selected Value: "+ selectedoptionDropDown );
			return selectedoptionDropDown;
		 }
	   
	   public void clickonSaveBtnCreateNewView(){
			explicitWait(saveBtnCreateNewView);
			saveBtnCreateNewView.click();
		}
	   
	   public void enterviewUniqueName(String txt){
			explicitWait(viewUniqueNameTXT);
			viewUniqueNameTXT.sendKeys(txt);
		}
	   
	   public void enterviewName(String txt){
			explicitWait(viewNameTXT);
			viewNameTXT.sendKeys(txt);
		}
	   public void clickonCreateNewView(){
			explicitWait(createNewViewLink);
			createNewViewLink.click();
		}
	   public void clickonSaveBtnCreateAct(){
			explicitWait(saveButton);
			saveButton.click();
		}
	   
	   public void clickonCreateNewAccBtn(){
			explicitWait(CreateNewAccButton);
			CreateNewAccButton.click();
		}
	   
	   public void newAccName(String txt){
			explicitWait(NewAccName);
			NewAccName.sendKeys(txt);
		}
	   
	   public void selectAccTypeDropDown() {
			  explicitWait(AccountTypeDropDown);
			  selectDropDown(AccountTypeDropDown, "Technology Partner" , "selectByValue");
		  }
	   
	   public void selectcustomerPriorityDropDown() {
			  explicitWait(customerPriorityDropDown);
			  selectDropDown(customerPriorityDropDown, "High" , "selectByValue");
		  }
	   
	   public String getnewAccName(){
			explicitWait(newlycreatedAccName);
			String newAccountName = newlycreatedAccName.getText().trim();
			if(newAccountName.equals("")) {
				newAccountName = newlycreatedAccName.getAttribute("value").trim();
			}
			return newAccountName;
		}
	   
	   public String getnewCreatedAccType(){
			explicitWait(newlycreatedAccType);
			String newAccType = newlycreatedAccType.getText().trim();
			if(newAccType.equals("")) {
				newAccType = newlycreatedAccType.getAttribute("value").trim();
			}
			return newAccType;
		}
	   
	   public String getnewCreatedCustomerPriority(){
			explicitWait(newlycreatedcustomerPriority);
			String newCustomerPriority = newlycreatedcustomerPriority.getText().trim();
			if(newCustomerPriority.equals("")) {
				newCustomerPriority = newlycreatedcustomerPriority.getAttribute("value").trim();
			}
			return newCustomerPriority;
		}
}
