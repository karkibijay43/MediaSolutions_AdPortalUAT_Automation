package adPortalUATTestRunner;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import adPortalManagers.WebDriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features = "/Users/p2815492/git/AdPortalUATRepo/MediaSolutions_AdPortalUAT_Automation/src/test/resources/AdPortalUATFeatures/AdPortal_LogIn_001.feature",
		glue = {"adPortalstepdefinitions" 
				
		}, 
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:"
		}, 
		tags = { "@AdPortalLogInDefault" 
				
		},
		monochrome = true

)

public class Adportal_LogIn_004_TestRunner {
	private TestNGCucumberRunner testNGCucumberRunner;
	WebDriver driver;
	WebDriverManager webDriverManager;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		extentProperties.setReportPath("AdPortalRegressionTestReport/AdPortalLogInDefaultReport_" + timeStamp + ".html");
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs cucmber Features", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void testDownClass() throws IOException {
		Reporter.setSystemInfo("OS", "MAC");
		Reporter.setSystemInfo("AUTOMATION", "ADPORTAL");
		Reporter.assignAuthor("Bijay Karki");
		// driver = WebDriverManager.getDriver();
		// driver.close();
		webDriverManager = new WebDriverManager();
		webDriverManager.closeDriver();
	}
}
