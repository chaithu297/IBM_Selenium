package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPom {
 private WebDriver driver;
 
 public ChangePasswordPom(WebDriver driver) {
	 this.driver= driver;
	 PageFactory.initElements(driver, this);
	 
 }
 @FindBy(id="cyclosUsername")
 private WebElement userName;
 
 @FindBy(id="cyclosPassword")
 private WebElement userPassword;
 
 @FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")
 private WebElement submit;
 
 @FindBy(xpath="//span[contains(text(),'Personal')]")
 private WebElement personalLink;
 
 @FindBy(xpath="//span[contains(text(),'Profile')]")
 private WebElement profile;
 
 @FindBy(xpath="//span[contains(text(),'Messages')]")
 private WebElement messages;
 
 @FindBy(xpath="//span[contains(text(),'Contacts')]")
 private WebElement contacts;
 
 @FindBy(xpath="//span[contains(text(),'Change password')]")
 private WebElement changePassword;
 
 @FindBy(xpath="//input[@name='oldPassword']")
 private WebElement oldPassword;
 
 @FindBy(xpath="//input[@name='newPassword']")
 private WebElement newPassword;
 
 @FindBy(xpath="//input[@name='newPasswordConfirmation']")
 private WebElement confirmNewPassword;
 
 @FindBy(xpath="//input[@value='Submit']")
 private WebElement changeSubmit;
 
 @FindBy(xpath="//tr//td[@class='tdContentTableForms innerBorder']//table[@class='defaultTable']")
 private WebElement homePage;
 
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
 
 public void clickPersonalLink() {
	 this.personalLink.click();
 }
 
 public boolean profileText() {
	return profile.isDisplayed(); 
 }
 
 public boolean messageText() {
	 return messages.isDisplayed();
 }
 
 public boolean contactsText() {
	return contacts.isDisplayed();
 }
 
 public boolean isChangePasswordDisplayed() {
	 return changePassword.isDisplayed();	 
 }
 
 public void clickChangePassword() {
	 this.changePassword.click();
 }
 
 public void sendOldPassword(String oldPassword) {
	 this.oldPassword.clear();
	 this.oldPassword.sendKeys(oldPassword);
 }
 public void sendNewPassword(String newPassword) {
	 this.newPassword.clear();
	 this.newPassword.sendKeys(newPassword);
 }
 
 public void sendConfirmPassword(String confirmPassword) {
	 this.confirmNewPassword.clear();
	 this.confirmNewPassword.sendKeys(confirmPassword);
 }
 
 public void changeSubmit() {
	 this.changeSubmit.click();
 }
 
 public boolean homePageDisplayed() {
	 return homePage.isDisplayed();
 }
}
