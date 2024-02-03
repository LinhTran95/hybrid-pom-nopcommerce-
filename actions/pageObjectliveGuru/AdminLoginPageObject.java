package pageObjectliveGuru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIsliveGuru.AdminLoginPageUi;

public class AdminLoginPageObject  extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserNameTextbox(String userName) {
		waitForElementinvisible(driver, AdminLoginPageUi.USER_NAME_TEXTBOX);
		sendKeyToElement(driver, AdminLoginPageUi.USER_NAME_TEXTBOX, userName);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementinvisible(driver, AdminLoginPageUi.USER_NAME_TEXTBOX);
		sendKeyToElement(driver, AdminLoginPageUi.PASSWORD_TEXTBOX, password);
		
	}

	public AdminManageCustomerPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUi.LOGIN_BUTTON);
		clickToElement(driver,AdminLoginPageUi.LOGIN_BUTTON);
		return PageGenerator.getAdminManageCustomerPage(driver);
	}

}
