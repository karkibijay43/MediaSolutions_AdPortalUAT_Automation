package adPortalUtilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AdPortalScreenShots {

	public static AdPortalScreenShots adPortalScreenShots;
	private WebDriver driver;
	File source;
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	public AdPortalScreenShots(WebDriver driver) {
		this.driver = driver;
	}

	public void takeScreenShot() {
		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdPortalUAT AdPortalUAT Automation Test Screenshotss/AdportalRegressioin_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken!!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotLoginTest() {
		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdPortalUAT Automation Test Screenshotss/AdPortal_LogIn_feature/AdPortalLoginTest_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken!!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotSSU_SignUp() {
		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdPortalUAT Automation Test Screenshots/AdPortal_SSU_LogIn_feature/SSU_SignUp"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotNewDashBoardView() {
		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdPortalUAT Automation Test Screenshots/AdPortal_DashBoardView_feature/NewDashBoardView_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotNewDashBoardView_FAQ_Link() {
		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdPortalUAT Automation Test Screenshots/AdPortal_DashBoardView_FAQ_Link_feature/FAQ_Link_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotCreateCampaignDefault_RewviewPage() {
		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdPortalUAT Automation Test Screenshots/AdPortal_CreateCampaign_feature/Review_YourCampaign_Top_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken for the top section of the page!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdPortalUAT Automation Test Screenshots/AdPortal_CreateCampaign_feature/Review_YourCampaign_Bottom_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken for Bottom section of the page!!!!");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void takeScreenShotCreateCampaignDefault_RewviewOrderPage() {
		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdPortalUAT Automation Test Screenshots/AdPortal_CreateCampaign_feature/ReviewYourOrder_Top_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken for the top section of the page!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdPortalUAT Automation Test Screenshots/AdPortal_CreateCampaign_feature/ReviewYourOrder_Bottom_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken for Bottom section of the page!!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotCreateCampaignUserInPut() {
		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdPortalUAT Automation Test Screenshots/AdPortal_CreateCampaign_feature/CreateCampaignUserInPut_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotCreateCampaignDefault_CheckOutPage() {
		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdPortalUAT Automation Test Screenshots/AdPortal_CreateCampaign_feature/CheckOutPage_Top_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken for the top section of the page!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdPortalUAT Automation Test Screenshots/AdPortal_CreateCampaign_feature/CheckOutPage_Bottom_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken for Bottom section of the page!!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShot_Upload_YourOwn_Commercial() {
		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdPortalUAT Automation Test Screenshots/AdPortal_CreateCampaign_feature/AdPortal_Upload_Your_Own_Commercial_feature_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken for the top section of the page!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void take_ScreenShot_ReachIntroPage() {
		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/AdPortalUAT Automation Test Screenshots/AdPortal_ReachIntroPage_feature/Reach_1_of_3_Page_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
