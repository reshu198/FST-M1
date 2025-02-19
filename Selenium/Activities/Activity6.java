package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		driver.get("https://training-support.net/webelements/dynamic-controls");

		System.out.println("Page title: " + driver.getTitle());
		// Find the checkbox
		WebElement checkbox = driver.findElement(By.id("checkbox"));

		// Check if it is displayed on the page
		System.out.println("Is the Checkbox selected: " + checkbox.isSelected());

		checkbox.click();

		// Check if it is displayed on the page
		System.out.println("Is the Checkbox selected: " + checkbox.isSelected());

		// Close the browser
		driver.quit();

	}

}
