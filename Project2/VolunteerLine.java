/**
 * @author Alec M.
 * @date 02/13/2020
 * @version 0.01a
 */
public class VolunteerLine implements VolunteerLineInterface {
	// Variables
	private MyQueue<Volunteer> queue;
	
	/**
	 * Constructor method
	 */
	public VolunteerLine() {
		this.queue = new MyQueue<Volunteer>(10);
	}
	
	/**
	 * Constructor method
	 * 
	 * @param Int size
	 */
	public VolunteerLine(int size) {
		this.queue = new MyQueue<Volunteer>(size);
	}

	/**
	 * Add a volunteer to the queue
	 * 
	 * @param Volunteer volunteer
	 * @return Success
	 * @throws VolunteerException
	 */
	@Override
	public boolean addNewVolunteer(Volunteer v) throws VolunteerException {
		// Variables
		boolean success = this.queue.enqueue(v);
		
		// Checks
		if (!success) {
			throw new VolunteerException("The Volunteer Queue is Full");
		}
		
		// Return
		return success;
	}

	/**
	 * Return the next volunteer in line
	 * 
	 * @return Volunteer volunteer
	 * @throws VolunteerException
	 */
	@Override
	public Volunteer volunteerTurn() throws VolunteerException {
		// Variables
		Volunteer volunteer = this.queue.dequeue();
		
		// Checks
		if (volunteer == null) {
			throw new VolunteerException("The Volunteer Queue is empty");
		}
		
		// Return
		return volunteer;
	}

	/**
	 * Determine if the line is empty
	 * 
	 * @return Boolean empty
	 */
	@Override
	public boolean volunteerLineEmpty() {
		return this.queue.isEmpty();
	}

	/**
	 * Convert the queue to a array
	 * 
	 * @return Volunteer[] array
	 */
	@Override
	public Volunteer[] toArrayVolunteer() {
		// Variables
		Volunteer[] newA = new Volunteer[this.queue.size()];
		Object[] oldA = this.queue.toArray();
		int i = 0;
		
		// Loops
		for (Object volunteer : oldA) {
			if (volunteer == null) { continue; }
			
			newA[i++] = (Volunteer) volunteer;
		}
		
		return newA;
	}
}
