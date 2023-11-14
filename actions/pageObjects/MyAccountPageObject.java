package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.MyAccountPageUI;

public class MyAccountPageObject extends BasePage{
	private WebDriver driver;

	public MyAccountPageObject (WebDriver _driver ){
		this.driver = _driver;
	}

	public boolean isGenderMaleRadioSelected() {
		waitForElementVisible(driver,MyAccountPageUI.GENDER_MALE_RADIO);
		
		return isElementIsSelected(driver, MyAccountPageUI.GENDER_MALE_RADIO);
	}

	public String getFirtNameTextBoxValue() {
		waitForElementVisible(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextBoxValue() {
		waitForElementVisible(driver, MyAccountPageUI.LASTNAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getEmailTextBoxValue() {
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyNameTextBoxValue() {
		waitForElementVisible(driver, MyAccountPageUI.COMPANYNAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.COMPANYNAME_TEXTBOX, "value");
	}
	public String getDateDropDrownValue() {
		waitForElementVisible(driver, MyAccountPageUI.DAY_DROPDROWN);
		return getFirstSelectedItemInDefaultDropDown(driver, MyAccountPageUI.DAY_DROPDROWN);
	}

	public String getMonthDropDrownValue() {
		waitForElementVisible(driver, MyAccountPageUI.MONTH_DROPDROWN);
		return getFirstSelectedItemInDefaultDropDown(driver, MyAccountPageUI.MONTH_DROPDROWN);
	}

	public String getYearDropDrownValue() {
		waitForElementVisible(driver, MyAccountPageUI.YEAR_DROPDROWN);
		return getFirstSelectedItemInDefaultDropDown(driver, MyAccountPageUI.YEAR_DROPDROWN);
	}

}
