
public class DonationManager implements DonationManageInterface {

	@Override
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DonationPackage[] managerArrayPackage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Volunteer[] managerArrayVolunteer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recipient[] managerArrayRecipient() {
		// TODO Auto-generated method stub
		return null;
	}

}
