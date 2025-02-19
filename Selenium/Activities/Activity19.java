package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Activity19 {
    public static void main(String[] args) {
    	 WebDriver driver = new ChromeDriver();
    	    
         driver.get("https://training-support.net/webelements/alerts");
         System.out.println("Page title: " + driver.getTitle());

        
        driver.findElement(By.id("confirm")).click();

      
        Alert confirmAlert = driver.switchTo().alert();

        
        String alertText = confirmAlert.getText();
        System.out.println("Text in alert: " + alertText);

        confirmAlert.accept();

        // Can also close the alert by clicking Cancel
        // confirmAlert.dismiss();

        System.out.println(driver.findElement(By.id("result")).getText());

      
        driver.quit();
    }
}