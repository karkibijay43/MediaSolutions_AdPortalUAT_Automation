package adPortalUATStepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import adPortalDataProvider.ConfigFileReader;
import adPortalManagers.PageObjectManager;
import adPortalManagers.WebDriverManager;
import adPortalUtilities.AdPortalScreenShots;
import adportalPageObjects.LogInPage;
import adportalPageObjects.ReachPage;
import adportalPageObjects.RequestDashBoardPage;
import adportalPageObjects.SignUpPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdPortal_Reach_Intro_Page_StepDefinition {
	WebDriver driver;
	ConfigFileReader configFileReader;
	JavascriptExecutor executor;
	LogInPage logInPage;
	SignUpPage signUpPage;
	RequestDashBoardPage requestDashBoardPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	AdPortalScreenShots adPortalScreenShots;

	@Given("^User is logged into Ad Portal$")
	public void log_In_To_AdPortal() {
		webDriverManager = new WebDriverManager();
		driver = WebDriverManager.getDriver();
		configFileReader = new ConfigFileReader();
		pageObjectManager = new PageObjectManager(driver);
		signUpPage = pageObjectManager.getSignUpPage();
		signUpPage.navigateTo_SignUpPage();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("SignUp Page is still loading");
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		signUpPage.explicitly_Wait_ForLogInLink();
		signUpPage.click_Login();
		logInPage = new LogInPage(driver);
		logInPage.enter_LogInEmail("c-bijay.karki@charter.com");
		logInPage.enter_LogInPassword("Spectrum123!");
		logInPage.clickLogIn();
	}

	@When("^User is on the request dashBoard with drafts page$")
	public void verify_RequestDashBoard() {
		requestDashBoardPage = new RequestDashBoardPage(driver);
		requestDashBoardPage.explicitly_Wait_For_ContinueButton();
		requestDashBoardPage.request_DashBoardPage_With_Drafts_verification();
	}

	@Then("^User starts or continues with campaign$")
	public void start_Campaign() {
		requestDashBoardPage = new RequestDashBoardPage(driver);
		requestDashBoardPage.get_Started_Or_ContinueCamapaign();
	}

	@Then("^USer should land on intro step of the reach page$")
	public void reach_Intro_Page_Verification() {
		ReachPage reachPage = new ReachPage(driver);
		reachPage.verify_Reach_Intro_Page_Title();

	}

	@Then("^User clicks on next button$")
	public void click_ReachPage_NextButton() {
		ReachPage reachPage = new ReachPage(driver);
		reachPage.explicitly_Wait_For_ReachPageNextButton();
		reachPage.click_ReachPageNextButton();
	}

	@Then("^User should be taken to the Reach 1 of 3 page$")
	public void verify_ReachPage_1_Of_3() {
		ReachPage reachPage = new ReachPage(driver);
		reachPage.get_Text_From_ReachPage1();
		adPortalScreenShots = new AdPortalScreenShots(driver);
		adPortalScreenShots.take_ScreenShot_ReachIntroPage();
	}

}
