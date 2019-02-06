package com.training.cyclos.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdvertisementPom;
import com.training.pom.RepaymentLoanPom;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class RepaymentLoan {
	private WebDriver driver;
	private String baseUrl;
	private RepaymentLoanPom repaymentLoanPom;
	private static Properties properties;
	private ScreenShot screenShot;
	boolean expected;
  @Test
  public void loanRepayment() throws InterruptedException {
	  repaymentLoanPom.sendUserName("chaitanya");
	  repaymentLoanPom.sendPassword("12345");
	  repaymentLoanPom.clickLoginBtn();
	  repaymentLoanPom.clickAccount();
	  repaymentLoanPom.clickLoan();
	  repaymentLoanPom.clickViewIcon();
	  repaymentLoanPom.sendAmount("50");
	  screenShot.captureScreenShot("Repay loan");
	  repaymentLoanPom.clickSubmit();
	  Alert alt = driver.switchTo().alert();
	  System.out.println(alt.getText());
	  alt.accept();
	  System.out.println(alt.getText());
	  alt.accept();
	  String actual = driver.findElement(By.xpath("//tbody//tr[4]/child::td[4]")).getText();
	  repaymentLoanPom.clickAccountInformation();
	  screenShot.captureScreenShot("loan repaid");
	  String expected = driver.findElement(By.xpath("//td[@class='headerLabel']/following-sibling::td")).getText();
	  assertEquals(actual, expected);
  }
  @BeforeMethod
  public void beforeMethod() {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		repaymentLoanPom = new RepaymentLoanPom(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  driver.quit();
  }

  @BeforeClass
  public void beforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
  }

}
