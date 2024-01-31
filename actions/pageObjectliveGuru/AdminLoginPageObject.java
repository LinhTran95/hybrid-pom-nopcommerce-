package pageObjectliveGuru;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class AdminLoginPageObject  extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
