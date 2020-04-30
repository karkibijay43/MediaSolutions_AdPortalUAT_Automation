/*
 * package adPortalManagers;
 * 
 * import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver; import
 * org.testng.annotations.AfterClass; import org.testng.annotations.BeforeClass;
 * import org.testng.annotations.Parameters;
 * 
 * public class TestBaseSetUp {
 * 
 * private WebDriver driver; static String driverPath =
 * "/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/chromedriver";
 * 
 * public WebDriver getDriver() { return driver; }
 * 
 * private void setDriver(String browserType, String SignUpURL) { switch
 * (browserType) { case "chrome": driver = initChromeDriver(SignUpURL); break;
 * case "firefox": driver = initFirefoxDriver(SignUpURL); break; default:
 * System.out.println("browser : " + browserType +
 * " is invalid, Launching Firefox as browser of choice.."); driver =
 * initFirefoxDriver(SignUpURL); } }
 * 
 * private static WebDriver initChromeDriver(String SignUpURL) {
 * System.out.println("Launching google chrome with new profile..");
 * System.setProperty("webdriver.chrome.driver", driverPath +
 * "chromedriver.exe"); WebDriver driver = new ChromeDriver();
 * driver.manage().window().maximize(); driver.navigate().to(SignUpURL); return
 * driver; }
 * 
 * private static WebDriver initFirefoxDriver(String SignUpURL) {
 * System.out.println("Launching Firefox browser.."); WebDriver driver = new
 * FirefoxDriver(); driver.manage().window().maximize();
 * driver.navigate().to(SignUpURL); return driver; }
 * 
 * @Parameters({ "browserType", "SignUpURL" })
 * 
 * @BeforeClass public void initializeTestBaseSetup(String browserType, String
 * SignUpURL) { try { setDriver(browserType, SignUpURL);
 * 
 * } catch (Exception e) { System.out.println("Error....." + e.getStackTrace());
 * } }
 * 
 * @AfterClass public void tearDown() { driver.quit(); } }
 */