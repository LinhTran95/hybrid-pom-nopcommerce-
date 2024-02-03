package pageObjectliveGuru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GlobalConstants;
import pageUIsliveGuru.UserDashboardPageUi;

public class UserDashboardPageObject extends BasePage {
	WebDriver driver;

	public UserDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isUserRegisterSuccessMessageDisplay() {
		waitForElementinvisible(driver, UserDashboardPageUi.USER_REGISTER_SUCCESS_MESSAGE);

		return isElementIsDisplay(driver, UserDashboardPageUi.USER_REGISTER_SUCCESS_MESSAGE);
	}

	public AdminLoginPageObject openAdminLoginPage() {
		openPageUrl(driver, GlobalConstants.ADMIN_URL);
		return PageGenerator.getAdminLoginPage(driver);
	}

}
