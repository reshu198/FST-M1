
package activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet();
		hs.add("R");
		hs.add("A");
		hs.add("S");
		hs.add("H");
		hs.add("M");
		hs.add("I");

		// Print HashSet
		System.out.println("The elements of the Set are : " + hs);

		// Print Size of the HashSet
		System.out.println("The size of the Set is : " + hs.size());

		// Remove element
		System.out.println("Remove element 'R' from the set : " + hs.remove("R"));

		// Remove element that does not exist in the set
		if (hs.remove("P")) {
			System.out.println("Element 'P' removed from the set");
		} else {
			System.out.println("Element 'P' does not exist in the Set !");
		}

		// Search for element E in the set
		System.out.println("Checking if 'I' exists in the Set... : " + hs.contains("I"));

		// Printing updated Set
		System.out.println("The elements of the Set are : " + hs);
	}
}
