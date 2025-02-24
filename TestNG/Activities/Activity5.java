package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity5 {
	// Declare webdriver
	WebDriver driver;
	
	// Set up method
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		// Initialize Firefox driver
		driver = new FirefoxDriver();
		// Open the page
		driver.get("https://training-support.net/webelements/target-practice");
	}
	
	@Test(groups = { "HeaderTests" })
    public void pageTitleTest() {
        Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
    }
	
	@Test(dependsOnMethods = { "pageTitleTest" }, groups = { "HeaderTests" })
    public void HeaderTest1() {
        WebElement header3 = driver.findElement(By.xpath("//h3[contains(@class, 'orange')]"));
        Assert.assertEquals(header3.getText(), "Heading #3");
    }
 
    @Test(dependsOnMethods = { "pageTitleTest" }, groups = { "HeaderTests" })
    public void HeaderTest2() {
        Color header5Color = Color.fromString(driver.findElement(By.xpath("//h5[text()='Heading #5']")).getCssValue("color"));
        Assert.assertEquals(header5Color.asHex(), "#9333ea");
    }
 
    @Test(dependsOnMethods = { "pageTitleTest" }, groups = { "ButtonTests" })
    public void ButtonTest1() {
        WebElement button1 = driver.findElement(By.xpath("//button[contains(@class, 'emerald')]"));
        ;
        Assert.assertEquals(button1.getText(), "Emerald");
    }
 
    @Test(dependsOnMethods = { "pageTitleTest" }, groups = { "ButtonTests" })
    public void ButtonTest2() {
        Color button2Color = Color.fromString(driver.findElement(By.xpath("//button[contains(@class, 'teal')]")).getCssValue("color"));
        Assert.assertEquals(button2Color.asHex(), "#134e4a");
    }
 
    // Include alwaysRun property on the @AfterClass to make sure the page always
    // closes
    @AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

}
