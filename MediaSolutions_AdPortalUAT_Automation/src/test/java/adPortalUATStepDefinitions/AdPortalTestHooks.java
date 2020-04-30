package adPortalUATStepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import com.cucumber.listener.Reporter;
import adPortalManagers.WebDriverManager;
import adPortalUtilities.AdPortalScreenShots;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class AdPortalTestHooks{
//extends WebDriverManager
	WebDriver driver;
	AdPortalScreenShots adPortalScreenShots;
	WebDriverManager webDriverManager;	
//	public TestHooks() {
//		this.driver = super.getDriver();
//	}

	@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println("Started execution for the scenario : " + scenario.getName());
	}

	@Before("@AdPortalLogInDefault")
	public void AdPortalLogInDefault(Scenario scenario) {

		System.out.println("=========================================");
		System.out.println("Executing before AdPortalLogInDefault");
		System.out.println("=========================================");
	}

	@Before("@AdPortalLogInUserInPut")
	public void AdPortalLogInUserInPut(Scenario scenario) {

		System.out.println("=========================================");
		System.out.println("Executing before AdPortalLogInUserInPut");
		System.out.println("=========================================");
	}

	@Before("@SSULogIn")
	public void SSULogIn(Scenario scenario) {

		System.out.println("=========================================");
		System.out.println("Executing before SSULogIn");
		System.out.println("=========================================");
	}

	@Before("@CreateCampaignDefault")
	public void CreateCampaignDefault(Scenario scenario) {

		System.out.println("=========================================");
		System.out.println("Executing before CreateCampaignDefault");
		System.out.println("=========================================");
	}

	@Before("@CreateCampaigUserInPut")
	public void CreateCampaignUserInPut(Scenario scenario) {

		System.out.println("=========================================");
		System.out.println("Executing before CreateCampaignUserInPut");
		System.out.println("=========================================");
	}

	@Before("@DashBoardView")
	public void DashBoardView(Scenario scenario) {

		System.out.println("=========================================");
		System.out.println("Executing before DashBoardView");
		System.out.println("=========================================");
	}
	
	@Before("@FAQLink")
	public void faq_Link_Functionality(Scenario scenario) {

		System.out.println("=========================================");
		System.out.println("Executing before FAQ_Link_Functionality");
		System.out.println("=========================================");
	}
	@Before("@ReachIntroPage")
	public void reach_Intro_Page (Scenario scenario) {

		System.out.println("=========================================");
		System.out.println("Executing before Reach_Intro_Page");
		System.out.println("=========================================");
	}
	
	@Before("@UploadYourCommercial")
	public void upload_Your_Commercial (Scenario scenario) {

		System.out.println("=========================================");
		System.out.println("Executing before upload_Your_Commercial");
		System.out.println("=========================================");
	}
	
	@After()
	public void afterScenario(Scenario scenario) throws IOException {
		System.out.println("Completed execution for the scenario :" + scenario.getName());
		System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
		 webDriverManager = new WebDriverManager(); 
		 driver = WebDriverManager.getDriver();
		 //if (scenario.isFailed()) 
		try {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			File screenshot_with_scenario_name = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot_with_scenario_name,
			new File("/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdPortalUAT Test Result Screenshots/"+ scenario.getName() + ".png"));
			System.out.println(scenario.getName());
			scenario.embed(screenshot, "image/png");
			  Reporter.setSystemInfo("OS", "MAC"); 
			  Reporter.setSystemInfo("AUTOMATION", "ADPORTAL UAT"); 
			  Reporter.assignAuthor("Bijay Karki");
			Reporter.addScreenCaptureFromPath("/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdPortalUAT Test Result Screenshots/"+ scenario.getName() + ".png");
		} 
		catch 
		(WebDriverException somePlatformsDontSupportScreenshots) {
			System.err.println(somePlatformsDontSupportScreenshots.getMessage());
		}
	}
		
}
	


