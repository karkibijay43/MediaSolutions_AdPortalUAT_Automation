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

import adPortal.extentReporter.TestListener;
import adPortalManagers.WebDriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features = "/Users/p2815492/git/AdPortalUATRepo/MediaSolutions_AdPortalUAT_Automation/src/test/resources/AdPortalUATFeatures", 
		glue = {
				"adPortalUATStepDefinitions" 
		}, 
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:"

		}, 
		tags = { "@AdPortalLogInDefault,@SSULogIn,@DashBoardView,@CreateCampaignDefault,@FAQLink,@ReachIntroPage"

		},
		monochrome = true
)

public class RegressionTestRunner extends TestListener {

	static TestNGCucumberRunner testNGCucumberRunner;
	WebDriver driver;
	WebDriverManager webDriverManager;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		extentProperties.setReportPath(
				"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdportalUAT Automation Test Report/RegressionSuite_Test_Report"
						+ timeStamp + ".html");
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
		Reporter.assignAuthor("Bijay");
		testNGCucumberRunner.finish();
		webDriverManager = new WebDriverManager();
		webDriverManager.closeDriver();
	}

}
