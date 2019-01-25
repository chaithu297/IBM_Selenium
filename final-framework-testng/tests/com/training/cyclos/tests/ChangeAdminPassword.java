package com.training.cyclos.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChangeAdminPassPOM;
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

public class ChangeAdminPassword {
	private WebDriver driver;
	private ChangeAdminPassPOM changeAdminPassword;
	private ScreenShot screenShot;
	private String baseUrl;
	private static Properties properties;
	
	@BeforeClass
	public static void beforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
	}
  @Test
  public void changeAdminPass() {
	  changeAdminPassword.sendUserName("admin");
	  changeAdminPassword.sendPassword("12345");
	  changeAdminPassword.clickSubmit();
	  changeAdminPassword.clickPersonalLink();
	  changeAdminPassword.clickChangePassword();
	  screenShot.captureScreenShot("ChangeAdminPassword");
	  changeAdminPassword.sendOldPassword("12345");
	  changeAdminPassword.sendNewPassword("12345");
	  changeAdminPassword.sendConfirmPassword("12345");
	  screenShot.captureScreenShot("Changedpassword");
	  changeAdminPassword.changeSubmit();
	  Alert altn = driver.switchTo().alert();
	  System.out.println(altn.getText());
	  altn.accept();
	  Assert.assertEquals(changeAdminPassword.homePageDisplayed(), true);
  }
  @BeforeMethod
  public void beforeMethod() {
	driver = DriverFactory.getDriver(DriverNames.CHROME);
	  changeAdminPassword = new ChangeAdminPassPOM(driver);
     baseUrl = properties.getProperty("baseURL");
     screenShot = new ScreenShot(driver);
     driver.get(baseUrl);
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  Thread.sleep(1000);
	  driver.quit();
  }

}
