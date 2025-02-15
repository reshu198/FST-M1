package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
        ArrayList<Integer> numList = new ArrayList<Integer>();
        Random indexGen = new Random();
        
        System.out.print("Enter the numbers for the list separated by enter keyword:(Enter a EOL or any non-integer to stop)");
 
        //Loop to take only integers from console
        while(scan.hasNextInt()) {
        	numList.add(scan.nextInt());//only accepts integer
        }
 
        //Add user entered integers to the list
        Integer nums[] = numList.toArray(new Integer[0]);
        
        //generate a random index
        int index = indexGen.nextInt(nums.length);
        
        //print the random index and the value at that index
        System.out.println("Random Index generated: " + index);
        System.out.println("Value in array at generated index: " + nums[index]);
 
        scan.close();
    }
}