package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


//Find the login input fields - username and password
//Enter the credentials - admin and password - and click the "Log in" button.
//Read the confirmation message and make and assertion to check if the correct message has been printed.

public class Activity8 {
	
	// Declare webdriver
	WebDriver driver;
	WebDriverWait wait;
	
	// Set up method
	@BeforeClass
	public void setUp() {
		// Initialize Firefox driver
		driver = new FirefoxDriver();
		// Open the page
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/login-form/");
	}
	
    @DataProvider(name = "Credentials")
    public static Object[][] creds() {
        return new Object[][] { 
            { "admin1", "password1", "Invalid credentials" },
            { "wrongAdmin", "wrongPassword", "Invalid credentials" }
        };
    }

	@Test(dataProvider = "Credentials")
	public void formLogin(String username, String password, String expectedMessage) {	
	WebElement usernameField =driver.findElement(By.id("username"));
	WebElement passwordField = driver.findElement(By.id("password"));
	WebElement submitBtn=driver.findElement(By.xpath("//button[text()='Submit']"));
	
	usernameField.clear();
	passwordField.clear();
	
	usernameField.sendKeys(username);
	passwordField.sendKeys(password);
		submitBtn.click();	
		String loginMessage  = driver.findElement(By.id("subheading")).getText();
		
		Assert.assertEquals(loginMessage ,expectedMessage);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
