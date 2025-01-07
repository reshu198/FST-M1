# Activity 4 - Rock- Paper -Scissers with continue

#Get the player names
Player1=input("Please enter your name: ")
Player2=input("Please enter your name: ")

# While looping endlessly
while True:

  # Get the users choices
  Player1_answer = input(Player1 + ", do you want to choose rock, paper or scissors? ").lower()
  Player2_answer = input(Player2 + ", do you want to choose rock, paper or scissors? ").lower()

  # Run the algorithm to see who wins
  if Player1_answer == Player2_answer:
    print("It's a tie!")
  elif Player1_answer == 'rock':
      if Player2_answer == 'scissors':
        print("Rock wins!")
      else:
        print("Paper wins!")
  elif Player1_answer == 'scissors':
      if Player2_answer == 'paper':
        print("Scissors win!")
      else:
        print("Rock wins!")
  elif Player1_answer == 'paper':
      if Player2_answer == 'rock':
        print("Paper wins!")
      else:
        print("Scissors win!")
  else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")

  # Ask them if they want to play again
  repeat = input("Do you want to play another round? Yes/No: ").lower()
    
  # If they say yes, don't do anything
  if(repeat == "yes"):
    pass
  # If they say no, exit the game
  elif(repeat == "no"):
    raise SystemExit
  # If they say anything else, exit with an error message.
  else:
    print("You entered an invalid option. Exiting now.")
    raise SystemExit

  print("Game started again")