package pageObjectliveGuru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIsliveGuru.UserHomePageUi;
import pageUIsliveGuru.UserRegisterPageUi;

public class UserRegisterPageObject extends BasePage {
	WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementinvisible(driver, UserRegisterPageUi.FIRST_NAME_TEXTBOX, firstName);
		sendKeyToElement(driver, UserRegisterPageUi.FIRST_NAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementinvisible(driver, UserRegisterPageUi.LAST_NAME_TEXTBOX, lastName);
		sendKeyToElement(driver, UserRegisterPageUi.LAST_NAME_TEXTBOX, lastName);

	}

	public void enterToEmailAddressTextbox(String email) {
		waitForElementinvisible(driver, UserRegisterPageUi.EMAIL_TEXTBOX, email);
		sendKeyToElement(driver, UserRegisterPageUi.EMAIL_TEXTBOX, email);

	}

	public void enterToPasswordTextbox(String password) {
		waitForElementinvisible(driver, UserRegisterPageUi.PASSWORD_TEXTBOX, password);
		sendKeyToElement(driver, UserRegisterPageUi.PASSWORD_TEXTBOX, password);

	}

	public void enterToConfirmTextbox(String password) {
		waitForElementinvisible(driver, UserRegisterPageUi.CONFIRM_PASSWORD_TEXTBOX, password);
		sendKeyToElement(driver, UserRegisterPageUi.CONFIRM_PASSWORD_TEXTBOX, password);

	}

	public UserDashboardPageObject clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUi.REGISTER_BUTTON);
		clickToElement(driver,UserRegisterPageUi.REGISTER_BUTTON);
		return PageGenerator.getUserDashboardPage(driver);
	}

}
