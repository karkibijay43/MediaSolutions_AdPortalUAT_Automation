package adPortalUATStepDefinitions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import adPortalDataProvider.ConfigFileReader;
//import com.aventstack.extentreports.ExtentReports;
import adPortalManagers.PageObjectManager;
import adPortalManagers.WebDriverManager;
import adPortalUtilities.AdPortalScreenShots;
import adportalPageObjects.LogInPage;
import adportalPageObjects.RequestDashBoardPage;
import adportalPageObjects.SignUpPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdPortal_NewCustomerDashboardView_001_StepDefinition {

	WebDriver driver;
	ConfigFileReader configFileReader;
	JavascriptExecutor executor;
	LogInPage logInPage;
	SignUpPage signUpPage;
	RequestDashBoardPage requestDashBoardPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	AdPortalScreenShots adPortalScreenShots;

	@Given("^A new user is on AdPortal UAT sign up page$")
	public void user_Is_On_SignUp_Page() {
		webDriverManager = new WebDriverManager();
		driver = WebDriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		configFileReader = new ConfigFileReader();
		pageObjectManager = new PageObjectManager(driver);
		configFileReader.getApplicationUrl();
		signUpPage = pageObjectManager.getSignUpPage();
		signUpPage.navigateTo_SignUpPage();
	}

	@When("^User enters all required fields$")
	public void enter_DataField() {

		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.enter_FirstName("Media");
		signUpPage.enter_LastName("Solutions");
		signUpPage.enter_BusinessName("Spectrum Reach");
		signUpPage.enter_ZipCode("80111");
		signUpPage.enter_PhoneNumber("1234567890");
		signUpPage.enter_Email("QATestEmail@charter.com");
		signUpPage.enter_ConfirmEmail("QATestEmail@charter.com");
		signUpPage.enter_Password("Spectrum123!");
		signUpPage.eneter_ConfirmPassword("Spectrum123!");
	}

	@Then("^User accepts license agreement and clicks next step$")

	public void read_Accept_LicenseAgreement() throws InterruptedException {
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.click_CheckBox();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.close();
		driver.switchTo().window(tabs.get(0));
		signUpPage.click_nextStep();
		Thread.sleep(22000);
	}

	@Then("^User should be able to see blank dashboard page with no campaigns$")
	public void requestDashBoard_Verification() {
		adPortalScreenShots = new AdPortalScreenShots (driver);
		requestDashBoardPage = pageObjectManager.getRequestDashBoardPage();	
		adPortalScreenShots.takeScreenShotNewDashBoardView();
		//requestDashBoardPage.click_GetStarted();
		//requestDashBoardPage.dashBoardPage_Title_verification();
	}

	
	/*
	 * @Then("^User will be taken to the Reach page$") public void
	 * reachPage_verification() { String expectedTitle = "SPP - Creative Requests";
	 * String actualTitle = driver.getTitle();
	 * System.out.println("The Title this page is:" + " " + actualTitle);
	 * 
	 * if (expectedTitle.equalsIgnoreCase(actualTitle)) {
	 * System.out.println("You have landed on the reach page"); } else {
	 * System.out.println("This is not a reach page"); }
	 * 
	 * }
	 */

}
