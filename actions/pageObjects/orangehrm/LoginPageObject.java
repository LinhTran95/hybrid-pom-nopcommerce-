package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.orangehrm.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void enterToUserNameTextBox(String username) {
	waitForElementinvisible(driver, LoginPageUI.USER_NAME_TEXT_BOX);
	sendKeyToElement(driver, LoginPageUI.USER_NAME_TEXT_BOX, username);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementinvisible(driver, LoginPageUI.PASSWORD_TEXT_BOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXT_BOX, password);
	}

	public DashboardPageObject ClicktoLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneraterManager.getDashboardPage(driver);
	}
	

}
