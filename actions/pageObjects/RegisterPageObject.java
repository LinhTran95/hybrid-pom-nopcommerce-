package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public void clikToGenderMaleRadio() {
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
	}

	public void enterToFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);

	}

	public void selectDayDropDrown(String day) {
		waitForElementVisible(driver, RegisterPageUI.DAY_DROPDROWN);
		selectItemInDefaultDropDown(driver, RegisterPageUI.DAY_DROPDROWN, day);
	}

	public void enterToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);

	}

	public void selectYearDropDrown(String year) {
		waitForElementVisible(driver, RegisterPageUI.YEAR_DROPDROWN);
		selectItemInDefaultDropDown(driver, RegisterPageUI.YEAR_DROPDROWN, year);

	}

	public void selectMonthDropDrown(String month) {
		waitForElementVisible(driver, RegisterPageUI.MONTH_DROPDROWN);
		selectItemInDefaultDropDown(driver, RegisterPageUI.MONTH_DROPDROWN, month);

	}

	public void enterToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	public void enterToCompanyNameTextBox(String companyName) {
		waitForElementVisible(driver, RegisterPageUI.COMPANYNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.COMPANYNAME_TEXTBOX, companyName);

	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);

	}

	public void enterToPasswordConfirmeTextBox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);

	}

	public void clickRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	public boolean isRegisterSuccessMessageDisplay() {
		waitForElementVisible(driver, RegisterPageUI.REGISTERED_SUCCESS_MESSAGE);

		return isElementIsDisplay(driver, RegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
	}

	public void clickLogOutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);

	}

}
