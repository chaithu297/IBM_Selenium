package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileEditPom {
	private WebDriver driver;
	
	public ProfileEditPom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	 private WebElement userName;
	 
	 @FindBy(id="cyclosPassword")
	 private WebElement userPassword;
	 
	 @FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")
	 private WebElement submit;
	 
     @FindBy(xpath="//span[contains(text(),'Personal')]")
     private WebElement personalLnk;
     
     @FindBy(xpath="//span[contains(text(),'Profile')]")
     private WebElement profileLnk;
     
     @FindBy(xpath="//span[contains(text(),'Change Password')]")
     private WebElement changePasswordLnk;
     
     @FindBy(xpath="//span[contains(text(),'E-Mail Notifications')]")
     private WebElement emailNotificationLnk;
     
     @FindBy(xpath="//td[@class='tdHeaderTable']")
     private WebElement adminProfilePage;
     
     @FindBy(id="modifyButton")
     private WebElement changeBtn;
     
     @FindBy(xpath="//input[@value='Administrator']")
     private WebElement editName;
     
     @FindBy(id="saveButton")
     private WebElement submitBtn;
     
     @FindBy(xpath="//input[@value='Administrator']")
     private WebElement adminDisplayed;
     
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
     
     public void clickPersonalLnk() {
    	 this.personalLnk.click();
     }
     
     public boolean profileLnkDisplayed() {
    	 return profileLnk.isDisplayed();
     }
     
     public boolean changePasswordDisplayed() {
    	 return changePasswordLnk.isDisplayed();
     }
     
     public boolean emailNotificationDisplayed() {
    	 return emailNotificationLnk.isDisplayed();
     }
     
     public void clickProfileLnk() {
    	 this.profileLnk.click();
     }
     
     public boolean adminProfileDisplayed() {
    	 return adminProfilePage.isDisplayed();
     }
     
     public void clickChangeBtn() {
      this.changeBtn.click();	 
     }
     
     public void editName(String editName) {
    	 this.editName.clear();
    	 this.editName.sendKeys(editName);
     }
     
     public void clickSaveBtn() {
    	 this.submitBtn.click();
     }
     
     public boolean changeDisplayed() {
    	 return adminDisplayed.isDisplayed();
     }
     
}
