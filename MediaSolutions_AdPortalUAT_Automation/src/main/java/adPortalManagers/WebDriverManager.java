
package adPortalManagers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import adPortalEnums.DriverTtype;
import adPortalEnums.EnvironMentType;

public class WebDriverManager {
	
	public static WebDriver driver;
	//private WebDriver driver;
	//protected WebDriver driver;
	private static DriverTtype driverType;
	private static EnvironMentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public static  WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private static WebDriver createDriver() {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	private static WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private static WebDriver createLocalDriver() {
		switch (driverType) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY,
					FileReaderManager.getInstance().getConfigReader().getDriverPath());
			driver = new ChromeDriver();
			break;
		case IE:
			driver = new InternetExplorerDriver();
			break;
		case SAFARI:
			driver = new SafariDriver();
			break;
		}

		if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
				TimeUnit.SECONDS);
		return driver;
	}

	public  void closeDriver() {
		driver.close();
		//driver.quit();
	}
}
