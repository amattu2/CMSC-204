
public class RecipientLine implements RecipientLineInterface {
	public RecipientLine(int i) {
		// TODO Auto-generated constructor stub
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
