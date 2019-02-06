package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GrantLoanPom {
	
	private WebDriver driver;
	
	public GrantLoanPom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	JavascriptExecutor je=(JavascriptExecutor) driver;
	Robot robot;
	Actions act;
	
	
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
	
	@FindBy(name="loan(amount)")
	private WebElement amount;
	
	@FindBy(xpath="//tbody//textarea[@id='description']")
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
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement logout;
	
	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Account')]")
	private WebElement accountLnk;
	
	@FindBy(xpath="//span[contains(text(),'Loans')]")
	private WebElement loansLnk;
	
	@FindBy(xpath="//td[contains(text(),'sample')]")
	private WebElement viewLoanLnk;
	
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
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'manzoor mehadi (manzoor)')]")).click();
		
	}
	
	public void grantloan() throws AWTException{
		System.out.println("grant loan is clicked");
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		this.grantLoan.click();
	}
	
	public void sendAmount(String amount1) throws AWTException{
		act = new Actions(driver);
		act.moveToElement(this.amount).click().perform();
		act.moveToElement(this.amount).sendKeys(amount1).perform();
	}
	
	public void description(String description) throws AWTException, InterruptedException {
		act = new Actions(driver);
		act.moveToElement(this.description).click();
		act.moveToElement(this.description).sendKeys(description).perform();
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
	
	public void clickLogout() {
		this.logout.click();
	}
	
	public void clickLoan() {
		this.loansubmit.click();
	}

	public void clickAccountLnk() {
		this.accountLnk.click();
	}
	
	public void clickLoanLnk() {
		this.loansLnk.click();
	}
}
