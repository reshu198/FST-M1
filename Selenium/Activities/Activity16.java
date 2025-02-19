package activities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/webelements/selects");
		System.out.println("Page title is: " + driver.getTitle());

		// Find the dropdown
		WebElement select1 = driver.findElement(By.cssSelector("select.h-10"));
		// Pass the WebElement to the Select object
		Select dropdown = new Select(select1);

		// Select the second option using visible text
		dropdown.selectByVisibleText("Two");
		// Print the selected option
		System.out.println("Second option: " + dropdown.getFirstSelectedOption().getText());

		// Select the third option using index
		dropdown.selectByIndex(3);
		// Print the selected option
		System.out.println("Third option: " + dropdown.getFirstSelectedOption().getText());

		// Select the fourth option using value attribute
		dropdown.selectByValue("four");
		// Print the selected option
		System.out.println("Fourth option: " + dropdown.getFirstSelectedOption().getText());

		// Print all the options
		List<WebElement> allOptions = dropdown.getOptions();
		System.out.println("Options in the dropdown: ");
		for (WebElement option : allOptions) {
			System.out.println(option.getText());
		}

		// Close the browser
		driver.quit();
	}
}
