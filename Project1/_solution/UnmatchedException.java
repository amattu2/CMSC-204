package _solution;

public class UnmatchedException extends Exception {
	public UnmatchedException(String Message, Throwable Error) {
		super(Message, Error);
	}
}