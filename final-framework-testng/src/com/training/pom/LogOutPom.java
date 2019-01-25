package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPom {
	private WebDriver driver;
	
	public LogOutPom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="cyclosUsername")
	 private WebElement userName;
	 
	 @FindBy(id="cyclosPassword")
	 private WebElement userPassword;
	 
	 @FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")
	 private WebElement submit;
	 
	 @FindBy(xpath="//span[contains(text(),'Home')]")
	 private WebElement home;
	 
	 @FindBy(xpath="//span[contains(text(),'Logout')]")
	 private WebElement logout;
	 
	 @FindBy(xpath="//td[@class='loginFormContainer']")
	 private WebElement loginForm;
	 
	 public void sendUserName(String userName) {
		 this.userName.clear();
		 this.userName.sendKeys(userName);
	 }
	 
	 public void sendPassword(String userPassword) {
		 this.userPassword.clear();
		 this.userPassword.sendKeys(userPassword);
	 }
	 
	 public void clickSubmit() {
		 this.submit.click();
	 }
	 
	 public boolean homeDisplayed() {
		 return home.isDisplayed();
	 }
	 
	 public void clickLogout() {
		 this.logout.click();
	 }
	 
	 public boolean loginFormDisplayed() {
		 return loginForm.isDisplayed();
	 }
}

