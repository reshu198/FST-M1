package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

//Add 4 @Test methods.
//In the first @Test method, use getTitle() to get and assert the title of the page.
//In the second @Test method, use findElement() to look for the black button. Make an incorrect assertion. (This test case is meant to throw an error)
//For the third @Test method, skip it by setting it's enabled parameter to false.
//The third method will be skipped, but will not be shown as skipped.
//For the fourth @Test method, skip it by throwing a SkipException inside the method.
//The fourth method will be skipped and it will be shown as skipped.
//Observe the result in the console.
public class Activity2 {
	
	// Declare webdriver
	WebDriver driver;
	
	// Set up method
	@BeforeClass
	public void setUp() {
		// Initialize Firefox driver
		driver = new FirefoxDriver();
		// Open the page
		driver.get("https://training-support.net/webelements/target-practice/");
	}

	@Test(priority = 1)
	public void testCase1() {

		// System.out.println("The title of the loaded Page is : " +driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
	}

	@Test(priority = 2)
	public void testCase2() {
        // This test case will Fail
        WebElement pinkButton = driver.findElement(By.cssSelector("button.bg-pink-200"));
        Assert.assertTrue(pinkButton.isDisplayed());
        Assert.assertEquals(pinkButton.getText(), "black");
	}
	
    @Test(enabled = false)
    public void testCase3() {
        // This test will be skipped and not counted
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }
 
    @Test
    public void testCase4() {
        // This test will be skipped and will be be shown as skipped
        throw new SkipException("Skipping test case");
    }

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
