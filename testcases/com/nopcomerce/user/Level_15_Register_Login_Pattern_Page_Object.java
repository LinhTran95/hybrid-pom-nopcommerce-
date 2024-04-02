package com.nopcomerce.user;

import static org.testng.Assert.assertTrue;

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

public class Level_15_Register_Login_Pattern_Page_Object extends BaseTest {
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
		log.info("Pre-condition - Step 01: Open browser '" + browserName + "' and navigate to '" + url + "'");
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
		log.info("TC_01_Register- Step 01: Verify Home Page is display");
		homPage.openHeaderPageByName(driver, "Register");
		registerPage = PageGenerator.getRegisterPage(driver);

		log.info("TC_01_Register- Step 02: Click to Male Radio button");
		registerPage.clickToRadioButtonByID(driver, "gender-male");

		log.info("TC_01_Register- Step 03: Enter to First Name textbox");
		registerPage.enterToTextboxByID(driver, "FirstName", "John");

		log.info("TC_01_Register- Step 04: Enter to First Name textbox");
		registerPage.enterToTextboxByID(driver, "LastName", "Johny");

		log.info("TC_01_Register- Step 05: Select Day dropdown");
		registerPage.selectDropDownByName(driver, "DateOfBirthDay",day);

		log.info("TC_01_Register- Step 06: Select Month dropdown");
		registerPage.selectDropDownByName(driver, "DateOfBirthMonth",month);

		log.info("TC_01_Register- Step 07: Select Year dropdown");
		registerPage.selectDropDownByName(driver, "DateOfBirthYear",year);

		log.info("TC_01_Register- Step 08: Enter to Email textbox");
		registerPage.enterToTextboxByID(driver, "Email", emailAddress);

		log.info("TC_01_Register- Step 09: Enter to Company Name textbox");
		registerPage.enterToCompanyNameTextBox(companyName);

		log.info("TC_01_Register- Step 10: Enter to Password textbox");
		registerPage.enterToTextboxByID(driver, "Password", password);

		log.info("TC_01_Register- Step 11: Enter to Confirm Password textbox");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", password);

		log.info("TC_01_Register- Step 12: Click to register button");
		registerPage.clickToButtonByText(driver,"Register");

		log.info("TC_01_Register- Step 13: Verify success message is displayed");
		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplay());

		log.info("TC_01_Register- Step 14: Click log out link");
		registerPage.openHeaderPageByName(driver, "Log out");

	}

	@Test
	public void TC_02_Login() {

		log.info("TC_02_Login- Step 01: Click to Login Link");
		homPage.openHeaderPageByName(driver, "Login");
		loginPage = PageGenerator.getLoginPage(driver);

		log.info("TC_02_Login- Step 02: Enter to Email textbox with value: " + emailAddress);
		loginPage.enterToEmailTextBox(emailAddress);

		log.info("TC_02_Login- Step 03: Enter to Password textbox with value: " + password);
		loginPage.enterToPasswordTextBox(password);

		log.info("TC_02_Login- Step 04: Click to Login button");
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
	public void TC_04_Switch_Page_Common() {
		// Customer Infor chuyển qua page khác Orders
		ordersPage = (OrdersPageObject) customerInforPage.openSideBarPageByName(driver, "Orders");

		// Orders -> chuyển qua 1 page khác: Reward Point
		rewardPointsPage = (RewardPointsPageObject) ordersPage.openSideBarPageByName(driver, "Reward Points");

		// Reward Point -> Addresses
		addressesPage = (AddressesPageObject) rewardPointsPage.openSideBarPageByName(driver, "Addresses");

		// Addresses -> Customer Infor
		customerInforPage = (CustomerInforPageObject) addressesPage.openSideBarPageByName(driver, "Customer info");

		// Customer Infor -> Reward Points Page
		rewardPointsPage = (RewardPointsPageObject) customerInforPage.openSideBarPageByName(driver, "Reward Points");
		rewardPointsPage = (RewardPointsPageObject) addressesPage.openSideBarPageByName(driver, "Reward Points");
		rewardPointsPage = (RewardPointsPageObject) ordersPage.openSideBarPageByName(driver, "Reward Points");

		addressesPage = (AddressesPageObject) customerInforPage.openSideBarPageByName(driver, "Addresses");
		addressesPage = (AddressesPageObject) rewardPointsPage.openSideBarPageByName(driver, "Addresses");
		addressesPage = (AddressesPageObject) ordersPage.openSideBarPageByName(driver, "Addresses");

	}

	@Test
	public void TC_05_Switch_Page_Common() {
		// Customer Infor chuyển qua page khác Orders
		customerInforPage.openSideBarPageByName(driver, "Orders");
		ordersPage = PageGenerator.getOrderPage(driver);

		// Orders -> chuyển qua 1 page khác: Reward Point
		ordersPage.openSideBarPageByName(driver, "Reward Points");
		rewardPointsPage = PageGenerator.getRewardPointsPage(driver);

		// Reward Point -> Addresses
		addressesPage = PageGenerator.getAddressesPage(driver);

		// Addresses -> Customer Infor
		addressesPage.openSideBarPageByName(driver, "Customer info");
		customerInforPage = PageGenerator.getCustomerInforPage(driver);

		// Customer Infor -> Reward Points Page
		customerInforPage.openSideBarPageByName(driver, "Reward Points");
		rewardPointsPage = PageGenerator.getRewardPointsPage(driver);
	}

	@AfterClass
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		driver.quit();

	}

	public int getRandomNumber() {
		Random ran = new Random();
		return ran.nextInt(9999);
	}

}
