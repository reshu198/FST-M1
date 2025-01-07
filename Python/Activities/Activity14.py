def fibonacci (number):
    if number <=1:
        return number 
    else : 
        return (fibonacci(number-1) + fibonacci(number-2))
nterms = int(input("Enter a number: "))

## check entered number and print fabonacci series 
if nterms <=0:
    print ("Please enter a positive number")
else:
    print ("Fabonacci sequenc: ")
    for i in range(nterms):
        print(fibonacci(i))



    
        