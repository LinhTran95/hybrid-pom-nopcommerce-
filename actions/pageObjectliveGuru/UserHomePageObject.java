package pageObjectliveGuru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIsliveGuru.UserHomePageUi;

public class UserHomePageObject extends BasePage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserLoginPageObject clickToMyAccountPage() {
		waitForElementClickable(driver, UserHomePageUi.MY_ACCOUNT_LINK_AT_FOOTER);
		clickToElement(driver, UserHomePageUi.MY_ACCOUNT_LINK_AT_FOOTER);
		return PageGenerator.getUserLoginPage(driver);
	}
}