# Activity 1 - user input - 

#ask user for name and age as input
name = input( "What is your name: " )
age = int( input( "How old are you: " ) )

# calculate the year when user will trun 100 years 
year = str( ( 2025 - age ) + 100 )

# print the year 
print( name + " will be 100 years old in the year " + year )