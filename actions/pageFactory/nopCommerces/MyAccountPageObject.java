package pageFactory.nopCommerces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pageUIs.MyAccountPageUI;

public class MyAccountPageObject extends BasePageFactory {
	private WebDriver driver;

	public MyAccountPageObject(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
		PageFactory.initElements(_driver, this);

	}

	@FindBy(how = How.ID, using = "gender-male")
	private WebElement genderMaleRadio;

	@FindBy(how = How.ID, using = "FirstName")
	private WebElement fisrtNameTextbox;

	@FindBy(how = How.ID, using = "LastName")
	private WebElement lastNameTextbox;

	@FindBy(how = How.NAME, using = "DateOfBirthDay")
	private WebElement dayDropdown;

	@FindBy(how = How.NAME, using = "DateOfBirthMonth")
	private WebElement monthDropdown;

	@FindBy(how = How.NAME, using = "DateOfBirthYear")
	private WebElement yearDropdown;

	@FindBy(how = How.ID, using = "Email")
	private WebElement emailTextbox;

	@FindBy(how = How.ID, using = "Company")
	private WebElement companyTextbox;

	public boolean isGenderMaleRadioSelected() {
		waitForElementVisible(genderMaleRadio);

		return isElementIsSelected(genderMaleRadio);
	}

	public String getFirtNameTextBoxValue() {
		waitForElementVisible(fisrtNameTextbox);
		return getAttributeValue(fisrtNameTextbox, "value");
	}

	public String getLastNameTextBoxValue() {
		waitForElementVisible(lastNameTextbox);
		return getAttributeValue(lastNameTextbox, "value");
	}

	public String getEmailTextBoxValue() {
		waitForElementVisible(emailTextbox);
		return getAttributeValue(emailTextbox, "value");
	}

	public String getCompanyNameTextBoxValue() {
		waitForElementVisible(companyTextbox);
		return getAttributeValue(companyTextbox, "value");
	}

	public String getDateDropDrownValue() {
		waitForElementVisible(dayDropdown);
		return getFirstSelectedItemInDefaultDropDown(dayDropdown);
	}

	public String getMonthDropDrownValue() {
		waitForElementVisible(monthDropdown);
		return getFirstSelectedItemInDefaultDropDown(monthDropdown);
	}

	public String getYearDropDrownValue() {
		waitForElementVisible(yearDropdown);
		return getFirstSelectedItemInDefaultDropDown(yearDropdown);
	}

}
