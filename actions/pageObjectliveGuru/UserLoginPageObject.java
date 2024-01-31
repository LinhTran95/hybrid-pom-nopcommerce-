package pageObjectliveGuru;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class UserLoginPageObject  extends BasePage {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
