package com.alada.login;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BasePage;
import pageObjectAlada.HomePageObject;
import pageObjectAlada.LoginPageObject;

public class Level_03_Login_Page_Object_Pattern {
	WebDriver driver;
	LoginPageObject loginPage; 
	HomePageObject homePage;
	
	String projectPath = System.getProperty("user.dir");


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
		driver = new ChromeDriver();

		// 1- Mo app url lên -> Navigate tới HomePage
		driver.get("https://alada.vn/tai-khoan/dang-nhap.html");
		loginPage = new LoginPageObject(driver);

	}

	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {
		loginPage.enterToEmailTextbox("");
		loginPage.enterToPassword("");
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(""), "Vui lòng nhập email");
		Assert.assertEquals(loginPage.getErrorMessageAtPasswordTextbox(""), "Vui lòng nhập mật khẩu");
		

	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {
		loginPage.enterToEmailTextbox("automation@5553");
		loginPage.enterToPassword("123456");
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(""), "Vui lòng nhập email hợp lệ");
	
	}

	@Test
	public void TC_03_LoginWithNotRegisteredEmail() {
		loginPage.enterToEmailTextbox("automation@5553" + getRandomNumber() + "@hotmail.com");
		loginPage.enterToPassword("123456");
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtLoginForm(""), "Email này chưa được đăng ký.");
		
	}

	@Test
	public void TC_04_LoginWithInvalidPassword() {
		//Invalid Password
		loginPage.enterToEmailTextbox("automationfc.vn@hotmail.com");
		loginPage.enterToPassword("123");
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtLoginForm(""), "Mật khẩu sai.");
		
		//Incorrect Password
		loginPage.enterToEmailTextbox("automationfc.vn@hotmail.com");
		loginPage.enterToPassword("123456789");
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtLoginForm(""), "Mật khẩu sai.");
		
		
	}
	@Test
	public void TC_05_LoginWithValidEmailAndPassword() {
		loginPage.enterToEmailTextbox("automationfc.vn@hotmail.com");
		loginPage.enterToPassword("123");
		loginPage.clickLoginButton();
		homePage = new HomePageObject(driver);
		
		Assert.assertTrue(homePage.isMyCourseDisplay());
		
			
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();

	}

	public int getRandomNumber() {
		Random ran = new Random();
		return ran.nextInt(9999);
	}

}
