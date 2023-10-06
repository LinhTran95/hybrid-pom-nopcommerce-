package com.nopcomerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_01_Register_Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.nopcommerce.com/en/demo");
	}
	@Test
	public void TC_01_Register_Empty_Data() {
		
	}
	@Test
	public void TC_02_Register_Invalid_Email() {
		
	}
	@Test
	public void TC_03_Register_Invalid_Password() {
		
	}
	@AfterClass 
	public void afterClass() {
		driver.quit();
		
	}
	

}
