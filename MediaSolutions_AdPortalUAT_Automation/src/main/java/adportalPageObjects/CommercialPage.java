package adportalPageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommercialPage {
	public WebDriver driver;
	JavascriptExecutor executor;

	public CommercialPage(WebDriver driver) {
		this.driver = driver;
	}

	By commercialPage_NextButton = By.xpath("//button[contains(text(),'Next')]");
	By link_Click_Here = By.xpath("//u[contains(text(),'Click here')]");
	By upload_Your_Own_Commercial_Box = By.xpath(
			"//body/app-root/div/app-order/div/div/div/div/section/app-creative-upload-full-page/app-card-item/div/div/div/div/div/div/div/div/div/label/div[1]");
	By enabled_Button_Next = By.className("spp-btn");
	By txtBox_Things_To_KnowAbout1 = By.id("brandInfo0");
	By txtBox_Things_To_KnowAbout2 = By.id("brandInfo1");
	By txtBox_Things_To_KnowAbout3 = By.id("brandInfo2");
	By txtBox_commercial_TagLine = By.id("commercialTagline");
	By commercial_Upload_Box = By.xpath(
			"//body/app-root/div[@id='tv-main']/app-order/div/div/div/div/section/app-creative-business-description/app-card-item[@id='creative-upload-logo']/div[@id='card-item-wrapper']/div/div/div/div/div/div/div/div/app-upload-creatives/div/div/label/div[1]");
	By image_Rights_CheckBox = By.cssSelector(
			"body.white-background:nth-child(2) div.main app-order.ng-star-inserted:nth-child(2) div.order-comp:nth-child(1) div.main-section div.row-materialize.header-row-all:nth-child(2) div.row-materialize.s9.card-section section.section-container app-creative-business-description.ng-star-inserted:nth-child(2) div.ng-animate-disabled div.card-item-position div.tv-commerical-question-card div.card.card-client.ng-star-inserted div.card-content.ng-star-inserted div.creative-business-description div.text-left:nth-child(2) div.row.image-info-container.m-0:nth-child(3) div.col-sm-7.col-12.p-0.mr-5.mb-3 app-upload-creatives:nth-child(3) > label.ng-star-inserted:nth-child(3)");
	By CommericialPage1_NextButton = By.className("spp-btn");
	By txtBox_primary_Call_To_Action = By.id("newCommercialCallToAction");
	By click_Edit_Address = By.xpath("//li[1]//div[2]//div[1]//a[1]");
	By txtBox_Street_Address_ = By.id("streetFirst");
	By txtBox_Apartment = By.id("streetSecond");
	By txtBox_City = By.id("city");
	By txtBox_State = By.id("state");
	By txtBox_Zip_Code = By.id("zip");
	By button_SaveChanges = By.className("button-text");
	/*
	 * By txtBox_Street_Address_ = By.id("streetFirst_firstuser"); By
	 * txtBox_Apartment = By.id("streetSecond_seconduser"); By txtBox_City =
	 * By.id("city_firstuser"); By dropdown_State =
	 * By.xpath("//ng-select[@name='state']//div//div//div//input"); By
	 * txtBox_Zip_Code = By.id("zip_firstuser");
	 */
	By txtBox_PhoneNumber = By.name("Phone number");
	By txtBox_Website_URL = By.name("Website URL");
	By txxBox_Email_Address = By.name("Email address");
	By txtBox_Other_Way_To_Contact = By.name("Other");
	By txtBox_Other_Message_For_Audience = By.name("otherMessageforAudience");
	By commercialPage2_NextButton = By.className("spp-btn");
	By radioButton_No_Voice_Preference = By.xpath("//div[contains(text(),'No voice preference')]");
	By radioButton_Male_Voice = By.xpath("//div[contains(text(),'Male Voice')]");
	By radioButton_Female_Voice = By.xpath("//div[contains(text(),'Female Voice')]");
	By dropDown_Music_Preference = By.xpath(
			"//body/app-root/div/app-order/div/div/div/div/section/app-creative-look-and-feel/app-card-item/div/div/div/div/div/div/div/div/ng-select[@placeholder='No music preference']/div/div/div[3]");
	By radioButton_No_Music_Preference = By.xpath(
			"//body/app-root/div/app-order/div/div/div/div/section/app-creative-look-and-feel/app-card-item/div/div/div/div/div/div/div/div/ng-select[@placeholder='No music preference']/ng-dropdown-panel/div/div/div[1]/div[1]/div[3]/mat-checkbox[1]/label[1]/div[1]");
	By radioButton_Easy_Listening_Music = By.xpath(
			"//body/app-root/div/app-order/div/div/div/div/section/app-creative-look-and-feel/app-card-item/div/div/div/div/div/div/div/div/ng-select[@placeholder='No music preference']/ng-dropdown-panel/div/div/div[2]/div[1]/div[3]/mat-checkbox[1]/label[1]/div[1]");
	By radioButton_Jazz_Music = By.xpath(
			"//body/app-root/div/app-order/div/div/div/div/section/app-creative-look-and-feel/app-card-item/div/div/div/div/div/div/div/div/ng-select[@placeholder='No music preference']/ng-dropdown-panel/div/div/div[3]/div[1]/div[3]/mat-checkbox[1]/label[1]/div[1]");
	By radioButton_No_Color_Preference = By.xpath("//div[contains(text(),'No color preference')]");
	By radioButton_Choose_Specific_Colors = By.xpath("//div[contains(text(),'Choose specific colors')]");
	By box_Color_Blues = By.xpath(
			"//body/app-root/div/app-order/div/div/div/div/section/app-creative-look-and-feel/app-card-item/div/div/div/div/div/div/div/div/div/div[1]/div[1]/a[1]/label[1]/div[1]");
	By box_Color_Greens = By.xpath(
			"//body/app-root/div/app-order/div/div/div/div/section/app-creative-look-and-feel/app-card-item/div/div/div/div/div/div/div/div/div/div[2]/div[1]/a[1]/label[1]/div[1]");
	By box_Color_Oranges = By.xpath(
			"//body/app-root/div/app-order/div/div/div/div/section/app-creative-look-and-feel/app-card-item/div/div/div/div/div/div/div/div/div/div[6]/div[1]/a[1]/label[1]/div[1]");

	By txtBox_Special_Instructions = By.name("specialInstructions");
	By commercialPage3_NextButton = By.className("spp-btn");

	public void click_commercialPage_NextButton() {
		driver.findElement(commercialPage_NextButton).click();
	}

	public void click_Here_Link() {
		driver.findElement(link_Click_Here).click();
	}

	public void upload_Your_Own_Commercial_Box() throws InterruptedException, AWTException {
		WebElement ownCommercialUploadBox = driver.findElement(upload_Your_Own_Commercial_Box);
		ownCommercialUploadBox.click();

		Robot robot;
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);

		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(150000);
	}

	public void click_Upload_YourOwnCommercialPage_Next_Button() {
			WebDriverWait wait_For_Next_Button = new WebDriverWait(driver, 300);
			wait_For_Next_Button.until(ExpectedConditions.visibilityOfElementLocated(enabled_Button_Next));

			WebElement nextButtonEnabled = driver.findElement(enabled_Button_Next);
			if (nextButtonEnabled.isEnabled()) {
				nextButtonEnabled.click();
			} else {

				System.out.println("Next button is not enabled");
			}

			try {
				nextButtonEnabled.click();

			} catch (StaleElementReferenceException e) {
				driver.findElement(enabled_Button_Next).click();
			}
		}
	

	public void enter_Things_To_KnowAbout1(String text) {
		driver.findElement(txtBox_Things_To_KnowAbout1).clear();
		driver.findElement(txtBox_Things_To_KnowAbout1).sendKeys(text);
	}

	public void enter_Things_To_KnowAbout2(String text) {
		driver.findElement(txtBox_Things_To_KnowAbout2).clear();
		driver.findElement(txtBox_Things_To_KnowAbout2).sendKeys(text);
	}

	public void enter_Things_To_KnowAbout3(String text) {
		driver.findElement(txtBox_Things_To_KnowAbout3).clear();
		driver.findElement(txtBox_Things_To_KnowAbout3).sendKeys(text);
	}

	public void enter_Commercial_TagLine(String text) {
		driver.findElement(txtBox_commercial_TagLine).clear();
		driver.findElement(txtBox_commercial_TagLine).sendKeys(text);
	}

	public void click_commercial_UploadBox() throws AWTException, InterruptedException {
		WebElement uploadBox = driver.findElement(commercial_Upload_Box);
		uploadBox.click();

		Robot robot;
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);

		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(11000);
	}

	public void commercial_Upload() throws AWTException, InterruptedException {
		WebElement uploadBox = driver.findElement(commercial_Upload_Box);
		uploadBox.click();

		Robot robot;
		robot = new Robot();

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(11000);
	}

	public void click_ImageRights_CheckBox() {
		WebElement element = driver.findElement(image_Rights_CheckBox);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();

	}

	public void click_CommericialPage1_NextButton() {
		driver.findElement(CommericialPage1_NextButton).click();

	}

	public void enter_primary_Call_To_Action(String text) {
		driver.findElement(txtBox_primary_Call_To_Action).clear();
		driver.findElement(txtBox_primary_Call_To_Action).sendKeys(text);
	}
	
	public void click_Edit_Address() {
		driver.findElement(click_Edit_Address).click();
	}

	public void enter_Street_Address(String address) {
		driver.findElement(txtBox_Street_Address_).clear();
		driver.findElement(txtBox_Street_Address_).sendKeys(address);
	}

	public void enter_Apartment(String apartment) {
		driver.findElement(txtBox_Apartment).clear();
		driver.findElement(txtBox_Apartment).sendKeys(apartment);
	}

	public void enter_City(String city) {
		driver.findElement(txtBox_City).clear();
		driver.findElement(txtBox_City).sendKeys(city);
	}

	public void select_State(String state) {
		WebElement enter_State = driver.findElement(txtBox_State);
		enter_State.clear();
		enter_State.sendKeys(state);
		//enter_State.sendKeys(Keys.ENTER);
	}
	public void click_Button_SaveChanges() {
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.elementToBeClickable(button_SaveChanges));
		driver.findElement(button_SaveChanges).click();
	}
	public void enter_Zip_Code(String zipCode) {
		driver.findElement(txtBox_Zip_Code).clear();
		driver.findElement(txtBox_Zip_Code).sendKeys(zipCode);
	}

	public void enter_PhoneNumber(String phoneNumber) {
		driver.findElement(txtBox_PhoneNumber).clear();
		driver.findElement(txtBox_PhoneNumber).sendKeys(phoneNumber);
	}

	public void enter_Website_URL(String url) {
		driver.findElement(txtBox_Website_URL).clear();
		driver.findElement(txtBox_Website_URL).sendKeys(url);
	}

	public void enter_Email_Address(String email) {
		driver.findElement(txxBox_Email_Address).clear();
		driver.findElement(txxBox_Email_Address).sendKeys(email);
	}

	public void enter_Other_Way_To_Contact(String contact) {
		driver.findElement(txtBox_Other_Way_To_Contact).clear();
		driver.findElement(txtBox_Other_Way_To_Contact).sendKeys(contact);
	}

	public void enter_Other_Message_For_Audience(String message) {
		driver.findElement(txtBox_Other_Message_For_Audience).clear();
		driver.findElement(txtBox_Other_Message_For_Audience).sendKeys(message);
	}

	public void click_commercialPage2_NextButton() {
		driver.findElement(commercialPage2_NextButton).click();
	}

	public void select_No_Voice_Preference() {
		driver.findElement(radioButton_No_Voice_Preference).click();
	}

	public void select_Male_Voice_Preference() {
		driver.findElement(radioButton_Male_Voice).click();
	}

	public void select_Female_Voice_Preference() {
		driver.findElement(radioButton_Female_Voice).click();
	}

	public void select_No_Music_Preference() throws InterruptedException {
		driver.findElement(dropDown_Music_Preference).click();
		while (true) {
			if (driver.findElement(radioButton_No_Music_Preference).isSelected()) {
				System.out.println("No Music preference is selected");

				if (!driver.findElement(radioButton_No_Music_Preference).isSelected()) {

					break;
				}
				return;
			}
			break;
		}

		int count = 0;
		boolean clicked = false;
		while (count < 3 && !clicked) {
			try {
				WebElement NoMusicPreference = driver.findElement(radioButton_No_Music_Preference);
				NoMusicPreference.click();
				clicked = true;
			} catch (ElementClickInterceptedException e) {
				driver.findElement(radioButton_No_Music_Preference).click();
				e.toString();
				System.out.println("Trying to click the element:" + e.getMessage());
				count = count + 1;
			}
			driver.findElement(radioButton_No_Music_Preference).click();
		} 
		//driver.findElement(radioButton_No_Music_Preference).click();
		driver.findElement(dropDown_Music_Preference).click();
		/*
		 * Actions action = new Actions(driver); action.sendKeys(Keys.SHIFT, Keys.TAB);
		 */

	}

	public void select_Easy_Listening_Music_Preference() {
		driver.findElement(dropDown_Music_Preference).click();
		{
			int count = 0;
			boolean clicked = false;
			while (count < 4 && !clicked) {
				try {
					WebElement MusicPreference = driver.findElement(radioButton_Easy_Listening_Music);
					MusicPreference.click();
					clicked = true;
				} catch (ElementClickInterceptedException e) {
					driver.findElement(radioButton_Easy_Listening_Music).click();
					e.toString();
					System.out.println("Trying to click the element:" + e.getMessage());
					count = count + 1;

				}

			}
		}
		driver.findElement(dropDown_Music_Preference).click();

	}

	public void select_Jazz_Music_Preference() {
		driver.findElement(dropDown_Music_Preference).click();
		driver.findElement(radioButton_Jazz_Music).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.SHIFT, Keys.TAB);
	}

	public void select_No_Color_Preference() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(radioButton_No_Color_Preference)).click().perform();
	}

	public void select_Color_Preference() {
		driver.findElement(radioButton_Choose_Specific_Colors).click();
		WebDriverWait Color_Box_Blue = new WebDriverWait(driver, 60);
		Color_Box_Blue.until(ExpectedConditions.visibilityOfElementLocated(box_Color_Blues));
		driver.findElement(box_Color_Blues).click();
		driver.findElement(box_Color_Greens).click();
		driver.findElement(box_Color_Oranges).click();
	}

	public void enter_Special_Instructions(String instructions) {
		driver.findElement(txtBox_Special_Instructions).clear();
		driver.findElement(txtBox_Special_Instructions).sendKeys(instructions);
	}

	public void click_CommercialPage3_NextButton() {
		WebDriverWait wait_For_click_CommercialPage3_NextButton = new WebDriverWait(driver, 60);
		wait_For_click_CommercialPage3_NextButton
				.until(ExpectedConditions.visibilityOfElementLocated(commercialPage3_NextButton));
		driver.findElement(commercialPage3_NextButton).click();
	}

}
