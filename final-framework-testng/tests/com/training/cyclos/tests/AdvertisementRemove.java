package com.training.cyclos.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdvertisementPom;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class AdvertisementRemove {
	private WebDriver driver;
	private String baseUrl;
	private AdvertisementPom advertisementPom;
	private static Properties properties;
	private ScreenShot screenShot;
	boolean expected;
  @Test
  public void f() throws InterruptedException {
	  advertisementPom.sendUserName("admin");
	  advertisementPom.sendPassword("12345");
	  advertisementPom.clickLoginBtn();
	  advertisementPom.sendMemberUserName("manzoor");
	  advertisementPom.clickAdvertisment();
	  advertisementPom.clickSubmitBtn();
	  advertisementPom.clickRemoveAdd();
	  Alert alt = driver.switchTo().alert();
	  System.out.println(alt.getText());
	  alt.accept();
	  System.out.println(alt.getText());
	  alt.accept();
	  advertisementPom.clickLogout();
	  alt.accept();
	  
	  advertisementPom.sendUserName("manzoor");
	  advertisementPom.sendPassword("manzoor");
	  advertisementPom.clickLoginBtn();
	  advertisementPom.clickPersonel();
	  advertisementPom.clickAdvertisment();
	  List<WebElement> list=driver.findElements(By.xpath("//tbody//tbody/child::tr/child::td/div/a[@class='linkList viewAd']"));
	
	  for(int i=0;i<list.size();i++)
	  {
		  String str= list.get(i).getText();
		  expected = str.equalsIgnoreCase("try");
		  if(expected==true)
		  {
			  break;
		  }
		  
	  }
	  
	  assertEquals(expected, false);
	  
	  }
  @BeforeMethod
  public void beforeMethod() {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		advertisementPom = new AdvertisementPom(driver); 
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
