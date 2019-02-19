package com.training.cyclos.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AddAdvertisementPom;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddAdvertisement {
	private WebDriver driver;
	private String baseUrl;
	private AddAdvertisementPom advertisementPom;
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
		advertisementPom = new AddAdvertisementPom(driver);
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
	public void loginDBTest(String userName, String password, String memberName,String title, String category, String price, String Description) throws AWTException, InterruptedException {
		advertisementPom.sendUserName(userName);
		advertisementPom.sendPassword(password);
		advertisementPom.clickLoginBtn();
		advertisementPom.sendMemberName(memberName);
		advertisementPom.clickAdvertisement();
		advertisementPom.clickNewAdvertisement();
		advertisementPom.sendTitle(title);
		Thread.sleep(1000);
		advertisementPom.selectCategory(category);
		advertisementPom.sendPrice(price);
		Thread.sleep(1000);
		advertisementPom.clickCheckBox();
		advertisementPom.sendDescription(Description);
		advertisementPom.clickSaveBtn();
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		advertisementPom.clickBackBtn();
		Thread.sleep(1000);
		
		
	}

	}

