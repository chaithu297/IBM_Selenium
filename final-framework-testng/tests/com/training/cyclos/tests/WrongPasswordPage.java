package com.training.cyclos.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.WrongPasswordpagePom;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class WrongPasswordPage {
	WebDriver driver;
	WrongPasswordpagePom wrongPasswordPagePom;
	String baseUrl;
	Properties properties;
	ScreenShot screenShot;
  @Test
  public void wrongPassword() {
	  wrongPasswordPagePom.sendUserName("chaitanya");
	  wrongPasswordPagePom.sendPassword("mehadi");
	 wrongPasswordPagePom.clickSubmit();
	  wrongPasswordPagePom.clickPersonalLink();
	  Assert.assertEquals(wrongPasswordPagePom.profileText(), true);
	  Assert.assertEquals(wrongPasswordPagePom.contactsText(), true);
	  Assert.assertEquals(wrongPasswordPagePom.messageText(), true);
	  Assert.assertEquals(wrongPasswordPagePom.isChangePasswordDisplayed(),true);
	  screenShot.captureScreenShot("Fields Displayed 12");
	  wrongPasswordPagePom.clickChangePassword();
	  wrongPasswordPagePom.sendOldPassword("mehadi");
	  wrongPasswordPagePom.sendNewPassword("12345");
	  wrongPasswordPagePom.sendConfirmPassword("1234567");
	  screenShot.captureScreenShot("Change Password233");
	  wrongPasswordPagePom.changeSubmit();
	  Alert alt = driver.switchTo().alert();
	  System.out.println(alt.getText());
	  alt.accept();
	  Assert.assertEquals(wrongPasswordPagePom.homePageDisplayed(), true);
	  Assert.assertEquals(wrongPasswordPagePom.passwordPageDisplayed(), true);
  }
  
  @BeforeClass
  public void beforeClass() throws IOException  {
	  properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = DriverFactory.getDriver(DriverNames.CHROME);
		wrongPasswordPagePom = new WrongPasswordpagePom(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
  }

@AfterMethod
public void afterMethod() throws Exception {
	Thread.sleep(1000);
	driver.quit();
}
}
