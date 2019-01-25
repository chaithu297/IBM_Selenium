package com.training.cyclos.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LogOutPom;
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

public class Logout {
	WebDriver driver;
	  LogOutPom logOutPom;
	  Properties properties;
	  String baseUrl;
	  ScreenShot screenShot;
  @Test
  public void logoutBtn() {
	  logOutPom.sendUserName("admin");
	  logOutPom.sendPassword("12345");
	  logOutPom.clickSubmit();
	  screenShot.captureScreenShot("Admin logged in");
	  Assert.assertEquals(logOutPom.homeDisplayed(), true);
	  logOutPom.clickLogout();
	  Alert alt = driver.switchTo().alert();
	  System.out.println(alt.getText());
	  alt.accept();
	  screenShot.captureScreenShot("Login Form");
	  Assert.assertEquals(logOutPom.loginFormDisplayed(), true);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = DriverFactory.getDriver(DriverNames.CHROME);
	  logOutPom = new LogOutPom(driver);
	  baseUrl = properties.getProperty("baseURL");
	  screenShot = new ScreenShot(driver);
	  driver.get(baseUrl);
	  
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
