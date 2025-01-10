# Activity 11 - fruit shop 

# define the fruit shop dictionary 
fruits ={
    "apple" : 80,
    "papaya" : 30,
    "grapes" : 50,
    "guava" : 20
}

# take input from user which fruit they want to buy
search_term= input ("what fruit would you like : ")

# check if fruit is available and provide the cost
if search_term in fruits: 
  print(search_term    + " costs " + str(fruits[search_term]) + " rupees" )
else:
  print("Fruit is out of stock")
