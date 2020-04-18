import java.util.HashSet;
import java.util.Set;

public class Question3 {
	/**
	 * Question 3
	 */
	public static Set intersection(Set a, Set b) {
		// Variables
		Set<Object> intersected = new HashSet<Object>();
		
		// Check all items in set a
		for (Object item : a) {
			if (b.contains(item)) {
				intersected.add(item);
			}
		}
		// Check all items in set b
		for (Object item : b) {
			if (a.contains(item)) {
				intersected.add(item);
			}
		}
		
		// return combined
		return intersected;
	}
}
