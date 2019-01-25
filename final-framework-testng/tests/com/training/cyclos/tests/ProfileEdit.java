package com.training.cyclos.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ProfileEditPom;
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

public class ProfileEdit {
	WebDriver driver;
	ProfileEditPom profileEditPom;
	String baseUrl;
	Properties properties;
	ScreenShot screenShot;
	
  @Test
  public void profileEdit() {
	profileEditPom.clickPersonalLnk();
	profileEditPom.clickProfileLnk();
	screenShot.captureScreenShot("Profile Displayed");
	Assert.assertEquals(profileEditPom.changePasswordDisplayed(), true);
	Assert.assertEquals(profileEditPom.emailNotificationDisplayed(), true);
	profileEditPom.clickChangeBtn();
	profileEditPom.editName("Administrator");
	profileEditPom.clickSaveBtn();
	screenShot.captureScreenShot("Profile Changed");
	Alert alt = driver.switchTo().alert();
	System.out.println(alt.getText());
	alt.accept();  
	Assert.assertEquals(profileEditPom.adminProfileDisplayed(), true);
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = DriverFactory.getDriver(DriverNames.CHROME);
	  profileEditPom = new ProfileEditPom(driver);
	  baseUrl = properties.getProperty("baseURL");
	  screenShot = new ScreenShot(driver);
	  driver.get(baseUrl);
	  profileEditPom.sendUserName("admin");
	  profileEditPom.sendPassword("12345");
	  profileEditPom.clickSubmit();
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
