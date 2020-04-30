package adPortalUATStepDefinitions;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import adPortalDataProvider.ConfigFileReader;
import adPortalManagers.PageObjectManager;
import adPortalManagers.WebDriverManager;
import adPortalUtilities.AdPortalScreenShots;
import adportalPageObjects.LogInPage;
import adportalPageObjects.RequestDashBoardPage;
import adportalPageObjects.SignUpPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdPortal_LogIn_001_StepDefinition {
	WebDriver driver;
	ConfigFileReader configFileReader;
	JavascriptExecutor executor;
	LogInPage logInPage;
	SignUpPage signUpPage;
	RequestDashBoardPage requestDashBoardPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	AdPortalScreenShots adPortalScreenShots;

	@Given("^User is on AdPortal UAT sign up page and clicks Login link$")

	public void user_Is_On_AdPortal_UAT_SignUp_Page() {
		webDriverManager = new WebDriverManager();
		driver = WebDriverManager.getDriver();
		configFileReader = new ConfigFileReader();
		pageObjectManager = new PageObjectManager(driver);
		// configFileReader.getLoginURL();
		//configFileReader.getApplicationUrl();
		// adPortalUATLogInPAge = pageObjectManager.getadPortalUATLogInPAge();
		// adPortalUATLogInPAge.navigateTo_adPortalUATLogInPAge();
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

	@When("^User enters username and password and clicks log in$")

	public void enter_UserName_And_Password() throws IOException {
		logInPage = new LogInPage(driver);
		logInPage.enter_LogInEmail("c-bijay.karki@charter.com");
		logInPage.enter_LogInPassword("Spectrum123!");
		logInPage.clickLogIn();

	}

	@Then("^User lands on request dashboard page$")

	public void requestDashBoard_Verification() {
		adPortalScreenShots = new AdPortalScreenShots(driver);
		requestDashBoardPage = new RequestDashBoardPage(driver);
		requestDashBoardPage.explicitly_Wait_For_ContinueButton();
		requestDashBoardPage.request_DashBoardPage_With_Drafts_verification();
		adPortalScreenShots.takeScreenShotLoginTest();
	}

}
