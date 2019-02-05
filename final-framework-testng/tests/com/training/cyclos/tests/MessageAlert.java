package com.training.cyclos.tests;

import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.MessagePom;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class MessageAlert {
	private WebDriver driver;
	private MessagePom messagePom;
	private ScreenShot screenShot;
	private Properties properties;
	String baseUrl;
  @Test
  public void f() {
	  messagePom.sendUserName("admin");
	  messagePom.sendPassword("12345");
	  messagePom.clickLoginBtn();
	  messagePom.clickMessages();
	  messagePom.clickMessageLink();
	  messagePom.clickNewMessage();
	  messagePom.sendMemberName("manzoor");
	  messagePom.selectCategory();
	  messagePom.sendSubject("Hello");
	  messagePom.sendBodyText("Welcome");
	  messagePom.clickSubmit();
	  Alert alt = driver.switchTo().alert();
	  System.out.println(alt.getText());
	  alt.accept();
	  messagePom.clickLogOut();
	  System.out.println(alt.getText());
	  alt.accept();
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = DriverFactory.getDriver(DriverNames.CHROME);
		messagePom = new MessagePom(driver); 
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
