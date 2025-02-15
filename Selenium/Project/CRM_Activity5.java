package CRM_Activities;

import org.openqa.selenium.support.Color;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//Getting colors
//Goal: Get the color of the navigation menu

public class CRM_Activity5 {
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
	
	@Test(priority = 2)
	public void navigationMenu() {
		Color navMenuColor = Color.fromString(driver.findElement(By.id("toolbar")).getCssValue("color"));
		String expectedNavMenuColorRGB = "rgb(83, 77, 100)";
		String actualNavMenuColorRGB = navMenuColor.asRgb();
		System.out.println("Navigation Menu Color as RGB is : " + actualNavMenuColorRGB);
		Assert.assertEquals(actualNavMenuColorRGB, expectedNavMenuColorRGB);
	}
	

	@AfterClass
	public void tearDown() {
		// Close the browser.
		driver.close();
	}

}
