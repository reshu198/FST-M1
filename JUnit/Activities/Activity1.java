
package activities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

	public class Activity1 {
	    // Test fixtures
	    static ArrayList<String> list;

	    // Initialize test fixtures before each test method
	    @BeforeEach
	    void setUp() throws Exception {
	        list = new ArrayList<String>();
	        list.add("alpha"); // at index 0
	        list.add("beta"); // at index 1
	    }

	    // Test method to test the insert operation
	    @Test
	    public void insertTest() {
	    	//Expected List
	    	List<String> expectedList = Arrays.asList("alpha", "beta" ,"gamma");
	        // Assertion for size
	        assertEquals(2, list.size(), "Wrong size");
	        // Add new element
	        list.add(2, "gamma");
	        // Assert with new elements
	        assertEquals(3, list.size());
	        
	        //Assert list elements
	        assertIterableEquals(expectedList, list);
	    
	    }

	    // Test method to test the replace operation
	    @Test
	    public void replaceTest() {
	    	//Expected List
	    	List<String> expectedList = Arrays.asList("alpha", "beta" ,"Charlie");
	        // Assertion for size of the list BEFORE adding an element
	        assertEquals(2, list.size());
	        // Add new element
	        list.add(2, "gamma");
	        list.set(2, "Charlie");
	        // Assert with new elements
	        assertEquals(3, list.size());
	        
	        //Assert list elements
	        assertIterableEquals(expectedList, list);
	    
	    }
	   
	}
	

