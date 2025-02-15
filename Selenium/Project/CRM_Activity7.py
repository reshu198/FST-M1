# Reading additional information
# Goal: Reading a popup that contains additional information about the account/lead.


# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
import time

# Start the Driver
with webdriver.Chrome() as driver:
  
#  Navigate to ‘http://alchemy.hguy.co/crm’
    driver.get("https://alchemy.hguy.co/crm/")

# Find and select the username and password fields
# Enter login credentials into the respective fields
    driver.find_element(By.ID,"user_name").send_keys("admin")
    driver.find_element(By.ID,"username_password").send_keys("pa$$w0rd")
    driver.find_element(By.ID,"bigbutton").click()
    homePageHeader = driver.find_element(By.ID,"tab0").text
    # print(homePageHeader)
    if(homePageHeader=="SUITECRM DASHBOARD"):
        print("Home Page Opened Successfully !")
    else:
        print("Login failed !")

# Navigate to Sales -> Leads
    driver.fullscreen_window()
    driver.find_element(By.ID,"grouptab_0").click()
    driver.find_element(By.ID,"moduleTab_9_Leads").click()
    time.sleep(2)
# In the table, find the Additional information icon at the end of the row of the lead
# information. Click it.
    driver.find_element(By.XPATH,"//span[@title='Additional Details']").click()
    time.sleep(2)
# Read the popup and print the phone number displayed in it.
    additionalDetailsMobile = driver.find_element(By.XPATH,"//span[@class='phone']").text
    print("The mobile number is :" , additionalDetailsMobile)

# Close the browser
    driver.quit()