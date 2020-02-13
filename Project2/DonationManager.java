/**
 * @author Alec M.
 * @date 02/13/2020
 * @version 0.01a
 */
public class DonationManager implements DonationManageInterface {
	@Override
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		return false;
	}

	@Override
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		return false;
	}

	@Override
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		return false;
	}

	@Override
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		return 0;
	}

	@Override
	public DonationPackage[] managerArrayPackage() {
		return null;
	}

	@Override
	public Volunteer[] managerArrayVolunteer() {
		return null;
	}

	@Override
	public Recipient[] managerArrayRecipient() {
		return null;
	}
}
