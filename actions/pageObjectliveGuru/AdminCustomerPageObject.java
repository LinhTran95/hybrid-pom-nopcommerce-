package pageObjectliveGuru;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class AdminCustomerPageObject  extends BasePage {
	WebDriver driver;

	public AdminCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLoadingIconDisappear() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isUserInfoDisplayInTable(String string) {
		// TODO Auto-generated method stub
		return false;
	}

}
