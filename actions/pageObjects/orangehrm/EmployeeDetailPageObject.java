package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.orangehrm.EmployeeDetailPageUI;

public class EmployeeDetailPageObject extends BasePage {
	WebDriver driver;

	public EmployeeDetailPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRST_NAME_TEXT_BOX_AT_ADD_EMPLOYEE_PAGE);
		enterToTextboxByID(driver, EmployeeDetailPageUI.FIRST_NAME_TEXT_BOX_AT_ADD_EMPLOYEE_PAGE, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
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

	public String isFullNameDisplayAtHeader(String fullName) {
		waitForElementClickable(driver, EmployeeDetailPageUI.FULLNAME_HEADER_TEXT_AT_PERSONAL_DETAIL_PAGE, fullName);
		return getElementText(driver, EmployeeDetailPageUI.FULLNAME_HEADER_TEXT_AT_PERSONAL_DETAIL_PAGE, fullName);
	}

	public String getFirstNameValueAtPersonalDetailForm() {
		waitForElementClickable(driver, EmployeeDetailPageUI.FIRST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
		return getElementText(driver, EmployeeDetailPageUI.FIRST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE,"value");
	}

	public String getLastNameValueAtPersonalDetailForm() {
		waitForElementClickable(driver, EmployeeDetailPageUI.LAST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
		return getElementText(driver, EmployeeDetailPageUI.LAST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE, "value");
	}

	public String getEmployeeIDValueAtPersonalDetailForm() {
		waitForElementClickable(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE);
		return getElementText(driver, EmployeeDetailPageUI.LAST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE, "value");
	}

}
