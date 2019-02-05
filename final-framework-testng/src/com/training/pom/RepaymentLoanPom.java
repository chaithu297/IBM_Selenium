package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepaymentLoanPom {
private WebDriver driver;
	
	public RepaymentLoanPom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Account')]")
	private WebElement accounts;
	
	@FindBy(xpath="//span[contains(text(),'Loans')]")
	private WebElement loans;
	
	@FindBy(xpath="//td[contains(text(),'sample')]//following-sibling::td[3]//img[@title='View']")
	private WebElement viewIcon;
	
	@FindBy(xpath="//input[@id='amountText']")
	private WebElement repaymentAmount;
	
	@FindBy(xpath="//input[@value='Repay']")
	private WebElement repaySubmit;
	
	@FindBy(xpath="//span[contains(text(),'Account Information')]")
	private WebElement accountInformation;
	

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
	
	public void clickLoan() {
		this.loans.click();
	}
	
	public void clickViewIcon() {
		this.viewIcon.click();
	}
	
	public void sendAmount(String amount) {
		this.repaymentAmount.clear();
		this.repaymentAmount.sendKeys(amount);
	}
	
	public void clickSubmit() {
		this.repaySubmit.click();
	}
	
	public void clickAccountInformation() {
		Actions act = new Actions(driver);
		act.moveToElement(accountInformation).click().build().perform();
//		this.accountInformation.click();
	}

}
