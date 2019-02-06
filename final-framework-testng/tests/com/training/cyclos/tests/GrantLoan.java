package com.training.cyclos.tests;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.GrantLoanPom;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class GrantLoan {
	
	private WebDriver driver;
	private GrantLoanPom grantLoanPom;
	private ScreenShot screenShot;
	private Properties properties;
	String baseUrl;
	boolean expected;
	
  @Test
  public void grantloan() throws Exception {
	  grantLoanPom.sendUserName("admin");
	  grantLoanPom.sendPassword("12345");
	  grantLoanPom.clickLoginBtn();
	  grantLoanPom.sendMemberName("manzoor");
	  grantLoanPom.grantloan();
	  Thread.sleep(3000);
      grantLoanPom.sendAmount("100");
	  grantLoanPom.description("Testing Loan1");
	  screenShot.captureScreenShot("grant loan");
	  grantLoanPom.clickSubmit();
	  grantLoanPom.label();
	  grantLoanPom.clickSubmitBtn();
	  Alert alt = driver.switchTo().alert();
	  System.out.println(alt.getText());
	  alt.accept();
	  grantLoanPom.clickLoan();
	  grantLoanPom.viewLoan();
	  screenShot.captureScreenShot("View loan");
	  grantLoanPom.clickLogout();
	  System.out.println(alt.getText());
	  alt.accept();
//	  Login with manzoor
	  grantLoanPom.sendUserName("manzoor");
	  grantLoanPom.sendPassword("manzoor");
	  grantLoanPom.clickLoginBtn();
	  grantLoanPom.clickAccountLnk();
	  grantLoanPom.clickLoanLnk();
	  String expected = driver.findElement(By.xpath("//td[contains(text(),'Search results')]")).getText();
	  assertEquals("Search results", expected);
  }
  @BeforeMethod
  public void beforeMethod() {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		grantLoanPom = new GrantLoanPom(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);

  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.quit();
  }

  @BeforeClass
  public void beforeClass() throws IOException {
	  properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
  }

}
