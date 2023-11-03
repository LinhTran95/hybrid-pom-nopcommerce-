package commons;

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

public class BasePage {
	
	public static BasePage getBasePage() {
		return new BasePage();
	}
	// Action click/ open/ sendkey/ select/.... -> void
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);

	}

	// Verify: getTitle/ getUrl/ text/ attribute/ css/ displayed
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void refreshCurrentPage (WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void forwardToPage (WebDriver driver) {
		driver.navigate().forward();
	}
	
	public Alert waitForAlertPresence (WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		return explicitWait.until(ExpectedConditions.alertIsPresent());		
	}
	public void acceptAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public void sendKeyToAlert(WebDriver driver, String value) {
		alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}
	
	public String getTextInAlert(WebDriver driver, String value) {
		alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}
	public By getByXpath (String locator) {
		return By.xpath(locator);
	}
	
	public WebElement getWebElement (WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	public List<WebElement> getWebElements (WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	
	public void clickToElement (WebDriver driver, String locator) {
		waitForElementClickable(driver, locator).click();
	}
	
	public void sendKeyToElement (WebDriver driver, String locator, String value) {
		getWebElement (driver,locator).clear();
		getWebElement (driver,locator).sendKeys(value);
	}
	
	public void selectItemInDefaultDropDown (WebDriver driver, String locator, String itemtext) {
		select = new Select (getWebElement(driver, locator));
		select.selectByVisibleText(itemtext);
	}
	
	public boolean isDropDownMultiple (WebDriver driver, String locator) {
		select = new Select (getWebElement(driver, locator));
		return select.isMultiple();
	}
	
	public String getFirstSelectedItemInDefaultDropDown (WebDriver driver, String locator) {
		select = new Select (getWebElement(driver, locator));
		return select.getFirstSelectedOption().getText();
		
	}
	
	public void sleepInSecond(long timeOutInSecond) {
		try {
			Thread.sleep(timeOutInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, longTimeOut);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	public String  getAttributeValue (WebDriver driver, String locator, String atributename){
		return getWebElement(driver, locator).getAttribute(atributename);
	}
	
	public String getElementText (WebDriver driver, String locator){
		return getWebElement(driver, locator).getText();
	}
	
	public String getElementCSSValue(WebDriver driver, String locator, String propertyName){
		return getWebElement(driver, locator).getCssValue(propertyName);
	}
	
	public int getElementSize(WebDriver driver, String locator, String propertyName){
		return getWebElements(driver, locator).size();
	}
	
	public void checkToCheckBoxRadio (WebDriver driver, String locator) {
		if (!getWebElement(driver, locator).isSelected()) {
			waitForElementClickable(driver, locator).click();
		}
	}
	
	public void uncheckToCheckBoxRadio (WebDriver driver, String locator) {
		if (getWebElement(driver, locator).isSelected()) {
			waitForElementClickable(driver, locator).click();
		}
	}
	public boolean isElementIsDisplay (WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}
	public void isElementIsEnable (WebDriver driver, String locator) {
		getWebElement(driver, locator).isEnabled();	
	}
	public boolean isElementIsSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}
	public void switchToFrame (WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver, locator));
	}
	public void switchToDèaultpage (WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public void doubleClickToElement (WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getWebElement(driver, locator)).perform();
	}
	public void moveMouseToElement (WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locator)).perform();
	}
	public void rightClickToElement (WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getWebElement(driver, locator)).perform();
	}
	public void dragDropToElement (WebDriver driver, String sourceLocator, String targetLocator ) {
		action = new Actions(driver);
		action.dragAndDrop(getWebElement(driver, sourceLocator),getWebElement(driver, targetLocator)).perform();
	}
	public void sendKeyBoardToElement (WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locator), key).perform();
	}
	public String convertRgbaToHexa (String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	public void uploadToElement (WebDriver driver, String locator, String filePath) {
		getWebElement(driver, locator).sendKeys(filePath);
	}
	public WebElement waitForElementVisible (WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	public WebElement waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		return explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	public boolean waitForElementinvisible (WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	
	
	private WebDriverWait explicitWait;
	private long longTimeOut = 40;
	private Alert alert;
	private Select select;
	private JavascriptExecutor jsExecutor;
	private Actions action;
	
}
