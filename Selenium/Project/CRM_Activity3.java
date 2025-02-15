package CRM_Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Get the copyright text
//Goal: Print the first copyright text in the footer to the console

public class CRM_Activity3 {
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
	public void getCopyright() {
		//Get the first copyright text in the footer.
		String actualCopyrightText = driver.findElement(By.id("admin_options")).getText();
		//Print the text to the console.
		System.out.println("The text in the Copyright in Footer is : " + actualCopyrightText);
		// assert that text matches the expectation
		String expectedCopyrightText = "© Supercharged by SuiteCRM";
		Assert.assertEquals(actualCopyrightText, expectedCopyrightText);
	}

	@AfterClass
	public void tearDown() {
		// Close the browser.
		driver.close();
	}

}
