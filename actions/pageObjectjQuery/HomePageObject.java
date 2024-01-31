package pageObjectjQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIsjQuery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingPageByName(String pageName) {
		waitForElementClickable(driver, HomePageUI.PAGING_LINK_BY_NUMBER, pageName);
		clickToElement(driver, HomePageUI.PAGING_LINK_BY_NUMBER, pageName);
	}

	public boolean isPageActiveByName(String pageName) {
		waitForElementinvisible(driver, HomePageUI.PAGING_LINK_ACTIVE_BY_NUMBER, pageName);
		return isElementIsDisplay(driver, HomePageUI.PAGING_LINK_ACTIVE_BY_NUMBER, pageName);
	}

	public void enterToHeaderTextBoxByName(String headerName, String value) {
		waitForElementinvisible(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, headerName);
		sendKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, value, headerName);
		sendKeyBoardToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, Keys.ENTER, headerName);
	}

	public boolean isRowValueDisplay(String female, String country, String male, String total) {
		waitForElementinvisible(driver, HomePageUI.ROW_ALL_VALUES, female, country, male, total);
		return false;
	}

	public void clickToRowActionByCountry(String country, String actionName) {
		waitForElementClickable(driver, HomePageUI.ROW_ACTION_BY_NAME_AND_COUNTRY, country, actionName);
		clickToElement(driver, HomePageUI.ROW_ACTION_BY_NAME_AND_COUNTRY, country, actionName);
		sleepInSecond(2);

	}

	public void enterToTextBoxAtColumnNameAndRowNumber(String columnName, String rowNumber, String textBoxValue) {
		waitForElementinvisible(driver, HomePageUI.COLUMN_NAME_POSITION, columnName);

		// index của cột dựa trên tên cột

		String columnNamePosition = String
				.valueOf(getElementSize(driver, HomePageUI.COLUMN_NAME_POSITION, columnName) + 1);
		waitForElementinvisible(driver, HomePageUI.TEXTBOX_AT_COLUMN_NAME_AND_ROW_NUMBER, rowNumber,
				columnNamePosition);
		sendKeyToElement(driver, HomePageUI.TEXTBOX_AT_COLUMN_NAME_AND_ROW_NUMBER, textBoxValue, rowNumber,
				columnNamePosition);

	}

	public void selectDropDownAtColumnNameAndRowNumber(String columnName, String rowNumber, String dropdownItem) {
		waitForElementClickable(driver, HomePageUI.COLUMN_NAME_POSITION, columnName);
		String columnNamePosition = String
				.valueOf(getElementSize(driver, HomePageUI.COLUMN_NAME_POSITION, columnName) + 1);
		waitForElementClickable(driver, HomePageUI.DROPDOWN_AT_COLUMN_NAME_AND_ROW_NUMBER, rowNumber,
				columnNamePosition);
		selectItemInDefaultDropDown(driver, HomePageUI.DROPDOWN_AT_COLUMN_NAME_AND_ROW_NUMBER, dropdownItem, rowNumber,
				columnNamePosition);
	}

	public void clickToIconAtRowNumber(String rowNumber, String actionName) {
		waitForElementClickable(driver, HomePageUI.ICON_ACTION_AT_ROW, rowNumber, actionName);
		clickToElement(driver, HomePageUI.ICON_ACTION_AT_ROW, actionName);

	}

}
