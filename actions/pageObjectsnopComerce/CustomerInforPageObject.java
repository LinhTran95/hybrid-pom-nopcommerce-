package pageObjectsnopComerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIsNopcomerce.CustomerInforPageUI;
import pageUIsNopcomerce.RewardPageUIs;

public class CustomerInforPageObject extends BasePage{
	private WebDriver driver;

	public CustomerInforPageObject (WebDriver _driver ){
		this.driver = _driver;
	}

	public boolean isGenderMaleRadioSelected() {
		waitForElementVisible(driver,CustomerInforPageUI.GENDER_MALE_RADIO);
		
		return isElementIsSelected(driver, CustomerInforPageUI.GENDER_MALE_RADIO);
	}

	public String getFirtNameTextBoxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getAttributeValue(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextBoxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.LASTNAME_TEXTBOX);
		return getAttributeValue(driver, CustomerInforPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getEmailTextBoxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, CustomerInforPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyNameTextBoxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.COMPANYNAME_TEXTBOX);
		return getAttributeValue(driver, CustomerInforPageUI.COMPANYNAME_TEXTBOX, "value");
	}
	public String getDateDropDrownValue() {
		waitForElementVisible(driver, CustomerInforPageUI.DAY_DROPDROWN);
		return getFirstSelectedItemInDefaultDropDown(driver, CustomerInforPageUI.DAY_DROPDROWN);
	}

	public String getMonthDropDrownValue() {
		waitForElementVisible(driver, CustomerInforPageUI.MONTH_DROPDROWN);
		return getFirstSelectedItemInDefaultDropDown(driver, CustomerInforPageUI.MONTH_DROPDROWN);
	}

	public String getYearDropDrownValue() {
		waitForElementVisible(driver, CustomerInforPageUI.YEAR_DROPDROWN);
		return getFirstSelectedItemInDefaultDropDown(driver, CustomerInforPageUI.YEAR_DROPDROWN);
	}

	public OrdersPageObject openOrderPage() {
		waitForElementClickable(driver, CustomerInforPageUI.ORDER_PAGE_LINK);
		clickToElement(driver, CustomerInforPageUI.ORDER_PAGE_LINK);
		return PageGenerator.getOrderPage(driver);
	}

	public RewardPointsPageObject openRewardPointsPage() {
		waitForElementClickable(driver, CustomerInforPageUI.REWARD_POINT_PAGE_LINK);
		clickToElement(driver, CustomerInforPageUI.REWARD_POINT_PAGE_LINK);
		return PageGenerator.getRewardPointsPage(driver);
	}

}
