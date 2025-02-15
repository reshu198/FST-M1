package CRM_Activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Verify the website title
//Goal: Read the title of the website and verify the text

public class CRM_Activity1 {
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
	public void websiteTitle() {
		//Get the title of the website.
		String actualTitle = driver.getTitle();
		String expectedTitle = "SuiteCRM";
		
//		Make sure it matches “SuiteCRM” exactly
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterClass
	public void tearDown() {
		// Close the browser.
		driver.close();
	}

}
