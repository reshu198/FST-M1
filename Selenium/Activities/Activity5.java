package activities;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity5 {

	public static void main(String[] args) {
		// Initialize the Firefox driver
		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/webelements/dynamic-controls");

		System.out.println("Page title: " + driver.getTitle());

		// Find the checkbox
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		// Find the toggle button and click it
		WebElement toggleCheckbox =driver.findElement(By.xpath("//button[text()='Toggle Checkbox']"));
        toggleCheckbox.click();

		// Check if it is displayed on the page
		System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());
		// Click the button again
		toggleCheckbox.click();
		
		// Check if it is displayed on the page
		System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());

		// Close the browser
		driver.quit();
	}

}