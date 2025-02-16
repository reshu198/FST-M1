package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearch extends BaseClass{
	@Given("User is on the Google homepage")
	public void userIsOnGooglePage() throws Throwable {
		//Open the browser
		driver.get("https://www.google.com");
	}
	
	@When("they type Cheese and hits ENTER")
	public void userTypesInCheeseHitEnter() throws Throwable  {
		driver.findElement(By.name("q")).sendKeys("Cheese", Keys.ENTER);
	}
	
	@Then("it should show how many Search results were found")
	public void searchResultsDisplay() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("hdtb-tls"))).click();
		String resultStats = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats"))).getText();
		System.out.println("Number of results found: " + resultStats);
	}
	
}