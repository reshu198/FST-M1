package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

//Create a TestNG Class with the annotations
//@Test
//@BeforeClass
//@AfterClass
//In the @BeforeClass method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://training-support.net
//In the @AfterClass method, use close() to close the browser once the test is done.
//In the @Test method,
//Use getTitle() to get and print the title of the page.
//Make an assertion using assertEquals() to make sure the title of the page is "Training Support".
//Use findElement() to find the "About Us" Button on the page and click it.
//Get and print the title of the new page.
//Assert the title of the new page.
public class Activity1 {
	// Declare webdriver
	WebDriver driver;

	@Test(priority = 1)
	public void homePage() {

		// System.out.println("The title of the loaded Page is : " +driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Training Support");
	}

	@Test(priority = 2)
	public void aboutUsPage() {
		driver.findElement(By.xpath("//a[text()='About Us']")).click();
		System.out.println("The title of the loaded Page is : " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "About Training Support");
	}

	// Set up method
	@BeforeClass
	public void setUp() {
		// Initialize Firefox driver
		driver = new FirefoxDriver();
		// Open the page
		driver.get("https://training-support.net");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
