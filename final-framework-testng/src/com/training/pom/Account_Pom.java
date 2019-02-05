package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account_Pom {
	private WebDriver driver;

	public Account_Pom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "cyclosUsername")
	private WebElement userName;

	@FindBy(id = "cyclosPassword")
	private WebElement password;

	@FindBy(xpath = "//td[@colspan='2']//input[@value='Submit']")
	private WebElement loginBtn;

	@FindBy(xpath = "//li[@id='menu3']")
	private WebElement accounts;

	@FindBy(xpath = "//span[contains(text(),'Member Payment')]")
	private WebElement memberPayments;

	@FindBy(xpath = "//input[@id='memberUsername']")
	private WebElement memberUserName;

	@FindBy(id = "memberName")
	private WebElement memberName;

	@FindBy(id = "amount")
	private WebElement amount;

	@FindBy(id = "description")
	private WebElement description;

	@FindBy(id = "submitButton")
	private WebElement submitButton;

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submit;
	
	@FindBy(id="backToMemberProfileButton")
	private WebElement memberProfileButton;
	
	@FindBy(xpath="//tbody//tr[5]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement informationBtn;
	
	@FindBy(xpath="//td[@class='label']")
	private WebElement contentConfirmation;
	
	@FindBy(xpath="//td[@align='center']")
	private WebElement contentSuccessScreen;
	
	public void clickInfoBtn() {
		this.informationBtn.click();
	}
	
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

	public void clickAccount() {
		this.accounts.click();
	}

	public void clickMemberPayments() {
		this.memberPayments.click();
	}

	public void sendMemberUserName(String memberUserName) throws InterruptedException {
		this.memberUserName.clear();
		this.memberUserName.sendKeys(memberUserName);
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='membersByUsername']/ul/child::li"));
		System.out.println(list.size());
		for (int i = 0; i <= list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("selenium")) {
				list.get(i).click();
				break;
			}
		}

	}

	public void sendMemberName(String memberName) {
		this.memberName.clear();
		this.memberName.sendKeys(memberName);
	}

	public void sendAmount(String amount) {
		this.amount.clear();
		this.amount.sendKeys(amount);
	}

	public void senddescription(String description) {
		this.description.clear();
		this.description.sendKeys(description);
	}

	public void clickSubmit() {
		this.submitButton.click();
	}
	
	public void clickSubmitButton() {
		this.submit.click();
	}
	
	public void clickMemberButton() {
		this.memberProfileButton.click();
	}
	

	public boolean contentConfirmation() {
		this.contentConfirmation.getText();
		return contentConfirmation.isDisplayed();
	}
	
	public boolean contentSuccessScreen() {
		this.contentSuccessScreen.getText();
		return contentSuccessScreen.isDisplayed();
	}

}
