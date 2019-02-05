package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvertisementPom {
	private WebDriver driver;
	
	public AdvertisementPom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//span[contains(text(),'Advertisements')]")
	private WebElement advertisement;
	
	
	@FindBy(id="memberUsername")
	private WebElement memberLogin;
	
	@FindBy(xpath="//input[@linkurl='memberAds?memberId=3']")
	private WebElement submitbtn;
	

	@FindBy(xpath="//a[contains(text(),'try')]/parent::*/parent::*/following-sibling::td[4]//img[@class='remove removeAd']")
	private WebElement removeAdd;
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement logout;
	
	@FindBy(xpath="//span[contains(text(),'Personal')]")
	private WebElement personal;
	

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
	
	
	public void sendMemberUserName(String memberUserName) throws InterruptedException {
		this.memberLogin.clear();
		this.memberLogin.sendKeys(memberUserName);
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='membersByUsername']/ul/child::li"));
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("manzoor mehadi (manzoor)")) {
				list.get(i).click();
				break;
			}
		}

	}
	
	public void clickAdvertisment() {
		this.advertisement.click();
	}
	
	public void clickSubmitBtn() {
		this.submitbtn.click();
	}
	
	public void clickRemoveAdd() {
		this.removeAdd.click();
	}
	public void clickLogout() {
		this.logout.click();
	}
	public void clickPersonel() {
		this.personal.click();
	}


}
