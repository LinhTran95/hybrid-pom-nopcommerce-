package pageObjectjQuery;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIsjQuery.UploadPageUI;

public class UploadPageObject extends BasePage {
	WebDriver driver;

	public UploadPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void uploadFile(String... fileNames) {
		uploadMultipleFiles(driver, UploadPageUI.UPLOAD_FILE, fileNames);
	}

	public boolean isFileNameLoadedSuccess(String fileNames) {
		waitForElementVisible(driver, UploadPageUI.FILE_NAME_LOADED_TEXT, fileNames);
		return isElementIsDisplay(driver, UploadPageUI.FILE_NAME_LOADED_TEXT, fileNames);

	}

	public void clickToStartButtonByFileName(String fileNames) {
		waitForElementClickable(driver, UploadPageUI.START_BUTTON_BY_FILE_NAME, fileNames);
		clickToElement(driver, UploadPageUI.START_BUTTON_BY_FILE_NAME, fileNames);
		sleepInSecond(2);

	}

	public boolean isFileUpLoadedSuccess(String fileNames) {
		waitForElementVisible(driver, UploadPageUI.FILE_NAME_UPLOADED_TEXT, fileNames);
		return isElementIsDisplay(driver, UploadPageUI.FILE_NAME_UPLOADED_TEXT, fileNames);
	}
}
