/**
 * @author Alec M.
 * @date 02/13/2020
 * @version 0.01a
 */
public class DonationManager implements DonationManageInterface {
	// Variables
	private Container container = new Container();
	private VolunteerLine vline = new VolunteerLine();
	private RecipientLine rline = new RecipientLine();
	
	/**
	 * Add new package to donation container
	 * 
	 * @param DonationPackage package
	 * @return Boolean success
	 * @throws ContainerException
	 */
	@Override
	public boolean managerLoadContainer(DonationPackage p) throws ContainerException {
		// Return
		return this.container.loadContainer(p);
	}

	/**
	 * Add new volunteer to the line
	 * 
	 * @param Volunteer volunteer
	 * @return Boolean success
	 * @throws VolunteerException
	 */
	@Override
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		// Return
		return this.vline.addNewVolunteer(v);
	}

	/**
	 * Add new recipient to the line
	 * 
	 * @param Recipient recipient
	 * @return Boolean success
	 * @throws RecipientException
	 */
	@Override
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		// Return
		return this.rline.addNewRecipient(r);
	}

	/**
	 * Simulate package donation
	 * 
	 * @return Integer ?
	 * @throws VolunteerExeption, RecipientException, ContainerException
	 */
	@Override
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		// Checks
		if (this.vline.volunteerLineEmpty()) {
			throw new VolunteerException("Volunteer Queue is empty");
		}
		if (this.rline.recipientLineEmpty()) {
			throw new RecipientException("Recipient Queue is empty");
		}
		if (this.container.removePackageFromContainer() != null) {
			this.vline.addNewVolunteer(this.vline.volunteerTurn());
			this.rline.recipientTurn();
		} else {
			throw new ContainerException("Container is empty");
		}
		
		// Default
		return 1;
	}

	@Override
	public DonationPackage[] managerArrayPackage() {
		// Return
		return this.container.toArrayPackage();
	}

	@Override
	public Volunteer[] managerArrayVolunteer() {
		// Return
		return this.vline.toArrayVolunteer();
	}

	@Override
	public Recipient[] managerArrayRecipient() {
		// Return
		return this.rline.toArrayRecipient();
	}
	
	/**
	 * Create a stringified version of class
	 * 
	 * @return String last donation
	 */
	public String toString() {
		return "Donated package " + this.container.toString();
	}
}
