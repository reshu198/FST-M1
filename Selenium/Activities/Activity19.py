from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

# Start the Driver
with webdriver.Firefox() as driver:
    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=20)

    # Navigate to the URL
    driver.get("https://training-support.net/webelements/alerts")

    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find and click the button to open the alert
    driver.find_element(By.ID, "confirmation").click()

    # Switch focus to the alert
    confirmAlert = wait.until(EC.alert_is_present())

    # Print the text in the alert
    alertText = confirmAlert.text
    print("Text in alert: " + alertText)

    # Close the alert by clicking OK
    confirmAlert.dismiss()

    # Print the message
    print(driver.find_element(By.ID, "result").text)

    driver.quit()