
package common;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("uer.dir");
	
	protected WebDriver getBrowserDriver(String browserName, String url) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		
		switch (browser) {
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver",projectPath + "\\browserDrivers\\geckodriver.exe" );
			driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty("webdriver.gecko.driver",projectPath + "\\browserDrivers\\chromedriver.exe" );
			driver = new ChromeDriver();
			break;
		case OPERA:
			System.setProperty("webdriver.gecko.driver",projectPath + "\\browserDrivers\\operadriver.exe" );
			driver = new OperaDriver();
			break;
			default:
				throw new RuntimeException("Browser name is not correct!");
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
}

	