package pageFactory.nopCommerces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUIs.HomePageUI;

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
	public void clickToRegisterLink() {
		waitForElementClickable(registerLink);
		clickToElement(registerLink);
	}

	public void clickToLoginLink() {
		waitForElementClickable(loginLink);
		clickToElement(loginLink);
	}

	public void clickToMyAccountLink() {
		waitForElementClickable(myAccountLink);
		clickToElement(myAccountLink);

	}

}
