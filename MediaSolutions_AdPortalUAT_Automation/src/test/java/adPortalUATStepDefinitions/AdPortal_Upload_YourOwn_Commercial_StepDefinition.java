package adPortalUATStepDefinitions;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;

import adPortalDataProvider.ConfigFileReader;
import adPortalManagers.PageObjectManager;
import adPortalManagers.WebDriverManager;
import adPortalUtilities.AdPortalScreenShots;
import adportalPageObjects.CommercialPage;
import adportalPageObjects.LogInPage;
import adportalPageObjects.ReachPage;
import adportalPageObjects.RequestDashBoardPage;
import adportalPageObjects.ReviewOrderPage;
import adportalPageObjects.SchedulePage;
import adportalPageObjects.SignUpPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdPortal_Upload_YourOwn_Commercial_StepDefinition {
	WebDriver driver;
	ConfigFileReader configFileReader;
	JavascriptExecutor executor;
	LogInPage logInPage;
	SignUpPage signUpPage;
	ReachPage reachPage;
	RequestDashBoardPage requestDashBoardPage;
	SchedulePage schedulePage;
	CommercialPage commercialPage;
	ReviewOrderPage reviewOrderPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	ExtentReports extent;
	AdPortalScreenShots adPortalScreenShots;

	@Given("^User is on SignUp page and clicks log in$")
	public void user_Is_On_LogIn_Page() {
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
	}

	@When("^User logs in using email and password$")
	public void enter_UserName_And_Password() {
		logInPage = pageObjectManager.getLogInPage();
		logInPage.enter_LogInEmail("c-bijay.karki@charter.com");
		logInPage.enter_LogInPassword("Spectrum123!");
		logInPage.clickLogIn();
		requestDashBoardPage = new RequestDashBoardPage(driver);
		requestDashBoardPage.explicitly_Wait_For_ContinueButton();
	}

	@Then("^User should land request dashboard page with draft campaign$")

	public void requestDashBoard_Verification() {
		requestDashBoardPage = pageObjectManager.getRequestDashBoardPage();
		requestDashBoardPage.request_DashBoardPage_With_Drafts_verification();
	}

	@Then("^User should be able to continue with the campaign$")

	public void start_Campaign() {
		reachPage = pageObjectManager.getReachPage();
		requestDashBoardPage = pageObjectManager.getRequestDashBoardPage();
		requestDashBoardPage.explicitly_Wait_For_ContinueButton();
		//requestDashBoardPage.continue_Draft();
		requestDashBoardPage.get_Started_Or_ContinueCamapaign();
		reachPage.explicitly_Wait_For_ReachPageNextButton();
		reachPage.click_ReachPageNextButton();
		reachPage.explicitly_Wait_For_RaiseAwarenessButton();
		reachPage.select_RaiseAwareness();
		reachPage.click_ReachPage1NextButton();
	}

	@Then("^User selects the address and distance and clicks next$")
	public void enter_Address_And_Distance() throws InterruptedException {

		reachPage = pageObjectManager.getReachPage();
		reachPage.explicitly_Wait_For_AddressEntry();
		reachPage.enter_Address("Austin");
		reachPage.click_HeaderTtile();
		reachPage.click_DropDownArrow();
		reachPage.clickDistance_JSExecutor();
		reachPage.click_DropDownArrow();
		reachPage.click_ReachPage2NextButton();
		reachPage.click_ReachPage3NextButton();
	}

	@Then("^User should be able to select the dates to schedule a campaign$")
	public void schedule_Campaign() {
		SchedulePage schedulePage = new SchedulePage(driver);
		schedulePage.click_startCalednderArrow();
		schedulePage.click_stopCalenderArrow();
		schedulePage.enter_Budget("1000");
		schedulePage.click_SchedulePage1NextButton();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			System.out.println("The Review campaign couldn't load");
			e.printStackTrace();
		}
	}

	@Then("^User should be able to review the campaign details$")
	public void review_Campaign() {
		schedulePage = new SchedulePage(driver);
		schedulePage.explicitly_Wait_For_ReviewPageNextButton();
		schedulePage.click_SchedulePage2_NextButton();
		schedulePage.enter_CampaignName_Or_Continue_With_Uploading_YourOwn_Commercial("Test campaign");
	}

	@Then("^User should be able to upload their own commercial$")
	public void upload_Your_Own_Commercial() throws InterruptedException, AWTException {
		commercialPage = new CommercialPage(driver);
		commercialPage.click_Here_Link();
		commercialPage.upload_Your_Own_Commercial_Box();
		commercialPage.click_Upload_YourOwnCommercialPage_Next_Button();
	}

	@Then("^User should be able to enter business information and place an order$")
	public void checkout_And_Place_Order() {
		reviewOrderPage = new ReviewOrderPage(driver);
		adPortalScreenShots = new AdPortalScreenShots(driver);
		reviewOrderPage.enter_Credit_Card_FirstNAme("zztestspp");
		reviewOrderPage.enter_Credit_Card_LastName("whatever");
		reviewOrderPage.enter_Credit_Card_Number("1234567890123456");
		reviewOrderPage.select_Credit_Card_Expiration_Month();
		reviewOrderPage.select_Credit_Card_Expiration_Year("2024");
		reviewOrderPage.enter_Credit_Card_SecurtiyCode("7777");
		reviewOrderPage.enter_Billing_Street_Address("6051 S Fiddlers Green cir");
		reviewOrderPage.enter_Billing_Apt("007");
		reviewOrderPage.enter_Billing_Zip_Code("80111");
		reviewOrderPage.enter_Billing_City("Greenwood Village");
		reviewOrderPage.select_dropDown_Billing_State("CO");
		reviewOrderPage.enter_Billing_Phone_Number("123456789");
		adPortalScreenShots.takeScreenShot_Upload_YourOwn_Commercial();
	}
}
