// Imports
import java.util.Comparator;

/**
 * A CIRCULAR singly-linked implementation
 * 
 * @author Alec M.
 * @date 03/08/2020
 * @version 0.02a
 */
public class SortedCircularLinkedList<T> extends BasicCircularLinkedList<T> {
	// Variables
	private Comparator<T> comparator = null;
	
	public SortedCircularLinkedList(Comparator<T> c) {
		this.comparator = c;
	}
	
	public void add(T data) {
		
	}
}
