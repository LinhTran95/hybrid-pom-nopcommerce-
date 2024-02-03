package com.liveGuru.register;

import static org.testng.Assert.assertTrue;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalConstants;
import pageObjectliveGuru.AdminCustomerPageObject;
import pageObjectliveGuru.AdminLoginPageObject;
import pageObjectliveGuru.AdminManageCustomerPageObject;
import pageObjectliveGuru.PageGenerator;
import pageObjectliveGuru.UserDashboardPageObject;
import pageObjectliveGuru.UserHomePageObject;
import pageObjectliveGuru.UserLoginPageObject;
import pageObjectliveGuru.UserRegisterPageObject;

public class Level_09_DataTable extends BaseTest {
	WebDriver driver;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	UserRegisterPageObject userRegisterPage;
	UserDashboardPageObject userDashboardPage;
	AdminCustomerPageObject adminCustomerPage;
	AdminLoginPageObject adminLoginPage;
	AdminManageCustomerPageObject adminManageCustomPage;
	String firstName, lastName, emailAddress, fullName, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		userHomePage = PageGenerator.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		fullName = firstName + " " + lastName;
		emailAddress = "afc" + getRandomNumber() + "@gmail.com";
		password = "123456";
	}

	@Test
	public void TC_01_Register_User_At_User() {
		userLoginPage = userHomePage.clickToMyAccountPage();
		userRegisterPage = userLoginPage.clickCreateAccountButton();

		userRegisterPage.enterToFirstNameTextbox(firstName);
		userRegisterPage.enterToLastNameTextbox(lastName);
		userRegisterPage.enterToEmailAddressTextbox(emailAddress);
		userRegisterPage.enterToPasswordTextbox(password);
		userRegisterPage.enterToConfirmTextbox(password);
		userDashboardPage = userRegisterPage.clickToRegisterButton();
		Assert.assertTrue(userDashboardPage.isUserRegisterSuccessMessageDisplay());
	}

	@Test
	public void TC_02_Search_User_At_Admin() {
		adminLoginPage = userDashboardPage.openAdminLoginPage();

		adminLoginPage.enterToUserNameTextbox(GlobalConstants.ADMIN_USER);
		adminLoginPage.enterToPasswordTextbox(GlobalConstants.ADMIN_PASSWORD);

		adminManageCustomPage = adminLoginPage.clickToLoginButton();
		adminManageCustomPage.closePopupWindow();
		
		adminManageCustomPage.enterToTextboxAtColumnName("Email", emailAddress);
		adminManageCustomPage.clickSearchButton();

		Assert.assertFalse(adminManageCustomPage.isLoadingIconDisappear());
		assertTrue(adminManageCustomPage.isUserInfoDisplayInTable(fullName, emailAddress));
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
