package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjectjQuery.PageGenerator;
import pageObjectjQuery.UploadPageObject;
import pageObjectliveGuru.UserRegisterPageObject;
import pageObjectsnopComerce.RegisterPageObject;

public class Level_11_Register_Assert_Verify extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		registerPage = PageGenerator.getRegisterPage(driver);

	}

	@Test
	public void TC_Register_01_Assert() {
		// Failed lần 1
		verifyFalse(registerPage.isEmaiTextboxDisplay());

		registerPage.enterToEmailTextbox("abc@gmail.com");
		registerPage.sleepInSecond(3);

		// Failed lần 2
		verifyFalse(registerPage.isConfirmEmailTextboxDisplay());

		registerPage.enterToEmailTextbox("abc@gmail.com");
		registerPage.sleepInSecond(3);

		verifyFalse(registerPage.isConfirmEmailTextboxDisplay());

		verifyTrue(registerPage.isConfirmEmailTextboxDisplay());

		// Failed lần 3
		verifyFalse(registerPage.isLoginButtonUnDisplay());

		// Expected
		// Test case result: Failed
		// Log error message

	}

	@Test
	public void TC_02_Verify() {

	}

	@AfterClass
	public void afterClass() {

		driver.quit();

	}
}
