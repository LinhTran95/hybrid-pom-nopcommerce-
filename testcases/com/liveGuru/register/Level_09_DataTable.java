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

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		userHomePage = PageGenerator.getUserHomePage(driver);
	}

	@Test
	public void TC_01_Register_User_At_User() {
		userLoginPage = userHomePage.clickToMyAccountPage();
		userRegisterPage = userLoginPage.clickCreateAccountButton();

		userRegisterPage.enterToFirstNameTextbox("");
		userRegisterPage.enterToLastNameTextbox("");
		userRegisterPage.enterToEmailAddressTextbox("");
		userRegisterPage.enterToPasswordTextbox("");
		userRegisterPage.enterToConfirmTextbox("");
		userDashboardPage = userRegisterPage.clickToRegisterButton();
		Assert.assertTrue(userDashboardPage.isUserRegisterSuccessMessageDisplay());
	}

	@Test
	public void TC_02_Search_User_At_Admin() {
		adminLoginPage = userDashboardPage.openAdminPage();

		adminLoginPage.enterToUserNameTextbox("user01");
		adminLoginPage.enterToPasswordTextbox("guru99com");

		adminManageCustomPage = adminLoginPage.clickToLoginButton();
		adminManageCustomPage.enterToTextboxAtColumnName("","");
		adminManageCustomPage.clickSearchButton();
		
		Assert.assertTrue(adminCustomerPage.isLoadingIconDisappear());
		assertTrue(adminCustomerPage.isUserInfoDisplayInTable(""));
		

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
