package activities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Activity9 {
	public static void main(String[] args) {
		// declaring Arraylist of String objects
		ArrayList<String> myList = new ArrayList<String>();

		// Adding objects to the List at default index
		myList.add("Apple");
		myList.add("Mango");
		myList.add("Pineapple");

		// Adding object at specific index
		myList.add(1, "Papaya");
		myList.add(3, "Melon");

		// 1. print all elements using a loop
		System.out.println("Print All the Objects:");
		for (String name : myList) {
			System.out.println(name);
		}

		/*
		 * // //2. print all elements using an iterator // Iterator<String> iter
		
		 */

		// to retrieve the element from a certain index
		System.out.println("3rd element in the list is: " + myList.get(2));

		// To search if any element exist in the list
		System.out.println("Is Mango in list ? : " + myList.contains("Mango"));

		// To get the size of the list
		System.out.println("Size of MyList: " + myList.size());

		// To remove any element from the list
		myList.remove("Papaya");

		System.out.println("New Size of MyList: " + myList.size());
	}
}