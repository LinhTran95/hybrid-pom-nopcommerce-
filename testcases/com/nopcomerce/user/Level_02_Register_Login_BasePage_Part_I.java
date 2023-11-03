package com.nopcomerce.user;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;


public class Level_02_Register_Login_BasePage_Part_I {
	WebDriver driver;
	BasePage basePage;
	Select select;
	String projectPath = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
		driver = new ChromeDriver();
		basePage = new BasePage();
		
		basePage.checkToCheckBoxRadio(driver, "https://www.nopcommerce.com/en/demo");

		
		firstName= "Automation";
		lastName ="FC";
		day ="10";
		month= "10";
		year= "2023";
		emailAddress ="Automationfc" + getRandomNumber() +"@gmail.com";
		companyName= "Automation";
		password ="123456";
	}

	@Test
	public void TC_01_Register() {
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.checkToCheckBoxRadio(driver, "//input[@id='gender-male']");
		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", lastName);
		basePage.selectItemInDefaultDropDown(driver, "//select[@name='DateOfBirthDay']", day);
		basePage.selectItemInDefaultDropDown(driver, "//select[@name='DateOfBirthMonth']", month);
		basePage.selectItemInDefaultDropDown(driver, "//select[@name='DateOfBirthYear']", year);
		basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendKeyToElement(driver, "//input[@id='Company']", companyName);
			
		basePage.checkToCheckBoxRadio(driver, "//input[@id='Newsletter']");
		
		basePage.sendKeyToElement(driver, "//input[@id='Password']", password);
		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);
		
		basePage.clickToElement(driver, "//input[@id='register-button']");
	
		
		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"),"Your registration completed");
		basePage.clickToElement(driver, "//a[@class='ico-logout']");

	}

	@Test
	public void TC_02_Login() {
		basePage.clickToElement(driver, "//a[@class='ico-login']");
		
		basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendKeyToElement(driver, "//input[@id='Company']", companyName);
		basePage.clickToElement(driver, "//button[text()='Log in']");
		
		Assert.assertTrue(basePage.isElementIsDisplay(driver, "//a[@class='ico-account']"));
		
		Assert.assertTrue(basePage.isElementIsDisplay(driver, "//a[@class='ico-logout']"));
	}

	@Test
	public void TC_03_My_Account() {
		basePage.clickToElement(driver, "//a[@class='ico-account']");
		
		Assert.assertEquals(basePage.getElementText(driver, "//h1"), "My account - Customer info");
		Assert.assertTrue(basePage.isElementIsSelected(driver, "//input[@id='gender-male']"));
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='LastName']", "value"), lastName );
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='FirstName']", "value"), firstName );
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='Email']", "value"), emailAddress );
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='Company']", "value"), companyName );
		
		
		Assert.assertEquals(basePage.getFirstSelectedItemInDefaultDropDown(driver, "//select[@name='DateOfBirthDay']"),day);
		Assert.assertEquals(basePage.getFirstSelectedItemInDefaultDropDown(driver, "//select[@name='DateOfBirthMonth']"),month);
		Assert.assertEquals(basePage.getFirstSelectedItemInDefaultDropDown(driver, "//select[@name='DateOfBirthYear']"),year);

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
