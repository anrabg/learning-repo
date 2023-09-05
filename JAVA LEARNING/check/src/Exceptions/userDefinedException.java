package Exceptions;

public class userDefinedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public userDefinedException(String str) {
		// Calling constructor of parent Exception
		super(str);
	}
}
