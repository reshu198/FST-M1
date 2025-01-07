# Activity  19 :- Write to excel sheet

# Import pandas
import pandas
from pandas import ExcelWriter

# Create a dictionary that will be used to create the DataFrame
data = {
	'FirstName':["Shekhar", "Avinash", "Tejas"],
	'LastName':["Shah", "Kati", "Rath"],
	'Email':["shekhar@example.com", "avinashK@example.com", "tejas.rath@example.com"],
	'PhoneNumber':["4537829158", "4892184058", "4528727830"]
}

# Create the DataFrame that will be written to the excel file
dataframe = pandas.DataFrame(data)

# Print the dataframe
print(dataframe)

# Write the dataframe to a Excel file
writer = ExcelWriter('Activities/OutputFiles/userlist.xlsx')
dataframe.to_excel(writer, 'UserInfo', index = False)

# Commit data to the Excel file
writer.close()