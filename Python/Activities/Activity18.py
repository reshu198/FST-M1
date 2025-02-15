# activity 17 - write to csv file
# import pandas
import pandas

import pandas as pd

# Create a dictionary to hold our data 
data={
    "Usernames" : ["admin", "Chales" , "John"],
    "Passwords" : ["password", "Chale13","AllMight" ],
}


# Convert dictionary to lists of dataframe
dataframe= pandas.DataFrame(data)

print(dataframe)

# Write dataframe to CSV file 
dataframe.to_csv ('Activities/OutputFiles/users.csv' , index= False)



# Read from file 
dataframe = pd.read_csv('Activities/OutputFiles/users.csv')

	
# Print the full data
print("Full Data: ")
print(dataframe)
 
# Print the values in the Usernames column only
print("===============")
print("Usernames:")
print(dataframe["Usernames"])
 
# Print the username and password of the second row
print("===============")
print("Username: ", dataframe["Usernames"][1], " | ", "Password: ", dataframe["Passwords"][1])
 
#Sort the Usernames column in ascending order
print("====================================")
print("Data sorted in ascending Usernames:")
print(dataframe.sort_values('Usernames'))
 
#Sort the Passwords column in descending order
print("====================================")
print("Data sorted in descending Passwords:")
print(dataframe.sort_values('Passwords', ascending=False))