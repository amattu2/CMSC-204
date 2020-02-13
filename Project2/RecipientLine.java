/**
 * @author Alec M.
 * @date 02/13/2020
 * @version 0.01a
 */
public class RecipientLine implements RecipientLineInterface {
	public RecipientLine(int i) {
	}

	@Override
	public boolean addNewRecipient(Recipient rc) throws RecipientException {
		return false;
	}

	@Override
	public Recipient recipientTurn() throws RecipientException {
		return null;
	}

	@Override
	public boolean recipientLineEmpty() {
		return false;
	}

	@Override
	public Recipient[] toArrayRecipient() {
		return null;
	}
}
