package com.training.cyclos.tests;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Account_Pom;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Account {
	public WebDriver driver;
	private String baseUrl;
	private Account_Pom accountDetails;
	private static Properties properties;
	private ScreenShot screenShot;

	@Test
	public void f() throws InterruptedException {
		accountDetails.sendUserName("admin");
		accountDetails.sendPassword("12345");
		accountDetails.clickLoginBtn();
		screenShot.captureScreenShot("First");
		accountDetails.clickAccount();
		accountDetails.clickMemberPayments();
		screenShot.captureScreenShot("Account Payment");
		accountDetails.sendMemberUserName("selenium");
		accountDetails.sendAmount("1");
		accountDetails.senddescription("Birth day Gift");
		accountDetails.clickSubmit();
		screenShot.captureScreenShot("Payment Confirmation");
		Assert.assertEquals(accountDetails.contentConfirmation(), true);
		System.out.println(accountDetails.contentConfirmation());
		accountDetails.clickSubmitButton();
		Assert.assertEquals(accountDetails.contentSuccessScreen(), true);
		accountDetails.clickMemberButton();
		accountDetails.clickInfoBtn();
		screenShot.captureScreenShot("Information");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		accountDetails = new Account_Pom(driver);
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

	@BeforeClass
	public void beforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

}
