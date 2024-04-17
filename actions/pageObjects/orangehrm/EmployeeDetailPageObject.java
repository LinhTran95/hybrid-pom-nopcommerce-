package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.orangehrm.EmployeeDetailPageUI;
import pageUIs.orangehrm.OrangeHRMBasePageUI;

public class EmployeeDetailPageObject extends BasePage {
	WebDriver driver;

	public EmployeeDetailPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void enterToFirstNameTextboxAtAddEmployeeForm(String firstName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRST_NAME_TEXT_BOX_AT_ADD_EMPLOYEE_PAGE);
		enterToTextboxByID(driver, EmployeeDetailPageUI.FIRST_NAME_TEXT_BOX_AT_ADD_EMPLOYEE_PAGE, firstName);
	}

	public void enterToLastNameTextboxAtAddEmployeeForm(String lastName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LAST_NAME_TEXT_BOX_AT_ADD_EMPLOYEE_PAGE);
		enterToTextboxByID(driver, EmployeeDetailPageUI.LAST_NAME_TEXT_BOX_AT_ADD_EMPLOYEE_PAGE, lastName);
	}

	public String getEmployeeIDAtEmployeeForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXT_BOX_AT_ADD_EMPLOYEE_PAGE);
		return getElementText(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXT_BOX_AT_ADD_EMPLOYEE_PAGE);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, EmployeeDetailPageUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_PAGE);
		clickToElement(driver, EmployeeDetailPageUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_PAGE);
	}

	public boolean isFullNameDisplayAtHeader(String fullName) {
		waitForElementClickable(driver, EmployeeDetailPageUI.FULLNAME_HEADER_TEXT_AT_PERSONAL_DETAIL_PAGE, fullName);
		return isElementIsDisplay(driver, EmployeeDetailPageUI.FULLNAME_HEADER_TEXT_AT_PERSONAL_DETAIL_PAGE, fullName);
	}

	public String getFirstNameValueAtPersonalDetailForm() {
		waitForElementClickable(driver, EmployeeDetailPageUI.FIRST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
		return getElementText(driver, EmployeeDetailPageUI.FIRST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE, "value");
	}

	public String getLastNameValueAtPersonalDetailForm() {
		waitForElementClickable(driver, EmployeeDetailPageUI.LAST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
		return getElementText(driver, EmployeeDetailPageUI.LAST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE, "value");
	}

	public String getEmployeeIDValueAtPersonalDetailForm() {
		waitForElementClickable(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
		return getElementText(driver, EmployeeDetailPageUI.LAST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE, "value");
	}

	public void clickToButtonByFormNameHeader(WebDriver driver, String headerName, String buttonName) {
		waitForElementClickable(driver, EmployeeDetailPageUI.DYNAMIC_BUTTON_AT_QUALIFICATION_PAGE, headerName,
				buttonName);
		clickToElement(driver, EmployeeDetailPageUI.DYNAMIC_BUTTON_AT_QUALIFICATION_PAGE, headerName, buttonName);

	}

	public void enterToFirstNameTextBoxAtPersonalDetailForm(String firstName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
		enterToTextboxByID(driver, EmployeeDetailPageUI.FIRST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE, firstName);
	}

	public void enterToLastNameTextBoxAtPersonalDetailForm(String lastName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LAST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
		enterToTextboxByID(driver, EmployeeDetailPageUI.LAST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE, lastName);
	}

	public void enterToDriverLicenseNumberTextBoxAtPersonalDetailForm(String driverLicenseNumber) {
		waitForElementVisible(driver, EmployeeDetailPageUI.DRIVER_LINCENSE_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
		enterToTextboxByID(driver, EmployeeDetailPageUI.DRIVER_LINCENSE_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE,
				driverLicenseNumber);
	}

	public void enterToLicenseExpiryDateTextBoxAtPersonalDetailForm(String licenseExpiryDate) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LINCESE_EXPIRY_DATE_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
		enterToTextboxByID(driver, EmployeeDetailPageUI.LINCESE_EXPIRY_DATE_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE,
				licenseExpiryDate);
	}

	public void selectDataForNationalityDropdownAtPersonalDetailForm(String nationality) {
		waitForElementVisible(driver, EmployeeDetailPageUI.NATIONALITY_DROP_DOWN_AT_PERSONAL_DETAIL_PAGE);
		selectItemInDefaultDropDown(driver, EmployeeDetailPageUI.NATIONALITY_DROP_DOWN_AT_PERSONAL_DETAIL_PAGE, nationality);
	}

	public void selectDataForMarrialStatusDropdownAtPersonalDetailForm(String maritalStatus) {
		waitForElementVisible(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROP_DOWN_AT_PERSONAL_DETAIL_PAGE);
		selectItemInDefaultDropDown(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROP_DOWN_AT_PERSONAL_DETAIL_PAGE,
				maritalStatus);

	}

	public void clickToGenderRadioButtonAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.MALE_GENDER_RADIO_BUTTON_AT_PERSONAL_DETAIL_PAGE);
		checkToCheckBoxRadio(driver, EmployeeDetailPageUI.MALE_GENDER_RADIO_BUTTON_AT_PERSONAL_DETAIL_PAGE);
	}

	public void enterToDateOfBirthTextBoxAtPersonalDetailForm(String dob) {
		waitForElementVisible(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
		enterToTextboxByID(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE, dob);
	}

	public String getFistNameAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
		return getElementText(driver, EmployeeDetailPageUI.FIRST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
	}

	public String getSuccessMessageAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.SUCCESS_MESSAGE_AT_PERSONAL_DETAIL_PAGE);
		return getElementText(driver, EmployeeDetailPageUI.SUCCESS_MESSAGE_AT_PERSONAL_DETAIL_PAGE);
	}

	public String getLastNameAtPersonalDetailForm() {
		waitForElementClickable(driver, EmployeeDetailPageUI.LAST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
		return getElementText(driver, EmployeeDetailPageUI.LAST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
	}

	public String getDriverLincenseNumberAtPersonalDetailForm() {
		waitForElementClickable(driver, EmployeeDetailPageUI.DRIVER_LINCENSE_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
		return getElementText(driver, EmployeeDetailPageUI.DRIVER_LINCENSE_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
	}

	public String getLicenseExpiryDateAtPersonalDetailForm() {
		waitForElementClickable(driver, EmployeeDetailPageUI.LINCESE_EXPIRY_DATE_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
		return getElementText(driver, EmployeeDetailPageUI.LINCESE_EXPIRY_DATE_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
	}

	public String getSelectedItemOfNaitonalityDropDownAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.NATIONALITY_DROP_DOWN_AT_PERSONAL_DETAIL_PAGE);
		return getFirstSelectedItemInDefaultDropDown(driver, EmployeeDetailPageUI.NATIONALITY_DROP_DOWN_AT_PERSONAL_DETAIL_PAGE);
	}

	public String getSelectedItemOfMarrialStatusDropDownAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROP_DOWN_AT_PERSONAL_DETAIL_PAGE);
		return getFirstSelectedItemInDefaultDropDown(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROP_DOWN_AT_PERSONAL_DETAIL_PAGE);
	}

	public String getDOBDateAtPersonalDetailFormAtPersonalDetailForm() {
		waitForElementClickable(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
		return getElementText(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE, "value");
	}

	public boolean isGenderRadioButtonSelectedAtPersonalDetailForm(String genderValue) {
		waitForElementVisible(driver, EmployeeDetailPageUI.MALE_GENDER_RADIO_BUTTON_AT_PERSONAL_DETAIL_PAGE, genderValue);
		return isElementIsSelected(driver, EmployeeDetailPageUI.MALE_GENDER_RADIO_BUTTON_AT_PERSONAL_DETAIL_PAGE, genderValue);
	}

}
