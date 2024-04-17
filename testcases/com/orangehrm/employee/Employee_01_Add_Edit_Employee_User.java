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
	EmployeeDetailPageObject employeeDetailPage;
	EmployeeListPageObject employeelistPage;
	UserDetailPageObject userdetailPage;

	String firstName, lastName, employeeID;
	String editFirstName, editLastName, editDriverLicenseNumber, editNationality, editLicenseExpiryDate,
			editMarrialStatus, editDateofBirth, editGender;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		loginPage = PageGeneraterManager.getLoginPage(driver);

		firstName = "Automation " + getRandomNumber();
		lastName = "Testing " + getRandomNumber();
		editFirstName = "Manual " + getRandomNumber();
		editLastName = "FC " + getRandomNumber();
		editDriverLicenseNumber = "11233-1578-47895";
		editNationality = "Vietnamese";
		editLicenseExpiryDate = "2024-05-05";
		editMarrialStatus = "Single";
		editDateofBirth = "1990-05-05";
		editGender = "Male";

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
		log.info("Add Employee Step 01: Open PIM page menu");
		dashboardPage.openMenuPageByName(driver, "PIM");
		employeelistPage = PageGeneraterManager.getEmployeeListPage(driver);

		log.info("Add Employee Step 02: Click Add button");
		employeeDetailPage = employeelistPage.clickToAddButton();

		log.info("Add Employee Step 03: Enter First Name");
		employeeDetailPage.enterToFirstNameTextboxAtAddEmployeeForm(firstName);

		log.info("Add Employee Step 04: Enter Last Name ");
		employeeDetailPage.enterToLastNameTextboxAtAddEmployeeForm(lastName);

		log.info("Add Employee Step 05: Get employee ID ");
		employeeID = employeeDetailPage.getEmployeeIDAtEmployeeForm();

		log.info("Add Employee Step 06: Save new employee");
		employeeDetailPage.clickToSaveButton();

		log.info("Add Employee Step 07: Verify inforamtion at Personal page display correctly");
		verifyTrue(employeeDetailPage.isFullNameDisplayAtHeader(firstName + " " + lastName));
		verifyEquals(employeeDetailPage.getFirstNameValueAtPersonalDetailForm(), firstName);
		verifyEquals(employeeDetailPage.getLastNameValueAtPersonalDetailForm(), lastName);

		log.info("Add Employee Step 08:Verify employee id display correctly ");
		// Personal Detail form
		verifyEquals(employeeDetailPage.getEmployeeIDValueAtPersonalDetailForm(), employeeID);

	}

	@Test
	public void TC_02_Edit_Employee_By_Personal() {
		log.info("Edit Employee [Personal] Step 01: Enter new info to 'First Name' text box");
		employeeDetailPage.enterToFirstNameTextBoxAtPersonalDetailForm(editFirstName);

		log.info("Edit Employee [Personal] Step 02: Enter new info to 'Last Name' text box");
		employeeDetailPage.enterToLastNameTextBoxAtPersonalDetailForm(editLastName);

		log.info("Edit Employee [Personal] Step 03: Enter new info to 'Driver's License Number' text box");
		employeeDetailPage.enterToDriverLicenseNumberTextBoxAtPersonalDetailForm(editLicenseExpiryDate);

		log.info("Edit Employee [Personal] Step 06: Enter new info to 'License Expiry Date' text box");
		employeeDetailPage.enterToLicenseExpiryDateTextBoxAtPersonalDetailForm(editLicenseExpiryDate);

		log.info("Edit Employee [Personal] Step 04: Select info in 'Nationality' with 'Vietnamese'");
		employeeDetailPage.selectDataForNationalityDropdownAtPersonalDetailForm(editNationality);

		log.info("Edit Employee [Personal] Step 05: Select info in 'Marrial Status' with 'Single'");
		employeeDetailPage.selectDataForMarrialStatusDropdownAtPersonalDetailForm(editMarrialStatus);

		log.info("Edit Employee [Personal] Step 06: Click to 'Gender' radio button with 'Male'");
		employeeDetailPage.clickToGenderRadioButtonAtPersonalDetailForm();

		log.info("Edit Employee [Personal] Step 07: Enter new info to 'Date of Birth' text box");
		employeeDetailPage.enterToDateOfBirthTextBoxAtPersonalDetailForm(editDateofBirth);

		log.info("Edit Employee [Personal] Step 08: Verify success message displays with value 'Successfully Saved'");
		verifyEquals(employeeDetailPage.getSuccessMessageAtPersonalDetailForm(), "Successfully Saved");

		log.info("Edit Employee [Personal] Step 09: Verify 'First Name' text box edited successfully");
		verifyEquals(employeeDetailPage.getFistNameAtPersonalDetailForm(), editFirstName);

		log.info("Edit Employee [Personal] Step 10: Verify 'Last Name' text box edited successfully");
		verifyEquals(employeeDetailPage.getLastNameAtPersonalDetailForm(),editLastName);

		log.info("Edit Employee [Personal] Step 11: Verify 'Driver's License Number' text box edited successfully");
		verifyEquals(employeeDetailPage.getDriverLincenseNumberAtPersonalDetailForm(), editDriverLicenseNumber);

		log.info("Edit Employee [Personal] Step 12: Verify 'License Expiry Date' text box edited successfully");
		verifyEquals(employeeDetailPage.getLicenseExpiryDateAtPersonalDetailForm(), editLicenseExpiryDate);

		log.info("Edit Employee [Personal] Step 13: Verify 'Nationality' with 'Vietnam' edited successfully");
		verifyEquals(employeeDetailPage.getSelectedItemOfNaitonalityDropDownAtPersonalDetailForm(), editNationality);

		log.info("Edit Employee [Personal] Step 14: Verify 'Marital Status' with 'Single ' edited successfully");
		verifyEquals(employeeDetailPage.getSelectedItemOfMarrialStatusDropDownAtPersonalDetailForm(), editMarrialStatus);

		log.info("Edit Employee [Personal] Step 15: Verify 'Date of Birth' text box edited successfully");
		verifyEquals(employeeDetailPage.getDOBDateAtPersonalDetailFormAtPersonalDetailForm(), editDateofBirth);

		log.info("Edit Employee [Personal] Step 16: Verify 'Gender' radio button edited successfully");
		verifyTrue(employeeDetailPage.isGenderRadioButtonSelectedAtPersonalDetailForm(editGender));
		
	}

	@Test
	public void TC_03_Edit_Employee_By_Contact() {

	}

	@Test
	public void TC_04_Edit_Employee_By_Job() {

	}

	@Test
	public void TC_05_Edit_Employee_By_Salary() {

	}

	@Test
	public void TC_06_Add_User_To_Employee() {

	}

	@Test
	public void TC_07_Search_User() {

	}

	@Test
	public void TC_08_Delete_User() {

	}

	@Test
	public void TC_09_Delete_Employee() {

	}

	@Test
	public void TC_10_Search_Employee() {

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
