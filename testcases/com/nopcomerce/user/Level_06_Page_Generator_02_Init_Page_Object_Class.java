package com.nopcomerce.user;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageFactory.nopCommerces.*;


public class Level_06_Page_Generator_02_Init_Page_Object_Class extends BaseTest {
	WebDriver driver;
	HomePageObject homPage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	CustomerInforPageObject myAccountPage;

	String projectPath = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver (browserName,url);

		// 1- Mo app url lên -> Navigate tới HomePage
		driver.get("https://demo.nopcommerce.com/");
		homPage = new HomePageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		day = "10";
		month = "10";
		year = "2023";
		emailAddress = "Automationfc" + getRandomNumber() + "@gmail.com";
		companyName = "Automation";
		password = "123456";

	}

	@Test
	public void TC_01_Register() {
		// 2- Dang tu Home Page (Click vao Register Link) -> Navigate to Register Page
		homPage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		registerPage.clikToGenderMaleRadio();
		registerPage.enterToFirstNameTextBox(firstName);
		registerPage.enterToLastNameTextBox(lastName);
		registerPage.selectDayDropDrown(day);
		registerPage.selectMonthDropDrown(month);
		registerPage.selectYearDropDrown(year);
		registerPage.enterToEmailTextBox(emailAddress);
		registerPage.enterToCompanyNameTextBox(companyName);
		registerPage.enterToPasswordTextBox(password);
		registerPage.enterToPasswordConfirmeTextBox(password);
		registerPage.clickRegisterButton();

		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplay());

		// 3-Stay at Register Page (click logout link) -> Navigate to HomePage
		registerPage.clickLogOutLink();
		homPage = new HomePageObject(driver);
	}

	@Test
	public void TC_02_Login() {
		// 4- Stay at Home Page (click log in link) -> Navigate to Log In
		loginPage = homPage.clickToLoginLink();

		loginPage.enterToEmailTextBox(emailAddress);
		loginPage.enterToPasswordTextBox(password);
		loginPage.clickToLoginButton();

		// 5- Stay at Log in Page (click Log In Button) -> Navigate to Home Page
		loginPage.clickToLoginButton();
		homPage = new HomePageObject(driver);

	}

	@Test
	public void TC_03_My_Account() {
		// 6- Đang từ Home Page (Click to My Account Link) ->Navigate to My Account Page
		myAccountPage = new CustomerInforPageObject(driver);

		Assert.assertTrue(myAccountPage.isGenderMaleRadioSelected());
		Assert.assertEquals(myAccountPage.getFirtNameTextBoxValue(), firstName);
		Assert.assertEquals(myAccountPage.getLastNameTextBoxValue(), lastName);
		Assert.assertEquals(myAccountPage.getEmailTextBoxValue(), emailAddress);
		Assert.assertEquals(myAccountPage.getCompanyNameTextBoxValue(), companyName);

		Assert.assertEquals(myAccountPage.getDateDropDrownValue(), day);
		Assert.assertEquals(myAccountPage.getMonthDropDrownValue(), month);
		Assert.assertEquals(myAccountPage.getYearDropDrownValue(), year);
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
