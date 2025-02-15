package CRM_Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//Reading additional information
//Goal: Reading a popup that contains additional information about the account/lead.

public class CRM_Activity7 {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Set up method : Open a browser
	@BeforeClass
	public void setUp() {
		// Initialize Chrome driver
		driver = new ChromeDriver();
		// Navigate to ‘http://alchemy.hguy.co/crm’.
		driver.get("http://alchemy.hguy.co/crm");
	}

	@Test(priority = 1)
	@Parameters({ "username", "password" })
	public void login(String username, String password) {
		WebElement usernameField = driver.findElement(By.id("user_name"));
		WebElement passwordField = driver.findElement(By.id("username_password"));
		
        // Enter credentials
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
		
		driver.findElement(By.id("bigbutton")).click();
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertTrue(homePageUrl.contains("Home"),"Login Failed !");
	}

	@Test(priority = 2)
	public void additionalInformation() throws InterruptedException {
		driver.manage().window().maximize();
//		Navigate to Sales -> Leads
		driver.findElement(By.id("grouptab_0")).click();
		driver.findElement(By.id("moduleTab_9_Leads")).click();
		Thread.sleep(2000);
//		In the table, find the Additional information icon at the end of the row of the lead information. Click it.
		driver.findElement(By.xpath("//span[@title='Additional Details']")).click();
		Thread.sleep(2000);
//		Read the popup and print the phone number displayed in it.
		WebElement additionalDetails = driver.findElement(By.xpath("//span[@class='phone']"));
		String mobileNumber = additionalDetails.getText();
		System.out.println("The mobile number is :" + mobileNumber);
		Assert.assertFalse(mobileNumber.isEmpty(),"Mobile Number not available");

	}

	@AfterClass
	public void tearDown() {
		// Close the browser.
		driver.close();
	}

}
