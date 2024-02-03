package pageObjectliveGuru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIsjQuery.HomePageUI;
import pageUIsliveGuru.AdminManageCustomerPageUi;

public class AdminManageCustomerPageObject extends BasePage {
	WebDriver driver;

	public AdminManageCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToTextboxAtColumnName(String columnName, String textboxValue) {
		waitForElementinvisible(driver, AdminManageCustomerPageUi.COLUMN_NAME_POSITION, columnName);
		String columnNamePosition = String
				.valueOf(getElementSize(driver, AdminManageCustomerPageUi.COLUMN_NAME_POSITION, columnName) + 1);
		waitForElementinvisible(driver, AdminManageCustomerPageUi.TEXT_BOX_BY_COLUMN_POSITION, columnNamePosition);
		sendKeyToElement(driver, AdminManageCustomerPageUi.TEXT_BOX_BY_COLUMN_POSITION, textboxValue,
				columnNamePosition);
	}

	public void clickSearchButton() {
		waitForElementClickable(driver, AdminManageCustomerPageUi.SEARCH_BUTTON);
		clickToElement(driver, AdminManageCustomerPageUi.SEARCH_BUTTON);

	}

	public boolean isLoadingIconDisappear() {
		waitForElementinvisible(driver, AdminManageCustomerPageUi.LOADING_ICON);
		return isElementIsDisplay(driver, AdminManageCustomerPageUi.LOADING_ICON);
	}

	public boolean isUserInfoDisplayInTable(String fullName, String email) {
		waitForElementinvisible(driver, AdminManageCustomerPageUi.FULL_NAME_AND_EMAIL_IN_TABLE, fullName, email);
		return isElementIsDisplay(driver, AdminManageCustomerPageUi.FULL_NAME_AND_EMAIL_IN_TABLE, fullName, email);
	}

	public void closePopupWindow() {
		waitForElementVisible(driver, AdminManageCustomerPageUi.POPUP_WINDOW);
		waitForElementClickable(driver, AdminManageCustomerPageUi.POPUP_WINDOW);
		clickToElement(driver, AdminManageCustomerPageUi.POPUP_WINDOW);

	}

}
