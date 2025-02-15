package CRM_Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//Reading additional information
//Goal: Reading a popup that contains additional information about the account/lead.

public class CRM_Activity4 {
	WebDriver driver;
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

	@AfterClass
	public void tearDown() {
		// Close the browser.
		driver.close();
	}

}
