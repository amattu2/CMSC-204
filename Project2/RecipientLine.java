/**
 * @author Alec M.
 * @date 02/13/2020
 * @version 0.01a
 */
public class RecipientLine implements RecipientLineInterface {
	// Variables
	private MyQueue<Recipient> queue;
	
	/**
	 * Constructor method
	 */
	public RecipientLine() {
		this.queue = new MyQueue<Recipient>(10);
	}
	
	/**
	 * Constructor method
	 * 
	 * @param Int size
	 */
	public RecipientLine(int size) {
		this.queue = new MyQueue<Recipient>(size);
	}

	/**
	 * Add a recipient to the queue
	 * 
	 * @param Recipient recipient
	 * @return Success
	 * @throws RecipientException
	 */
	@Override
	public boolean addNewRecipient(Recipient r) throws RecipientException {
		// Variables
		boolean success = this.queue.enqueue(r);
		
		// Checks
		if (!success) {
			throw new RecipientException("The Recipent Queue is Full");
		}
		
		// Return
		return success;
	}

	/**
	 * Return the next recipient in line
	 * 
	 * @return Recipient recipient
	 * @throws RecipientException
	 */
	@Override
	public Recipient recipientTurn() throws RecipientException {
		// Variables
		Recipient recipient = this.queue.dequeue();
		
		// Checks
		if (recipient == null) {
			throw new RecipientException("The Recipient Queue is empty");
		}
		
		// Return
		return recipient;
	}

	/**
	 * Determine if the line is empty
	 * 
	 * @return Boolean empty
	 */
	@Override
	public boolean recipientLineEmpty() {
		return this.queue.isEmpty();
	}

	/**
	 * Convert the queue to a array
	 * 
	 * @return Recipient[] array
	 */
	@Override
	public Recipient[] toArrayRecipient() {
		// Variables
		Recipient[] newA = new Recipient[this.queue.size()];
		Object[] oldA = this.queue.toArray();
		int i = 0;
		
		// Loops
		for (Object recipient : oldA) {
			if (recipient == null) { continue; }
			
			newA[i++] = (Recipient) recipient;
		}
		
		return newA;
	}
}
