package pageObjectjQuery;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
	//Quản lý việc khởi tạo các page objetc class
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static UploadPageObject getUploadPage(WebDriver driver) {
		return new UploadPageObject(driver);
	}

}
