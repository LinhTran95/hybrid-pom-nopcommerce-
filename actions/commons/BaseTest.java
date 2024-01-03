package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BaseTest {
	private WebDriver driver;
	
	protected WebDriver getBrowserDriver(String browserName, String url) {
		Browser browser = Browser.valueOf(browesName.toUperCase());
		
		switch (browser) {
		case FIREOX: 
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case CHROME: 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case OPERA: 
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		default:
			throw new RuntimeException("Browser name is not correct");
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	protected int getRandomNumber () {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}



		
																		
		}
//		if (browserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		} else if (browserName.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//			driver = new ChromeDriver();
//		} else if (browserName.equalsIgnoreCase("edge")) {
//			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
//			driver = new EdgeDriver();
//		} else {
//			throw new RuntimeException("Borwser name is not correct!");
//		}
//		switch (browser) {
//		case browser.F:
//			
//			break;
//
//		default:
//			break;
//		}
//
//	}
//}
