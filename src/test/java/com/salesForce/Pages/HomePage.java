package com.salesForce.Pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SalesForce.Base.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy(xpath="//li[@id='home_Tab']")
	WebElement homeTab;
	
	@FindBy(css="span#userNavLabel")
	WebElement userMenu;
	
	@FindBy(css="a[title='Logout']")
	WebElement logoutlink;
	
	@FindBy(css="div#userNav-menuItems a")
	List<WebElement> actualuserMenuElementList;
	
	@FindBy(css="a[title='My Profile']")
	WebElement MyProfileLink;
	
	
	
	public Boolean verifyProfileLink(){
		Boolean MyProfileLinkDisplayed = MyProfileLink.isDisplayed();
		return MyProfileLinkDisplayed;
	}
	
	public void clickMyProfileLink(){
		explicitWait(MyProfileLink);
		MyProfileLink.click();
	}
	
	public List<String> getExpectedUserMenu() {
		List<String> expecteduserMenuList = new ArrayList<String>(Arrays.asList("My Profile", "My Settings", "Developer Console", "Switch to Lightning Experience", "Logout"));
	     return expecteduserMenuList;
	}
	
	public List<String> getActualUserMenu() {
		List<String> actualuserMenuList = new ArrayList<String>();
		 for (WebElement ele:actualuserMenuElementList) {
			 String menuList = ele.getText();
			 actualuserMenuList.add(menuList);
		 }
		 return actualuserMenuList;
	}
	
 public Boolean verifyUserMenu() {
	 Boolean menuListFlag = false;
	 List<String> expecteduserMenuList = getExpectedUserMenu();
	 List<String> actualuserMenuList = getActualUserMenu();
	 if(expecteduserMenuList.equals(actualuserMenuList)) {
		 menuListFlag = true;
	 }
	return menuListFlag;
 }
	
	public Boolean HomeTabDisplayed() {
		explicitWait(homeTab);
		System.out.println(homeTab.isDisplayed());
		 Boolean homeTabDisplayed = homeTab.isDisplayed();
		 return homeTabDisplayed;
	}
	
	public void clickUserMenu() {
		explicitWait(userMenu);
		userMenu.click();
	}
	
	public void clickLogout() {
		explicitWait(logoutlink);
		logoutlink.click();
	}
	
	
}
