package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {

	public static void main(String[] args) {
		Map<Integer, String> mp = new HashMap<Integer, String>();
		mp.put(5, "Red");
		mp.put(1, "Orange");
		mp.put(2, "Blue");
		mp.put(3, "Green");
		mp.put(4, "Yellow");

		// Print the map
		System.out.println("The Values in the Map are : " + mp);

		// Remove one color and print the map
		System.out.println("Color-Blue is removed :" + mp.remove(2));
		System.out.println("The updated Values in the Map are : " + mp);

		// put back an element at the removed key
		mp.put(2, "Pink");

		// Check of Green exists
		if (mp.containsValue("Green")) {
			System.out.println("Green color exists in the Map");
		} else {
			System.out.println("Green color does not exist in the Map");
		}

		// Print the size of the map
		System.out.println("The size of the map is : " + mp.size());

		// Print updated Map
		System.out.println("The Values in the Map are : " + mp);

	}

}