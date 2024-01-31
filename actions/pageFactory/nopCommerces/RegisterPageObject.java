package pageFactory.nopCommerces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pageUIsNopcomerce.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory{
	private WebDriver driver;

	public RegisterPageObject(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
		@CacheLookup
		@FindBy(id = "gender-male")
		private WebElement genderMaleRadio;

		@CacheLookup
		@FindBy(id = "FirstName")
		private WebElement fisrtNameTextbox;

		@CacheLookup
		@FindBy(id = "LastName")
		private WebElement lastNameTextbox;

		@CacheLookup
		@FindBy(name = "DateOfBirthDay")
		private WebElement dayDropdown;

		@CacheLookup
		@FindBy(name = "DateOfBirthMonth")
		private WebElement monthDropdown;

		@CacheLookup
		@FindBy(name = "DateOfBirthYear")
		private WebElement yearDropdown;

		@CacheLookup
		@FindBy(id = "Email")
		private WebElement emailTextbox;

		@CacheLookup
		@FindBy(id= "Company")
		private WebElement companyTextbox;
		
		@CacheLookup
		@FindBy(id = "Password")
		private WebElement passwordTextbox;

		@CacheLookup
		@FindBy(id = "ConfirmPassword")
		private WebElement confirmPasswordTextbox;

		@CacheLookup
		@FindBy(id = "register-button")
		private WebElement registerButton;
		
		@CacheLookup
		@FindBy(xpath = "//div[@class='result' and text()='Your registration completed']")
		private WebElement registerSuccessMessage;
		
		@CacheLookup
		@FindBy(xpath = "//a[@class='ico-logout']")
		private WebElement logoutLink;
		
		public void clikToGenderMaleRadio() {
			waitForElementClickable(genderMaleRadio);
			clickToElement(genderMaleRadio);
		}

		public void enterToFirstNameTextBox(String firstName) {
			waitForElementVisible(fisrtNameTextbox);
			sendKeyToElement(fisrtNameTextbox,firstName);

		}

		public void selectDayDropDrown(String day) {
			waitForElementVisible(dayDropdown);
			selectItemInDefaultDropDown(dayDropdown ,day);
		}

		public void enterToLastNameTextBox(String lastName) {
			waitForElementVisible(lastNameTextbox);
			sendKeyToElement(lastNameTextbox,lastName);

		}

		public void selectYearDropDrown(String year) {
			waitForElementVisible(yearDropdown);
			selectItemInDefaultDropDown(yearDropdown, year);

		}

		public void selectMonthDropDrown(String month) {
			waitForElementVisible(monthDropdown);
			selectItemInDefaultDropDown(monthDropdown, month);

		}

		public void enterToEmailTextBox(String emailAddress) {
			waitForElementVisible(emailTextbox);
			sendKeyToElement(emailTextbox,emailAddress);

		}

		public void enterToCompanyNameTextBox(String companyName) {
			waitForElementVisible(companyTextbox);
			sendKeyToElement(companyTextbox,companyName);

		}

		public void enterToPasswordTextBox(String password) {
			waitForElementVisible(passwordTextbox);
			sendKeyToElement(passwordTextbox, password);

		}

		public void enterToPasswordConfirmeTextBox(String password) {
			waitForElementVisible(passwordTextbox);
			sendKeyToElement(passwordTextbox, password);

		}

		public void clickRegisterButton() {
			waitForElementClickable(registerButton);
			clickToElement(registerButton);

		}

		public boolean isRegisterSuccessMessageDisplay() {
			waitForElementVisible(registerSuccessMessage);

			return isElementIsDisplay(registerSuccessMessage);
		}

		public  HomePageObject clickLogOutLink() {
			waitForElementClickable(logoutLink);
			clickToElement(logoutLink);
			return new HomePageObject(driver);

		}

	}


