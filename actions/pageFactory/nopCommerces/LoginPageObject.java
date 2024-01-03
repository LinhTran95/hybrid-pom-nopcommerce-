package pageFactory.nopCommerces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;
	

	public LoginPageObject(WebDriver _driver ){
		super(_driver);
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	@FindBy (how = How.ID, using = "Email")
	private WebElement emailTextbox;
	
	@FindBy (how = How.ID, using = "Password")
	private WebElement passwordTextbox;
	
	@FindBy (how = How.XPATH, using = "//button[text()='Log in']")
	private WebElement loginButton;
	
	public void enterToEmailTextBox(String emailAddress) {
		waitForElementVisible(emailTextbox);
		sendKeyToElement(emailTextbox, emailAddress);
		
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(passwordTextbox);
		sendKeyToElement(passwordTextbox, password);
		
	}

	public void clickToLoginButton() {
		waitForElementClickable(loginButton);
		clickToElement(loginButton);
		
	}
}
