package com.training.cyclos.tests;

import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AccessProvidedPom;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class AccessProvided {
	private WebDriver driver;
	private String baseUrl;
	private AccessProvidedPom accessPom;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		accessPom = new AccessProvidedPom(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String userName, String password, String memberName,String group, String comments) throws AWTException, InterruptedException {
		accessPom.sendUserName(userName);
		accessPom.sendPassword(password);
		accessPom.clickLoginBtn();
		screenShot.captureScreenShot(userName);
		accessPom.sendMemberName(memberName);
		accessPom.changePermission();
		accessPom.selectGroup(group);
		accessPom.provideComments(comments);
		screenShot.captureScreenShot(userName);
		accessPom.clickSubmit();
	    Alert alt = driver.switchTo().alert();
	    alt.accept();
	    accessPom.clickHome();
	    Thread.sleep(2000);

	}


}
