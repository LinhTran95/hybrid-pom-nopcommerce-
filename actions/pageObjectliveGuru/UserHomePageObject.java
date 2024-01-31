package pageObjectliveGuru;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class UserHomePageObject  extends BasePage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
}
