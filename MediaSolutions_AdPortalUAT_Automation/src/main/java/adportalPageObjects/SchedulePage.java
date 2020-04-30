package adportalPageObjects;

import java.util.List;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SchedulePage extends CommercialPage {
	public SchedulePage(WebDriver driver) {
		super(driver);	
	}
	/*
	 * public WebDriver driver; 
	 * public void SchedulePage (WebDriver driver) {
	 * this.driver = driver; }
	 */
	public void CommercialPage(WebDriver driver) {
		this.driver = driver;
	}

	By startAiring_CalenderArrow = By.xpath(
			"//div[@id='schedule-date-budget-wrapper']//div[1]//div[1]//app-date-picker[1]//div[1]//span[1]//i[2]");
	By calender_TagName = By.tagName("dp-day-calendar");
	By date_Button = By.tagName("button");
	By stopAiring_CalenderArrow = By.xpath(
			"//body//div[@id='card-item-wrapper']//div//div//div[2]//div[1]//app-date-picker[1]//div[1]//span[1]//i[2]");
	By budgetAmount = By.xpath("//input[@id='budget']");
	By schedulePage1_NextButton = By.className("spp-btn");
	By review_CamapaignTitle = By.className("header large ng-star-inserted");
	By yourBudget_Amount = By.cssSelector(
			"body.white-background:nth-child(2) div.main app-order.ng-star-inserted:nth-child(2) div.order-comp:nth-child(1) div.main-section div.row-materialize.header-row-all:nth-child(2) div.row-materialize.s9.card-section section.section-container app-schedule-display.ng-star-inserted:nth-child(2) div.ng-animate-disabled div.card-item-position div.tv-commerical-question-card div.card.card-client.ng-star-inserted div.card-content.ng-star-inserted div.review-schedule.container-fluid.p-0.text-left.ng-star-inserted div.row.m-0.mb-4.pb-2 div.col.p-0.pr-3 app-commercial-schedule-overview:nth-child(2) div.ng-star-inserted div.d-flex.your-schedule-section > div.schedule-cost.d-flex.align-items-center");
	By schedulePage2_NextButton = By.xpath("//span[contains(text(),'Next')]");
	By txtBox_campaignName_AlertBox = By.xpath("//input[@placeholder='My Campaign Name']");

	By click_Next_Alert = By.id("submit");

	public void click_startCalednderArrow() {
		driver.findElement(startAiring_CalenderArrow).click();
		driver.findElement(calender_TagName).click();
		List<WebElement> allStartDates = driver.findElements(date_Button);
		for (WebElement dates : allStartDates) {
			String date = dates.getText();
			if (date.equalsIgnoreCase("11")) {
				dates.click();
				break;
			}
		}
	}

	public void click_stopCalenderArrow() {
		driver.findElement(stopAiring_CalenderArrow).click();
		List<WebElement> allEndDates = driver.findElements(date_Button);
		for (WebElement dates : allEndDates) {
			String date = dates.getText();
			if (date.equalsIgnoreCase("17")) {
				dates.click();
				break;
			}
		}
	}

	public void enter_Budget(String budget) {
		driver.findElement(budgetAmount).clear();
		driver.findElement(budgetAmount).sendKeys(budget);
	}

	public void enter_Budget_UserInput() {
		driver.findElement(budgetAmount).clear();
		int Amount;
		String enterBudgetAmount;
		enterBudgetAmount = JOptionPane.showInputDialog(null, "Enter your budget amount");
		Amount = Integer.parseInt(enterBudgetAmount);
		driver.findElement(budgetAmount).sendKeys(String.valueOf(Amount));
		if (Amount > 10000) {
			JOptionPane.showMessageDialog(null, "Invalid Budget Amount, Budget Should be Between $250 and $10000");
		}
	}

	public void click_SchedulePage1NextButton() {
		driver.findElement(schedulePage1_NextButton).click();
	}

	public void verify_BudgetAmount() {
		String budgetValue = driver.findElement(yourBudget_Amount).getText();
		System.out.println("your Budget amount is :" + budgetValue);
	}

	public void explicitly_Wait_For_ReviewPageNextButton() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(schedulePage2_NextButton));
	}

	public void explicitly_Wait_For_campaignName_AlertBox() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtBox_campaignName_AlertBox));
		driver.findElement(txtBox_campaignName_AlertBox).click();
	}

	public void enter_CampaignName_Or_Continue_With_Commercial(String campaignName) {
		// WebDriverWait wait = new WebDriverWait(driver, 25);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(txtBox_campaignName_AlertBox));
		try {
			if (driver.findElement(txtBox_campaignName_AlertBox).isDisplayed()) {
				// driver.findElement(txtBox_campaignName_AlertBox).click();
				driver.findElement(txtBox_campaignName_AlertBox).sendKeys(campaignName);
				driver.findElement(txtBox_campaignName_AlertBox).clear();
				driver.findElement(txtBox_campaignName_AlertBox).sendKeys(campaignName);
				 driver.findElement(click_Next_Alert).click();
				 driver.findElement(schedulePage2_NextButton).click();
			} 
			else {
				System.out.println("You have already Named your campaign continuing with uploading the commercial");
			}
		} 
		catch (NoSuchElementException e) {
			driver.findElement(schedulePage2_NextButton).click();
		}
	}
	
	public void enter_CampaignName_Or_Continue_With_Uploading_YourOwn_Commercial(String campaignName) {
		// WebDriverWait wait = new WebDriverWait(driver, 25);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(txtBox_campaignName_AlertBox));
		//CommercialPage commercialPage = new adportalPageObjects.CommercialPage (driver);
		try {
			if (driver.findElement(txtBox_campaignName_AlertBox).isDisplayed()) {
				// driver.findElement(txtBox_campaignName_AlertBox).click();
				driver.findElement(txtBox_campaignName_AlertBox).sendKeys(campaignName);
				driver.findElement(txtBox_campaignName_AlertBox).clear();
				driver.findElement(txtBox_campaignName_AlertBox).sendKeys(campaignName);
				 driver.findElement(click_Next_Alert).click();
				 driver.findElement(schedulePage2_NextButton).click();
			}
			else {
				System.out.println("You have already Named your campaign continuing with uploading the commercial");
			}
		} 
		catch (NoSuchElementException e) {			
		}
	}

	public void click_SchedulePage2_NextButton() {
		driver.findElement(schedulePage2_NextButton).click();
	}
}
