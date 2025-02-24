package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

//Find the login input fields - username and password
//Enter the credentials - admin and password - and click the "Log in" button.
//Read the confirmation message and make and assertion to check if the correct message has been printed.

public class Activity3 {
	
	// Declare webdriver
	WebDriver driver;
	
	// Set up method
	@BeforeClass
	public void setUp() {
		// Initialize Firefox driver
		driver = new FirefoxDriver();
		// Open the page
		driver.get("https://training-support.net/webelements/login-form/");
	}

	@Test(priority = 1)
	public void formLogin() {

		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		String actualMessage = driver.findElement(By.xpath("//h2[@class='mt-5 text-center text-4xl font-semibold text-gray-800']")).getText();
		String expectedMessage = "Welcome Back, Admin!";
		
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
