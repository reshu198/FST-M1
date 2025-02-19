package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		driver.get("https://training-support.net/webelements/dynamic-controls");

		System.out.println("Page title: " + driver.getTitle());
		// Find the checkbox
		WebElement textbox = driver.findElement(By.id("textInput"));

		// Check if it is displayed on the page
		System.out.println("Is the Textbox enabled: " + textbox.isEnabled());

		driver.findElement(By.id("textInputButton")).click();

		// Check if it is displayed on the page
		System.out.println("Is the Textbox enabled: " + textbox.isEnabled());

		// Close the browser
	    driver.quit();

	}

}
