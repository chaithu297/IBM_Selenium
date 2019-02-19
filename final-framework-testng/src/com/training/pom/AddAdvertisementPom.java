package com.training.pom;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAdvertisementPom {
private WebDriver driver;
	
	public AddAdvertisementPom(WebDriver driver) {
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
	
	@FindBy(xpath="//td[contains(text(),'Manage advertisements')]/following-sibling::td/input")
	private WebElement advertisement;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement newAdvertisement;
	
	@FindBy(xpath="//input[@name='ad(title)']")
	private WebElement addTitle;
	
	@FindBy(xpath="//select[@name='ad(category)']")
	private WebElement category;
	
	@FindBy(xpath="//input[@name='ad(price)']")
	private WebElement addMoney;
	
	@FindBy(id="notExpirableCheck")
	private WebElement checkBox;
	
	@FindBy(xpath="//table[@class='cke_editor']/tbody/tr[2]/td/iframe[@title='Rich text editor, descriptionText']")
	private WebElement description;
	
	@FindBy(xpath="//input[@id='saveButton']")
	private WebElement saveBtn;
	
	@FindBy(id="backButton")
	private WebElement backBtn;
	
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
	
	public void clickAdvertisement() {
		this.advertisement.click();
	}
	
	public void clickNewAdvertisement() {
		this.newAdvertisement.click();
	}
	
	public void sendTitle(String title) {
		this.addTitle.clear();
		this.addTitle.sendKeys(title);
	}
	
	public void selectCategory(String category) {
		this.category.click();
		this.category.sendKeys(category);
		this.category.click();
		}
	
	public void sendPrice(String price) {
		this.addMoney.clear();
		this.addMoney.sendKeys(price);
	}
	
	public void clickCheckBox() {
		this.checkBox.click();
	}
	
	public void sendDescription(String description) {
		Actions act = new Actions(driver);
		act.moveToElement(this.description).click().build().perform();
		act.sendKeys(description).perform();
	}
	
	public void clickSaveBtn() {
		this.saveBtn.click();
	}
	
	public void clickBackBtn() {
		this.backBtn.click();
	}

}
