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
import pageObjectsnopComerce.CustomerInforPageObject;
import pageObjectsnopComerce.HomePageObject;
import pageObjectsnopComerce.LoginPageObject;
import pageObjectsnopComerce.PageGenerator;
import pageObjectsnopComerce.RegisterPageObject;

public class Level_06_Page_Generator_03_Init_Page_Generator_Class extends BaseTest {
	WebDriver driver;
	HomePageObject homPage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	CustomerInforPageObject customerInforPage;

	String projectPath = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		homPage = PageGenerator.getHomePage(driver);

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

		registerPage.clickLogOutLink();
		homPage = new HomePageObject(driver);
	}

	@Test
	public void TC_02_Login() {

		loginPage = homPage.clickToLoginLink();

		loginPage.enterToEmailTextBox(emailAddress);
		loginPage.enterToPasswordTextBox(password);
		loginPage.clickToLoginButton();

		loginPage.clickToLoginButton();
		homPage = new HomePageObject(driver);

	}

	@Test
	public void TC_03_My_Account() {

		customerInforPage = new CustomerInforPageObject(driver);

		Assert.assertTrue(customerInforPage.isGenderMaleRadioSelected());
		Assert.assertEquals(customerInforPage.getFirtNameTextBoxValue(), firstName);
		Assert.assertEquals(customerInforPage.getLastNameTextBoxValue(), lastName);
		Assert.assertEquals(customerInforPage.getEmailTextBoxValue(), emailAddress);
		Assert.assertEquals(customerInforPage.getCompanyNameTextBoxValue(), companyName);

		Assert.assertEquals(customerInforPage.getDateDropDrownValue(), day);
		Assert.assertEquals(customerInforPage.getMonthDropDrownValue(), month);
		Assert.assertEquals(customerInforPage.getYearDropDrownValue(), year);
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
