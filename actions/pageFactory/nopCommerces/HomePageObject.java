package pageFactory.nopCommerces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUIsNopcomerce.HomePageUI;

public class HomePageObject extends BasePageFactory {
	WebDriver driver;
	WebDriverWait explicitWait;

	public HomePageObject(WebDriver _driver) {
		super(_driver);
		driver = _driver;
		explicitWait = new WebDriverWait(driver, 30);

		// Init element
		PageFactory.initElements(driver, this);
	}

	// Page UI: Locator
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;

	@FindBy(how = How.XPATH, using = "//a[@class='ico-login']")
	private WebElement loginLink;

	@FindBy(how = How.XPATH, using = "//a[@class='ico-account']")
	private WebElement myAccountLink;

	// Page Object: Action
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(registerLink);
		clickToElement(registerLink);
		return new RegisterPageObject(driver);

	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(loginLink);
		clickToElement(loginLink);
		return new LoginPageObject(driver);
	}

	public void clickToMyAccountLink() {
		waitForElementClickable(myAccountLink);
		clickToElement(myAccountLink);

	}

}
