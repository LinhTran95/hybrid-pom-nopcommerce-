package pageObjectsnopComerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsNopcomerce.HomePageUI;
import pageUIsNopcomerce.OrderPageUIs;

public class OrdersPageObject  extends common.BasePage {
	private WebDriver driver;

	public OrdersPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public RewardPointsPageObject openRewardPointsPage() {
		waitForElementClickable(driver, OrderPageUIs.REWARD_POINT_PAGE_LINK);
		clickToElement(driver, OrderPageUIs.REWARD_POINT_PAGE_LINK);
		return PageGenerator.getRewardPointsPage(driver);
	}
}
