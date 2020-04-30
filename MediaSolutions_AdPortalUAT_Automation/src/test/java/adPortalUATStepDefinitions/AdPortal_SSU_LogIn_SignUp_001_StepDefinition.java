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

public class AdPortal_SSU_LogIn_SignUp_001_StepDefinition {
	WebDriver driver;
	ConfigFileReader configFileReader;
	JavascriptExecutor executor;
	LogInPage loginPage;
	SignUpPage signUpPage;
	RequestDashBoardPage requestDashBoardPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	AdPortalScreenShots adPortalScreenShots;

	@Given("^User is on AdPortal UAT sign up page$")
	public void user_Is_On_SignUp_Page() throws Throwable {
		webDriverManager = new WebDriverManager();
		driver = WebDriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		configFileReader = new ConfigFileReader();
		pageObjectManager = new PageObjectManager(driver);
		configFileReader.getApplicationUrl();
		signUpPage = pageObjectManager.getSignUpPage();
		signUpPage.navigateTo_SignUpPage();
	}

	@When("^User enters First Name,Last Name,Business Name,Zip Code,Phone Number,Email and Password$")
	public void enter_DataField() {
		signUpPage = pageObjectManager.getSignUpPage();
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

	@Then("^User reads and agrees terms and conditions and clicks next step$")

	public void read_Accept_LicenseAgreement() {
		signUpPage = pageObjectManager.getSignUpPage();
		signUpPage.click_CheckBox();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.close();
		driver.switchTo().window(tabs.get(0));

	}

	@Then("^User should be able to create log in credentials for AdPortal UAT$")
	public void next_Step_LogIn() throws InterruptedException {
		requestDashBoardPage = new RequestDashBoardPage(driver);
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.click_nextStep();
		Thread.sleep(15000);
		//requestDashBoardPage.explicitly_Wait_For_GetStartedButton();
		//requestDashBoardPage.click_GetStarted();
		requestDashBoardPage.new_Request_DashBoard_Verification();
		adPortalScreenShots = new AdPortalScreenShots(driver);
		adPortalScreenShots.takeScreenShotSSU_SignUp();
	
	}
}
