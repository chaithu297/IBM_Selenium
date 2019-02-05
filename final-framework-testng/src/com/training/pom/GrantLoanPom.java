package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GrantLoanPom {
	
	private WebDriver driver;
	
	public GrantLoanPom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	JavascriptExecutor je=(JavascriptExecutor) driver;
	
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")
	private WebElement loginBtn; 
	
	@FindBy(id="memberUsername")
	private WebElement memberLogin;
	
	@FindBy(xpath="//legend[contains(text(),'Loans')]/parent::*/table/tbody/tr/td[4]/input")
	private WebElement grantLoan;
	
	@FindBy(id="//input[@id='amount']")
	private WebElement amount;
	
	@FindBy(xpath="//textarea[@id='description']")
	private WebElement description;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submitbtn;
	
	@FindBy(xpath="//td[@class='label']")
	private WebElement label;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submit;
	
	@FindBy(xpath="//input[@linkurl='searchLoans?memberId=3']")
	private WebElement loansubmit;
	
	@FindBy(xpath="//td[contains(text(),'Home loan')]")
	private WebElement viewloan;
	
	
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
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(text(),'manzoor mehadi (manzoor)')]")).click();
		
	}
	
	public void grantloan() throws AWTException{
		System.out.println("grant loan is clicked");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		this.grantLoan.click();
	}
	
	public void sendAmount(String amount) {
		this.amount.clear();
		this.amount.sendKeys(amount);
	}
	
	public void description(String description) {
		this.description.clear();
		this.description.sendKeys(description);
	}
	
	public void clickSubmitBtn(){
	
		this.submitbtn.click();
	}
	
	public void label() {
		System.out.println(this.label.getText());
	}
	
	public boolean labeldisplay() {
		return label.isDisplayed();
	}
	
	public void clickSubmit() {
		
		this.submit.click();
	}
	
	public void viewLoan() {
		this.viewloan.getText();
	}
	
	public void clickLoan() {
		this.loansubmit.click();
	}

}
