package adportalPageObjects;

import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import adPortalDataProvider.ConfigFileReader;

public class LogInPage {
	ConfigFileReader configFileReader;
	public WebDriver driver;
	JavascriptExecutor executor;

	By txtBox_LogInEmail = By.id("email");
	By txtBox_LogInPassword = By.id("password");
	By clickLogIn = By.xpath("//*[@id=\"tv-main\"]/app-adportal-login/app-login-signup-reset/div[2]/div/div/form/button");
	String LogInURL = "https://adportal.uat.brandcdnstage.com/login";
	
	public LogInPage(WebDriver driver) {
		this.executor = (JavascriptExecutor) this.driver;
		this.driver = driver;
		configFileReader = new ConfigFileReader();
	}
	
	public void navigateTo_LogInPage() {
		driver.get(LogInURL);
	}
	public void enter_LogInEmail(String email) {
		driver.findElement(txtBox_LogInEmail).clear();
		driver.findElement(txtBox_LogInEmail).sendKeys(email);
	}

	public void userInPut_LogInEmail() {
		driver.findElement(txtBox_LogInEmail).clear();
		String enterEmail;
		enterEmail = JOptionPane.showInputDialog(null, "Enter your Email Address");
		driver.findElement(txtBox_LogInEmail).sendKeys(enterEmail);
		// driver.findElement(txtBox_LogInEmail).sendKeys(email);
	}

	public void enter_LogInPassword(String password) {
		driver.findElement(txtBox_LogInPassword).clear();
		driver.findElement(txtBox_LogInPassword).sendKeys(password);
	}

	public void userInPut_LogInPassword() {
		driver.findElement(txtBox_LogInPassword).clear();
		String enterPassword;
		enterPassword = JOptionPane.showInputDialog(null, "Enter your Password");
		driver.findElement(txtBox_LogInPassword).sendKeys(enterPassword);
	}

	public void clickLogIn() {
		driver.findElement(clickLogIn).click();
	}

	public void page_Scroll_Down() {

		executor.executeScript("window.scrollBy(0,100)");
	}

}
