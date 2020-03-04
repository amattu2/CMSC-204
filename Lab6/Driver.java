/**
 * Chapter 21 Hashing Tests
 * This implements the following hashing methods:
 * - Linear Probing (If array[index] is not null, index = index + 1 until it's null)
 * - Linear-Quotient (Division hashing)
 * 
 * @author Alec M
 * @date 03/04/2020
*/
public class Driver {
	/**
	 * Test driver method
	 */
    public static void main(String args[]) {
        // Create Array
        int a[] = new int[10];
        a[0] = 15;
        a[1] = 54;
        a[2] = 13;
        a[3] = 10;
        a[4] = 135;
        a[5] = 114;
        a[6] = 49;
        a[7] = 174;
        a[8] = 27;
        a[9] = 24;
        
        // Run Tests
        Driver.linearProbing(a, 13);
        Driver.linearQuote(a, 13);
    }
    
    /**
     * Use linear probing hashing mechanism
     * 
     * @param Integer array[]
     * @param Integer new array size
     */
    private static void linearProbing(int a[], int size) {
    	// Create "Hash Table"
    	Integer array[] = new Integer[size];
    	
    	// Loop through provided array
        for (int i = 0; i < a.length; i++) {
        	// Create hash key
        	int index = a[i] % size;
        	// Monitor loop count
        	int lc = 0;
        	// Monitor safe index assignment
        	int safe = 1;
        	
        	// Find null spot
        	while (array[index] != null) {
        		if (index+1 >= size) { index = 0; lc++; }
        		if (lc > 1) { System.out.println("Couldn't find a spot for: " + a[i]); safe = 0; break; }
        		
        		index = index + 1;
        	}
        	
        	// Assign value (if we found an index)
        	if (safe == 1) {
        		array[index] = a[i];
        	}
        }
        
        // Loop through created array
        Driver.printHeader("<<<< Linear Probing Hashing >>>>");
        for (int i = 0; i < array.length; i++) {
        	System.out.println(i + ": " + array[i]);
        }
    }
     
    /**
     * Use linear-quotient hashing mechanism
     * 
     * @param Integer array[]
     * @param Integer new array size
     */
    private static void linearQuote(int a[], int size) {
        // Create "Hash Table"
        Integer array[] = new Integer[size];
        
        // Loop through provided array
        for (int i = 0; i < a.length; i++) {
            int pk = a[i];
            int ip = pk % size;
            int q = pk / size;
            int offset = q % size != 0 ? q : 19;
            
            if (array[ip] != null) {
                while (array[ip] != null) {
                    ip = (ip + offset) % size;
                }
            }
            
            // Assign Value
            array[ip] = pk;
        }
         
        // Loop through created array
        Driver.printHeader("<<<< Linear-Quotient (Division) Hashing >>>>");
        for (int i = 0; i < array.length; i++) {
        	System.out.println(i + ": " + array[i]);
        }
     }
    
    /**
     * Print header
     */
    private static void printHeader(String middleText) {
    	// Create header/footer string
    	String ts = "";
    	
    	// Add to header/footer string
    	for (int i = 0; i < middleText.length(); i++) {
    		ts += "=";
    	}
    	
    	// Output header
    	System.out.println(ts);
    	// Output text
    	System.out.println(middleText);
    	// Output footer
    	System.out.println(ts);
    }
}