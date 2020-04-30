package adPortalManagers;

import org.openqa.selenium.WebDriver;
import adportalPageObjects.CommercialPage;
import adportalPageObjects.LogInPage;
import adportalPageObjects.ReachPage;
import adportalPageObjects.RequestDashBoardPage;
import adportalPageObjects.ReviewOrderPage;
import adportalPageObjects.SchedulePage;
import adportalPageObjects.SignUpPage;

public class PageObjectManager {
	private WebDriver driver;

	private SignUpPage signUpPage;
	private LogInPage logInPage;
	private ReachPage reachPage;
	private SchedulePage schedulePage;
	private RequestDashBoardPage requestDashBoardPage;
	private CommercialPage commercialPage;
	private ReviewOrderPage reviewOrderPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public SignUpPage getSignUpPage() {
		return (signUpPage == null) ? signUpPage = new SignUpPage(driver) : signUpPage;
	}

	public LogInPage getLogInPage() {
		return (logInPage == null) ? logInPage = new LogInPage(driver) : logInPage;
	}

	public ReachPage getReachPage() {
		return (reachPage == null) ? reachPage = new ReachPage(driver) : reachPage;
	}

	public SchedulePage getSchedulePage() {
		return (schedulePage == null) ? schedulePage = new SchedulePage(driver) : schedulePage;
	}

	public RequestDashBoardPage getRequestDashBoardPage() {
		return (requestDashBoardPage == null) ? requestDashBoardPage = new RequestDashBoardPage(driver) : requestDashBoardPage;
	}

	public CommercialPage getCommercialPage() {
		return (commercialPage == null) ? commercialPage = new CommercialPage(driver) : commercialPage;
	}

	public ReviewOrderPage getReviewOrderPage() {
		return (reviewOrderPage == null) ? reviewOrderPage = new ReviewOrderPage(driver) : reviewOrderPage;
	}

}
