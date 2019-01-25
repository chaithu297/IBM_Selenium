package com.training.cyclos.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChangePasswordPom;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class ChangePassword {
	WebDriver driver;
	ChangePasswordPom changepasswordPOM;
	String baseUrl;
	Properties properties;
	ScreenShot screenShot;
	
  @Test
  public void changePassword() {
	 
	  changepasswordPOM.clickPersonalLink();
	  Assert.assertEquals(changepasswordPOM.profileText(), true);
	  Assert.assertEquals(changepasswordPOM.contactsText(), true);
	  Assert.assertEquals(changepasswordPOM.messageText(), true);
	  Assert.assertEquals(changepasswordPOM.isChangePasswordDisplayed(),true);
	  screenShot.captureScreenShot("Fields Displayed");
	  changepasswordPOM.clickChangePassword();
	  changepasswordPOM.sendOldPassword("mehadi");
	  changepasswordPOM.sendNewPassword("12345");
	  changepasswordPOM.sendConfirmPassword("12345");
	  screenShot.captureScreenShot("Change Password");
	  changepasswordPOM.changeSubmit();
	  Alert alt = driver.switchTo().alert();
	  System.out.println(alt.getText());
	  alt.accept();
	  Assert.assertEquals(changepasswordPOM.homePageDisplayed(), true);
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = DriverFactory.getDriver(DriverNames.CHROME);
		changepasswordPOM = new ChangePasswordPom(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		 changepasswordPOM.sendUserName("chaitanya");
		  changepasswordPOM.sendPassword("mehadi");
		  changepasswordPOM.clickSubmit();
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  Thread.sleep(1000);
	  driver.quit();
  }

  @BeforeClass
  public void beforeClass() throws IOException {
	  properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	  
  }

}
