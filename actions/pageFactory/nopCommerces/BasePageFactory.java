package pageFactory.nopCommerces;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	private WebDriver driver;

	public BasePageFactory(WebDriver driver) {
		this.driver = driver;
	}

//	public static BasePageFactory getBasePage() {
//		return new BasePageFactory();
//	}

	// Action click/ open/ sendkey/ select/.... -> void
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);

	}

	// Verify: getTitle/ getUrl/ text/ attribute/ css/ displayed
	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode() {
		return driver.getPageSource();
	}

	public void backToPage() {
		driver.navigate().back();
	}

	public void refreshCurrentPage() {
		driver.navigate().refresh();
	}

	public void forwardToPage() {
		driver.navigate().forward();
	}

	public Alert waitForAlertPresence() {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert() {
		alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert() {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void sendKeyToAlert(String value) {
		alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	public String getTextInAlert(String value) {
		alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void switchToWindowByID(String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public void clickToElement(WebElement element) {
		waitForElementClickable(element).click();
	}

	public WebElement waitForElementClickable(WebElement element) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		return explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void sendKeyToElement (WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	public String getElementText (WebElement element){
		return element.getText();
	}
	public boolean isElementIsDisplay (WebElement element) {
		return element.isDisplayed();
	}
	public WebElement waitForElementVisible ( WebElement element) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		return explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	public boolean isElementIsSelected(WebElement element) {
		return element.isSelected();
	}
	public void selectItemInDefaultDropDown (WebElement element, String itemText) {
		select = new Select (element);
		select.selectByVisibleText(itemText);
	}
	public String getFirstSelectedItemInDefaultDropDown (WebElement element) {
		select = new Select (element);
		return select.getFirstSelectedOption().getText();
	}
	public String  getAttributeValue (WebElement element, String atributename){
		return element.getAttribute(atributename);
	}

	private WebDriverWait explicitWait;
	private long longTimeOut = 40;
	private Alert alert;
	private Select select;
	private JavascriptExecutor jsExecutor;
	private Actions action;

}
