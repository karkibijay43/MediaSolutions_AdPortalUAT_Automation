package adPortalUATTestRunner;

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
		features = "/Users/p2815492/git/AdPortalUATRepo/MediaSolutions_AdPortalUAT_Automation/src/test/resources/AdPortalUATFeatures/AdPortal_NewUser_FAQ_link_Functionality.feature",
		glue = {
				"adPortalUATStepDefinitions" 
		}, 
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:"
		}, 
		tags = { "@FAQLink"

		},

		monochrome = true
)

public class AdPortal_NewUser_FAQ_link_Functionality_TestRunner {
	WebDriver driver;
	WebDriverManager webDriverManager;

	static TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		extentProperties.setReportPath(
				"AdPortalRegressionTestReport/AdPortal_NewUser_FAQ_link_Functionality_" + timeStamp + ".html");
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
	public void testDownClass() {
		Reporter.setSystemInfo("OS", "MAC");
		Reporter.setSystemInfo("AUTOMATION", "ADPORTAL");
		Reporter.assignAuthor("Bijay Karki");
		testNGCucumberRunner.finish();
		webDriverManager = new WebDriverManager();
		webDriverManager.closeDriver();
	}

}
