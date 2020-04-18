
public class Question2 {
	public class LinearHash {
		String[] table;
		int used;
		int probeDist;
		
		/**
		 * Question 2A
		 * 
		 * Calculated by number of keys used divided by capacity
		 */
		public double load() {
			return this.used / this.table.length;
		}
		
		/**
		 * Question 2B
		 */
		public int insert(String value) {
			// Variables
			int key = value.hashCode();
			int hashcode = Math.abs(key % this.table.length);
			
			// Check if it exists
			if (this.table[hashcode] == null || this.table[hashcode] == "") {
				this.table[hashcode] = value; // assign value
				return hashcode; // index
			} else {
				int nextIndex = hashcode; // start at failed hashcode index
				while (this.table[nextIndex] != null || this.table[nextIndex] != "") {
					nextIndex += this.probeDist; // add probeDist to current failed index
				}
				this.table[nextIndex] = value; // assign value to next empty spot
				return nextIndex; // index
			}
		}
		
		/**
		 * Question 2C
		 */
		public int find(String value) {
			// Variables
			int foundIndex = -1; // default
			
			for (int i = 0; i < this.table.length; i++) {
				if (this.table[i] != null && this.table[i] != "" && this.table[i].equals(value)) {
					foundIndex = i; // found element at position i
					break; // end loop
				}
			}
			
			return foundIndex; // return default || index found
		}
		
		/**
		 * Question 2D
		 * 
		 * Based off of 2C
		 */
		public String delete(String value) {
			// Variables
			int foundIndex = -1; // default
			
			for (int i = 0; i < this.table.length; i++) {
				if (this.table[i] != null && this.table[i] != "" && this.table[i].equals(value)) {
					foundIndex = i; // found element at position i
					this.table[i] = ""; // "delete" value
					break; // end loop
				}
			}
			
			return foundIndex > -1 ? value : ""; // if we found the value, return it
		}
	}
}
