package com.jquery;

import static org.testng.Assert.assertTrue;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjectjQuery.PageGenerator;
import pageObjectjQuery.HomePageObject;

public class Level_09_DataTable extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		homePage = PageGenerator.getHomePage(driver);
	}

	@Test
	public void TC_01_DataTable() {
		// Phân trang-> chuyển trang xong phải verify là trang đã chuyển thành công
		homePage.openPagingPageByName("3");
		Assert.assertTrue(homePage.isPageActiveByName("3"));

		homePage.openPagingPageByName("10");
		Assert.assertTrue(homePage.isPageActiveByName("10"));

		homePage.openPagingPageByName("2");
		Assert.assertTrue(homePage.isPageActiveByName("2"));

		homePage.openPagingPageByName("12");
		Assert.assertTrue(homePage.isPageActiveByName("12"));
	}

	@Test
	public void TC_02_Search() {
		// Search trong header: nhập liệu vào textbox trong header
		homePage.enterToHeaderTextBoxByName("Country","Guinea");
		homePage.enterToHeaderTextBoxByName("Females","19530");
		homePage.enterToHeaderTextBoxByName("Males","1561");
		homePage.enterToHeaderTextBoxByName("Total","39046");
	}

	@Test
	public void TC_03_Verify_Row() {
		// Verify dữ liệu của 1 row bất kỳ
		homePage.enterToHeaderTextBoxByName("Country","Guinea-Bissau");
		homePage.enterToHeaderTextBoxByName("Females","19530");
		homePage.enterToHeaderTextBoxByName("Males","19516");
		homePage.enterToHeaderTextBoxByName("Total","39046");
		Assert.assertTrue(homePage.isRowValueDisplay("","","",""));
	}


	@Test
	public void TC_04_Action() {
		// click vào icon delete/ edit của 1 row
		homePage.clickToRowActionByCountry("Aruba","remove");
		homePage.clickToRowActionByCountry("Afghanistan","remove");
		homePage.clickToRowActionByCountry("Algeria","remove");
		homePage.clickToRowActionByCountry("Armenia","remove");
	}
	public void TC_05_Edittable() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		//Enter text vào cột nào (tên) dòng thứ mấy (cột Contact person dòng thứ 2)
		//Từ Contact Person phải lấy ra dc index của cột tương ứng 
		//Vẫn lầy dc index nếu vị trí cột chuyển qua trái/ phải 
		homePage.enterToTextBoxAtColumnNameAndRowNumber("Contact Person","3","IDK");
		homePage.enterToTextBoxAtColumnNameAndRowNumber("Company","5","HMMMM");
		homePage.enterToTextBoxAtColumnNameAndRowNumber("Order Placed","7","GUESS");
		
		//Chọn giá trị trong dropdown tại bất kì cột ở bất kì dòng nào 
		homePage.selectDropDownAtColumnNameAndRowNumber("Country","2","Taiwan");
		homePage.selectDropDownAtColumnNameAndRowNumber("Country","4","Japan");
		homePage.selectDropDownAtColumnNameAndRowNumber("Country","1","Germany");
		
		homePage.clickToIconAtRowNumber("1","Insert");
		homePage.clickToIconAtRowNumber("2","Up");
		homePage.clickToIconAtRowNumber("3","Down");
		homePage.clickToIconAtRowNumber("1","Insert");
		homePage.clickToIconAtRowNumber("1","Remove");

	}

	@AfterClass
	public void afterClass() {

		driver.quit();

	}

	public int getRandomNumber() {
		Random ran = new Random();
		return ran.nextInt(9999);
	}

}
