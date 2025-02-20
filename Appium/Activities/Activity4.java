package Activities;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.net.URI;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.dialer");
        options.setAppActivity(".extensions.GoogleDialtactsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URI("http://localhost:4723").toURL();

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Test method
    @Test
    public void contactsTest() throws InterruptedException {
        // Find and click the add button
        driver.findElement(AppiumBy.id("empty_list_view_action")).click();

        // Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.EditText[@text='First name']")
        ));

        // Enter the details
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='First name']")).sendKeys("Sharan");
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='Last name']")).sendKeys("G");
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='Phone']")).sendKeys("8881482900");
        
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).click();
        // Click Save
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.contacts:id/editor_menu_save_button\"]")).click();

        Thread.sleep(100);
        // Wait for contact to save
    //   wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("large_title")));

        // Assertion
        String contactName = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.android.contacts:id/large_title\"]")).getText();
        
        assertEquals(contactName, "Sharan G");
        
        System.out.println(contactName);
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close 
        driver.quit();
    }
}
