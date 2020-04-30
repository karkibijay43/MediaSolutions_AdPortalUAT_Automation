package adPortalUATStepDefinitions;

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

public class AdPortal_LogIn_002_StepDefinition {

	WebDriver driver;
	ConfigFileReader configFileReader;
	JavascriptExecutor executor;
	LogInPage logInPage;
	SignUpPage signUpPage;
	RequestDashBoardPage requestDashBoardPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	AdPortalScreenShots adPortalScreenShots;

	@Given("^User is on AdPortal UAT sign up page and clicks Login$")
	public void user_Is_On_LogIn_Page() throws InterruptedException {
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

	@When("^User enters desired email and password and clicks log in button$")
	public void enter_UserName_And_Password() {
		LogInPage logInPage = new LogInPage(driver);
		logInPage.userInPut_LogInEmail();
		logInPage.userInPut_LogInPassword();
		logInPage.clickLogIn();
	}

	@Then("^User lands on request dashboard page to start a campaign$")

	public void requestDashBoard_Verification() {
		adPortalScreenShots = new AdPortalScreenShots(driver);
		requestDashBoardPage = new RequestDashBoardPage(driver);
		requestDashBoardPage.explicitly_Wait_For_ContinueButton();
		requestDashBoardPage.request_DashBoardPage_With_Drafts_verification();
		adPortalScreenShots.takeScreenShotLoginTest();
	}

}
