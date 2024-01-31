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
import pageObjectsnopComerce.HomePageObject;
import pageObjectsnopComerce.LoginPageObject;
import pageObjectsnopComerce.OrdersPageObject;
import pageObjectsnopComerce.AddressesPageObject;
import pageObjectsnopComerce.CustomerInforPageObject;
import pageObjectsnopComerce.PageGenerator;
import pageObjectsnopComerce.RegisterPageObject;
import pageObjectsnopComerce.RewardPointsPageObject;

public class Level_07_Switch_Page_Object extends BaseTest {
	WebDriver driver;
	HomePageObject homPage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	CustomerInforPageObject customerInforPage;
	AddressesPageObject addressesPage;
	RewardPointsPageObject rewardPointsPage;
	OrdersPageObject ordersPage;

	String projectPath = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		// driver.get("https://demo.nopcommerce.com/");
		// homPage = new HomePageObject(driver);
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
	@Test
	public void TC_05_Switch_Page_Common() {
		//Customer Infor chuyển qua page khác Orders 
		ordersPage= customerInforPage.openOrderPage(driver);
		
		
		//Orders -> chuyển qua 1 page khác: Reward Point
		rewardPointsPage = ordersPage.openRewardPointsPage(driver);

		
		//Reward Point -> Addresses 
		addressesPage = rewardPointsPage.openAddressesPage(driver);
	
		
		//Addresses -> Customer Infor 
		customerInforPage = addressesPage.openCustomerInforPage(driver);
		
		
		//Customer Infor -> Reward Points Page 
		rewardPointsPage = customerInforPage.openRewardPointsPage(driver);
		rewardPointsPage = addressesPage.openRewardPointsPage(driver);
		rewardPointsPage = ordersPage.openRewardPointsPage(driver);
		
		customerInforPage.openAddressesPage(driver);
		rewardPointsPage.openAddressesPage(driver);
		ordersPage.openAddressesPage(driver);

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
