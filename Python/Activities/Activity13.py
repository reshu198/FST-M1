# Activity 13 :- Adding List Numbers 

# Custom function to calculate sum
def calculate_sum(numbers):
	sum = 0
	for number in numbers:
		sum +=int(number)
	return sum

# Take input from user 
numList = list(input("Enter number seperated by commas:").split(","))

# Call the sum() function with numList as argument
result = calculate_sum(numList)

# Print result with message
print("The sum of all the elements is: " + str(result))