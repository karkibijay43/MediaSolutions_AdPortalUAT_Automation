package adportalPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ReviewOrderPage {
	public WebDriver driver;

	By place_OrderButton = By.xpath("//button[contains(text(),'Place Order')]");
	By dropDown_BusinessCategory = By.xpath("//ng-select[@name='BusinessCategory']//div//div//div//input");
	By txtBox_Credit_Card_FirstNAme = By.id("firstName");
	By txtxBox_Credit_Card_LastName = By.id("lastName");
	By txtBox_Credit_Card_Number = By.id("cardNumber");
	By dropDown_Credit_Card_Expiration_Month = By.id("expirationMonth");
	By dropDown_Credit_Card_Expiration_Year = By.id("expirationYear");
	By txtBox_Credit_Card_SecurtiyCode = By.id("cvv");
	By txtBox_Billing_Street_Address = By.id("billing-address-1");
	By txtBox_Billing_Apt = By.id("billing-address-2");
	By txtBox_Billing_Zip_Code = By.id("zip");
	By txtBox_Billing_City = By.xpath("//input[@name='City']");
	By dropDown_Billing_State = By.xpath("//ng-select[@name='State']//div//div//div//input");
	By txtBox_Billing_Phone_Number = By.xpath("//input[@name='Phone']");

	public ReviewOrderPage(WebDriver driver) {
		this.driver = driver;
	}

	public void click_place_OrderButton() {
		driver.findElement(place_OrderButton).click();
	}

	public void select_BusinessCategory(String category) {
		driver.findElement(dropDown_BusinessCategory).clear();
		driver.findElement(dropDown_BusinessCategory).sendKeys(category);
		driver.findElement(dropDown_BusinessCategory).sendKeys(Keys.ENTER);
	}

	public void enter_Credit_Card_FirstNAme(String firstName) {
		driver.findElement(txtBox_Credit_Card_FirstNAme).clear();
		driver.findElement(txtBox_Credit_Card_FirstNAme).sendKeys(firstName);
	}

	public void enter_Credit_Card_LastName(String lastName) {
		driver.findElement(txtxBox_Credit_Card_LastName).clear();
		driver.findElement(txtxBox_Credit_Card_LastName).sendKeys(lastName);
	}

	public void enter_Credit_Card_Number(String CCNumber) {
		driver.findElement(txtBox_Credit_Card_Number).clear();
		driver.findElement(txtBox_Credit_Card_Number).sendKeys(CCNumber);
	}

	public void select_Credit_Card_Expiration_Month() {
		WebElement expiration_Month = driver.findElement(dropDown_Credit_Card_Expiration_Month);
		expiration_Month.click();
		expiration_Month.sendKeys("J");
		// expiration_Month.sendKeys(Keys.ARROW_DOWN);
		// expiration_Month.sendKeys(Keys.ARROW_DOWN);
		expiration_Month.sendKeys(Keys.ENTER);
	}

	public void select_Credit_Card_Expiration_Year(String year) {
		WebElement expiration_Year = driver.findElement(dropDown_Credit_Card_Expiration_Year);
		expiration_Year.click();
		expiration_Year.sendKeys(year);
		expiration_Year.sendKeys(Keys.ENTER);
	}

	public void enter_Credit_Card_SecurtiyCode(String CVV) {
		driver.findElement(txtBox_Credit_Card_SecurtiyCode).clear();
		driver.findElement(txtBox_Credit_Card_SecurtiyCode).sendKeys(CVV);
	}

	public void enter_Billing_Street_Address(String address) {
		driver.findElement(txtBox_Billing_Street_Address).clear();
		driver.findElement(txtBox_Billing_Street_Address).sendKeys(address);
	}

	public void enter_Billing_Apt(String apartment) {
		driver.findElement(txtBox_Billing_Apt).clear();
		driver.findElement(txtBox_Billing_Apt).sendKeys(apartment);
	}

	public void enter_Billing_Zip_Code(String zipCode) {
		driver.findElement(txtBox_Billing_Zip_Code).clear();
		driver.findElement(txtBox_Billing_Zip_Code).sendKeys(zipCode);
	}
	
	public void enter_Billing_City(String city) {
		  driver.findElement(txtBox_Billing_City).click();
	  driver.findElement(txtBox_Billing_City).clear();
	  driver.findElement(txtBox_Billing_City).sendKeys(city); 
	}
	 
	public void select_dropDown_Billing_State(String state) {
		WebElement billing_State = driver.findElement(dropDown_Billing_State);
		billing_State.clear();
		billing_State.sendKeys(state);
		billing_State.sendKeys(Keys.ENTER);
	}

	public void enter_Billing_Phone_Number(String phoneNumber) {
		driver.findElement(txtBox_Billing_Phone_Number).click();
		driver.findElement(txtBox_Billing_Phone_Number).clear();
		driver.findElement(txtBox_Billing_Phone_Number).sendKeys(phoneNumber);
	}
}
