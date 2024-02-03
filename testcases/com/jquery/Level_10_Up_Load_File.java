package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjectjQuery.PageGenerator;
import pageObjectjQuery.UploadPageObject;

public class Level_10_Up_Load_File extends BaseTest {
	WebDriver driver;
	UploadPageObject uploadPage;
	String picOne = "01.jpg";
	String picTwo = "02.jpg";
	String picThree = "03.jpg";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		uploadPage = PageGenerator.getUploadPage(driver);

	}

	@Test
	public void TC_01_Upload_One_File() {
		uploadPage.uploadFile(picOne);
		// Verify file name load success
		Assert.assertTrue(uploadPage.isFileNameLoadedSuccess(picOne));

		// Click Upload button
		uploadPage.clickToStartButtonByFileName(picOne);

		// Verify file name upload success
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(picOne));

	}

	@Test
	public void TC_02_Upload_Two_File() {
		uploadPage.refreshCurrentPage(driver);
		uploadPage.uploadFile(picOne, picTwo);
		// Verify file name load success
		Assert.assertTrue(uploadPage.isFileNameLoadedSuccess(picOne));
		Assert.assertTrue(uploadPage.isFileNameLoadedSuccess(picTwo));
		// Click Upload button
		uploadPage.clickToStartButtonByFileName(picOne);
		uploadPage.clickToStartButtonByFileName(picTwo);

		// Verify file name upload success
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(picOne));
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(picTwo));

	}

	@Test
	public void TC_03_Upload_Three_File() {
		uploadPage.refreshCurrentPage(driver);
		
		uploadPage.uploadFile(picOne, picTwo, picThree);
		// Verify file name load success
		Assert.assertTrue(uploadPage.isFileNameLoadedSuccess(picOne));
		Assert.assertTrue(uploadPage.isFileNameLoadedSuccess(picTwo));
		Assert.assertTrue(uploadPage.isFileNameLoadedSuccess(picThree));
		// Click Upload button
		uploadPage.clickToStartButtonByFileName(picOne);
		uploadPage.clickToStartButtonByFileName(picTwo);
		uploadPage.clickToStartButtonByFileName(picThree);

		// Verify file name upload success
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(picOne));
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(picTwo));
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(picThree));

	}

	@AfterClass
	public void afterClass() {

		driver.quit();

	}
}
