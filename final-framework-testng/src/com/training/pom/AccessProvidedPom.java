package com.training.pom;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccessProvidedPom {
private WebDriver driver;
	
	public AccessProvidedPom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")
	private WebElement loginBtn; 
	
	@FindBy(id="memberUsername")
	private WebElement memberLogin;
	
	@FindBy(xpath="//td[contains(text(),'Change permission group')]/following-sibling::td/input")
	private WebElement changePermission;
	
	@FindBy(xpath="//select[@name='newGroupId']")
	private WebElement newGroup;
	
	@FindBy(xpath="//textarea[@id='comments']")
	private WebElement comments;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submit;
	
	@FindBy(xpath="//span[contains(text(),'Home')]")
	private WebElement home;
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void sendMemberName(String memberName)  throws AWTException, InterruptedException {
		this.memberLogin.clear();
		this.memberLogin.sendKeys(memberName);
	}
	
	public void changePermission() {
		this.changePermission.click();
	}
	
	public void selectGroup(String group) {
		this.newGroup.click();
		this.newGroup.sendKeys(group);
		this.newGroup.click();
		
	}
	
	public void provideComments(String comments) {
		this.comments.clear();
		this.comments.sendKeys(comments);
	}
	
	public void clickSubmit() {
		this.submit.click();
	}
	
	public void clickHome() {
		this.home.click();
	}

}
