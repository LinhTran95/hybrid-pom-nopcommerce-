package com.orangehrm.employee;

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
import pageObjects.orangehrm.DashboardPageObject;
import pageObjects.orangehrm.EmployeeDetailPageObject;
import pageObjects.orangehrm.EmployeeListPageObject;
import pageObjects.orangehrm.LoginPageObject;
import pageObjects.orangehrm.PageGeneraterManager;
import pageObjects.orangehrm.UserDetailPageObject;

public class Employee_01_Add_Edit_Employee_User extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	EmployeeDetailPageObject employeePage;
	EmployeeListPageObject employeelistPage;
	UserDetailPageObject userdetailPage;

	String firstName, lastName, employeeID;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		loginPage = PageGeneraterManager.getLoginPage(driver);

		firstName = "Automation";
		lastName = "Testing";
		employeeID = "";

		log.info("Pre-condition- Step 01: Enter Username Textbox");
		loginPage.enterToUserNameTextBox("Admin");

		log.info("Pre-condition- Step 02: Enter Password Textbox");
		loginPage.enterToPasswordTextBox("admin123");

		log.info("Pre-condition- Step 03: Click Login Button");
		dashboardPage = loginPage.ClicktoLoginButton();

		// Navigate to Dashboard
	}

	@Test
	public void TC_01_Add_Employee() {
		dashboardPage.openMenuPageByName(driver, "PIM");
		employeelistPage = PageGeneraterManager.getEmployeeListPage(driver);

		employeePage = employeelistPage.clickToAddButton();
		employeePage.enterToFirstNameTextbox(firstName);
		employeePage.enterToLastNameTextbox(lastName);
		
		// Add employee form 
		employeeID = employeePage.getEmployeeIDAtEmployeeForm();
		employeePage.clickToSaveButton();
		verifyTrue(employeePage.isFullNameDisplayAtHeader(firstName + " " + lastName));
		verifyEquals(employeePage.getFirstNameValueAtPersonalDetailForm(), firstName);
		verifyEquals(employeePage.getLastNameValueAtPersonalDetailForm(), lastName);
		
		// Personal Detail form
		verifyEquals(employeePage.getEmployeeIDValueAtPersonalDetailForm(), employeeID);

	}

	@Test
	public void TC_02_Search_Employee() {

	}

	@Test
	public void TC_03_Edit_Employee_By_Personal() {
	}

	@Test
	public void TC_04_Edit_Employee_By_Contact() {

	}

	@Test
	public void TC_05_Edit_Employee_By_Job() {

	}

	@Test
	public void TC_06_Edit_Employee_By_Salary() {

	}

	@Test
	public void TC_07_Add_User_To_Employee() {

	}

	@Test
	public void TC_08_Search_User() {

	}

	@Test
	public void TC_09_Delete_User() {

	}

	@Test
	public void TC_09_Delete_Employee() {

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
