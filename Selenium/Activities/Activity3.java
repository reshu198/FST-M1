package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
	public static void main(String[] args) {
		// Initialize the Firefox driver
		WebDriver driver = new FirefoxDriver();

		// Open the page
		driver.get("https://training-support.net/webelements/login-form");
		// Print the title of the page
		System.out.println("Page title: " + driver.getTitle());

		// Find the username field and enter the username
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		// Find the password field and enter the password
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");
		// Find the login button and click it
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		// Print the confirmation message
		System.out.println("New Page title: " + driver.getTitle());

		// Close the browser
		driver.quit();
	}
}