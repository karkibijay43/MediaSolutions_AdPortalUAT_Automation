package adportalPageObjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import adPortalUtilities.AdPortalScreenShots;

public class RequestDashBoardPage {
	public WebDriver driver;

	By button_GetStarted = By.className("spp-btn-large ng-star-inserted");
	By button_Continue = By.xpath(
			"//datatable-row-wrapper[1]//datatable-body-row[1]//div[2]//datatable-body-cell[6]//div[1]//button[1]");
	By continue_Draft = By.xpath(
			"//datatable-row-wrapper[3]//datatable-body-row[1]//div[2]//datatable-body-cell[6]//div[1]//button[1]");
	By faq_Header = By.className("faq-header");
	By faq_Link1 = By.linkText("How much does it cost to run a TV campaign?");
	By faq_Link2 = By
			.linkText("I am ready to schedule my TV campaign through the Ad Portal. What do I need to get started?");
	By faq_Link3 = By.linkText("Can I preview my TV commercial?");
	By faq_Link4 = By.linkText("Can I make a revision to my TV commercial?");
	By faq_Link5 = By.linkText("How long should my TV campaign run?");

	public RequestDashBoardPage(WebDriver driver) {
		this.driver = driver;
	}

	public void continue_Draft() {
		driver.findElement(continue_Draft).click();
	}

	public void get_Started_Or_ContinueCamapaign() {
		try {
			if (driver.findElement(button_Continue).isDisplayed()) {
				System.out.println("Continuing with the Draft Camapaign");
				driver.findElement(button_Continue).click();
			} 
			else {
				System.out.println("This is you first camapaign creation, You are ready to get started");
				driver.findElement(button_GetStarted).click();
			}
		} 
		catch (NoSuchElementException e) {
			driver.findElement(button_Continue).click();
		}
	}

	public void explicitly_Wait_For_GetStartedButton() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(button_GetStarted));
		//WebElement getStartedButton = driver.findElement(button_GetStarted);
		//getStartedButton.click();
	}

	public void click_GetStarted() {
		driver.findElement(button_GetStarted).click();
	}

	public void explicitly_Wait_For_ContinueButton() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(button_Continue));
	}

	public void click_Continue() {
		driver.findElement(button_Continue).click();
	}
	//This is to verify Request Dashboard with Drafts
	public void request_DashBoardPage_With_Drafts_verification() {
		String expectedTitle = "SPP - Creative Requests";
		String actualTitle = driver.getTitle();
		System.out.println("The Title of Request DashBoard page is:" + " " + actualTitle);

		if (expectedTitle.equalsIgnoreCase(actualTitle)) {
			System.out.println("You have landed on the Request DashBoard page");
		} else {
			System.out.println("Please revisit LogIn page and enter valid credentials");
		}
	}
	//This is to verify New request DashBoard "Welcome to your campaign and commercial dashboard.
	public void new_Request_DashBoard_Verification() {
		//driver.navigate().refresh();
		String expectedTitle = "Spectrum Reach Ad Portal";
		String actualTitle = driver.getTitle();
		System.out.println("The Title this page is:" + " " + actualTitle);

		if (expectedTitle.equalsIgnoreCase(actualTitle)) {
			System.out.println("Welcome to your campaign and commercial dashBoard Page");
		} else {
			System.out.println("Please revisit sign up page to create new log in credentials");
		}
	}

	public void explicitly_Wait_For_FAQ_Links() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(faq_Header));
	}

	public void verify_FAQ_Header() {
		String expectedHeader = "Frequently Asked Questions";
		String actualHeader = driver.findElement(faq_Header).getText();
		System.out.println("The header of this page is :" + actualHeader);
		Assert.assertEquals(expectedHeader, actualHeader);
	}

	public void click_LinkText1() {
		driver.findElement(faq_Link1).click();
	}

	public void click_LinkText() {
		AdPortalScreenShots adPortalScreenShots;
		String hrefValue = null;
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (int i = 0; i < links.size(); i++) {
			hrefValue = links.get(i).getAttribute("href");
			if (hrefValue != null) {
				if (hrefValue.contains("center")) {
					System.out.println(hrefValue + " = internal domain");
					links.get(i).click();
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(tabs.get(1));
					adPortalScreenShots = new AdPortalScreenShots(driver);
					adPortalScreenShots.takeScreenShotNewDashBoardView_FAQ_Link();
					driver.close();
					driver.switchTo().window(tabs.get(0));
				} 
				else {
					System.out.println(hrefValue + " = external domain");
				}
			}
			else {
				System.out.println("element doesn't have href attriubte");
			}
		}
	}
}
