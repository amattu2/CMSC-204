
 
 /** RecipientLineInterface Container Interface represents the interface for the RecipientLine Class
 
 * The class that uses this  interface uses a Queue of Recipients to simulate queuing and dequeuing Recipients
 * to and from the RecipientLine.
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */
import java.util.NoSuchElementException;


public interface RecipientLineInterface {

	/**
	 * Provide two constructors:
	 * RecipientLine(int size) make internal queue this size
	 * RecipientLine() make internal queue default aize
	 */
	/**
	 * Enqueue a new Recipient to the queue of the Recipients in the Recipient line
	 * @param rc a Recipient
	 *return true if recipient is queued successfully
	 * @throws RecipientException("The Recipent Queue is Full") if queue is full
	 */
	public boolean  addNewRecipient(Recipient rc ) throws RecipientException;
	 
	/**
	 * When it is the recipient turn, recipient will be dequeued from the recipient line
	 * @return a Recipient object
	 * @throws RecipientException("The Recipient Queue is empty") if there is no Recipient in the line
	 */
	
	public  Recipient recipientTurn ()  throws RecipientException ;
	
	/**
	 * check if Recipient  queue line is empty
	 * @return true if queue is empty, false otherwise
	 */
	public  boolean recipientLineEmpty();
	 
	/**
	 * Returns an array of the Recipients in the queue.  
	 * Because of type erasure by the JVM at run-time, the array of type T that the generic queue
	 * returns from the call to queue.toArray() is an array of type Object, i.e., Object[] temp. 
	 * But since the individual elements of the array are still Recipients, we can copy them one 
	 * by one into a new array	of type Recipient and cast each one to Recipient. 
	 * So create a new array of Recipients of the same length as temp, run a for-loop that casts each element 
	 * of temp to Recipient and copies it to the corresponding position in the new array.  Then return the new array.
	 * @return an array of the Recipients in the queue
	 */
	public Recipient[] toArrayRecipient();
	 
	 
}
