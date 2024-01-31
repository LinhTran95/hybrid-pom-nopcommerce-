package pageObjectsnopComerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsNopcomerce.HomePageUI;
import pageUIsNopcomerce.RewardPageUIs;

public class RewardPointsPageObject extends common.BasePage {
	 WebDriver driver;

	public RewardPointsPageObject(WebDriver _driver) {
		driver = _driver;
	}

	/*
	 * public AddressesPageObject openAddressesPage() {
	 * waitForElementClickable(driver, RewardPageUIs.ADDRESSES_PAGE_LINK);
	 * clickToElement(driver, RewardPageUIs.ADDRESSES_PAGE_LINK); return
	 * PageGenerator.getAddressesPage(driver); }
	 */
}
