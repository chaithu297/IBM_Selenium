package com.training.cyclos.tests;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
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
	
  @Test
  public void grantloan() throws Exception {
	  grantLoanPom.sendUserName("admin");
	  grantLoanPom.sendPassword("12345");
	  grantLoanPom.clickLoginBtn();
//	  System.out.println(driver.getCurrentUrl());
	  grantLoanPom.sendMemberName("manzoor");
	  Thread.sleep(3000);
//	  System.out.println(driver.getCurrentUrl());
	  grantLoanPom.grantloan();
//	  grantLoanPom.grantloan();

	  grantLoanPom.sendAmount("100");
	  grantLoanPom.description("Home Loan");
	  grantLoanPom.clickSubmit();
	  grantLoanPom.label();
	  grantLoanPom.clickSubmitBtn();
	  Alert alt = driver.switchTo().alert();
	  System.out.println(alt.getText());
	  alt.accept();
	  grantLoanPom.clickLoan();
	  grantLoanPom.viewLoan();
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
