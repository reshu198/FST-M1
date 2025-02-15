package CRM_Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Get the url of the header image
//Goal: Print the url of the header image to the console

public class CRM_Activity2 {
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
	public void headerImageUrl() {
//		Get the url of the header image.
		WebElement headerImage = driver.findElement(By.xpath("//div/img"));
//	Print the url to the console.
		String actualUrl = headerImage.getDomAttribute("src");
		//System.out.println("The url in Image is : " + actualUrl);
		String expectedUrl = "themes/default/images/company_logo.png?v=cK7kLsY0ftg72ZVHTYUT_g";
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@AfterClass
	public void tearDown() {
		// Close the browser.
		driver.close();
	}

}
