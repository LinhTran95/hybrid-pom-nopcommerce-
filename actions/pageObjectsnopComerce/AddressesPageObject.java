package pageObjectsnopComerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsNopcomerce.AddressesPageUIs;
import pageUIsNopcomerce.HomePageUI;
import pageUIsNopcomerce.RewardPageUIs;

public class AddressesPageObject extends common.BasePage {
	 WebDriver driver;

	public AddressesPageObject(WebDriver _driver) {
		driver = _driver;
	}

	/*
	 * public CustomerInforPageObject openCustomerInforPage() {
	 * waitForElementClickable(driver, AddressesPageUIs.CUSTOMER_INFOR_PAGE_LINK);
	 * clickToElement(driver, AddressesPageUIs.CUSTOMER_INFOR_PAGE_LINK); return
	 * PageGenerator.getCustomerInforPage(driver); }
	 */
}
