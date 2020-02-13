/**
 * @author Alec M.
 * @date 02/13/2020
 * @version 0.01a
 */
public class VolunteerLine implements VolunteerLineInterface {
	public VolunteerLine(int i) {
	}

	@Override
	public boolean addNewVolunteer(Volunteer v) throws VolunteerException {
		return false;
	}

	@Override
	public Volunteer volunteerTurn() throws VolunteerException {
		return null;
	}

	@Override
	public boolean volunteerLineEmpty() {
		return false;
	}

	@Override
	public Volunteer[] toArrayVolunteer() {
		return null;
	}
}
