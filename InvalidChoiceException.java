package sdbms;

public class InvalidChoiceException extends RuntimeException {
	private String message;

	public InvalidChoiceException(String message) {
		//super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	

}
