package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.orangehrm.EmployeeListPageUI;



public class EmployeeListPageObject extends BasePage{
	WebDriver driver;

	public EmployeeListPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public EmployeeDetailPageObject clickToAddButton() {
		waitForElementClickable(driver, EmployeeListPageUI.ADD_BUTTON);
		clickToElement(driver, EmployeeListPageUI.ADD_BUTTON);
		return PageGeneraterManager.getEmployeeDetailPage(driver);
	}
	

}
