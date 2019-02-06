package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MessagePom {
private WebDriver driver;
	
	public MessagePom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Messages')]")
	private WebElement messages;
	
	@FindBy(xpath="//span[@class='subMenuText'][contains(text(),'Messages')]")
	private WebElement messagesLink;
	
	@FindBy(xpath="//input[@id='newButton']")
	private WebElement newMessage;
	
	@FindBy(id="memberUsername")
	private WebElement memberName;
	
	@FindBy(id="subjectText")
	private WebElement subjectType;
	
	//table[@class='cke_editor']/tbody/tr[2]/td/iframe
	
	@FindBy(xpath="//table[@class='cke_editor']//tr//iframe")
	private WebElement bodyText;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//span[contains(text(),'Personal')]")
	private WebElement personalLink;
	
	@FindBy(xpath="//span[contains(text(),'Messages')]")
	private WebElement messagesLnk;
	
	@FindBy(xpath="//tr[contains(@class,'unread')]//child::td[3]//a[contains(text(),'Loan Test')]")
	private WebElement viewMessage;
	
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
	
	public void clickMessages() {
		this.messages.click();
	}
	
	public void clickMessageLink() {
		this.messagesLink.click();
	}
	
	public void clickNewMessage() {
		this.newMessage.click();
	}
	
	public void sendMemberName(String memberName) {
		this.memberName.clear();
		this.memberName.sendKeys(memberName);
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='membersByUsername']/ul/child::li"));
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getText().contains("manzoor mehadi (manzoor)")) {
				list.get(i).click();
			}
		}
	}
	
	public void selectCategory() {
	 Select category= new Select(driver.findElement(By.xpath("//select[@id='categorySelect']")));
	 category.selectByVisibleText("Loan request");
		
	}
	
	public void sendSubject(String subjectType) {
		this.subjectType.clear();
		this.subjectType.sendKeys(subjectType);
	}
	
	public void sendBodyText(String welcome) throws InterruptedException {
//		driver.switchTo().frame(this.bodyText);
//		Thread.sleep(30000);
//		this.bodyText.clear();
//		
//		
		Actions act = new Actions(driver);
		act.moveToElement(this.bodyText).click().sendKeys(welcome).build().perform();
//		String ele = driver.findElement(By.xpath("//*[@class='cke_show_borders']/p")).getAttribute("value");
//		System.out.println(ele);
//		ele.sendKeys(welcome);
		
//		this.bodyText.sendKeys(welcome);
	}
	
	public void clickSubmit() {
		this.submitBtn.click();
	}
	
	public void clickLogOut() {
		this.logoutBtn.click();
	}
	
	public void clickPersonal() {
		this.personalLink.click();
	}
	
	public void clickMessageslnk() {
		this.messagesLnk.click();
	}
	
	public void clickViewMessages() {
		this.viewMessage.click();
	}
	
	
}
