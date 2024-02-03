package pageObjectliveGuru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIsliveGuru.UserLoginPageUi;

public class UserLoginPageObject extends BasePage {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject clickCreateAccountButton() {
		waitForElementClickable(driver, UserLoginPageUi.CREATE_ACCOUNT_BUTTON);
		clickToElement(driver, UserLoginPageUi.CREATE_ACCOUNT_BUTTON);
		return PageGenerator.getUserRegisterPage(driver);
	}

}
