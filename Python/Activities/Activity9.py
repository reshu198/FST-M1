# Activity 9 : Combining Lists 

# Take input from user for listOne and listTwo 
listOne = list(input("Enter some numbers for List One : ").split(","))
listTwo = list(input("Enter some numbers for List Two: ").split(","))

# Print the lists
print("First List ", listOne)
print("Second List ", listTwo)

# Declare a third list that will contain the result
thirdList = []

# Iterate through first list to get odd elements
for num in listOne:
    if (int(num) % 2 != 0):
        thirdList.append(num)
        
# Iterate through first list to get even elements
for num in listTwo:
    if (int(num) % 2 == 0):
        thirdList.append(num)

# Print result
print("result List is:")
print(thirdList)