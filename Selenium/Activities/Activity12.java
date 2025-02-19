package activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12 {
	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://www.training-support.net/webelements/dynamic-content");
		System.out.println("Page title: " + driver.getTitle());

		// Find the button and click it
		driver.findElement(By.id("genButton")).click();
		// Wait for the word to appear
		if (wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "release"))) {
			// Print the text to console
			System.out.println("Word found: " + driver.findElement(By.id("word")).getText());
		}

		driver.quit();
	}
}