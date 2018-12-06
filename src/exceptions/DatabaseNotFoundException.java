package exceptions;

public class DatabaseNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public DatabaseNotFoundException() {
		super();
	}

	public DatabaseNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DatabaseNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public DatabaseNotFoundException(String message) {
		super(message);
	}

	public DatabaseNotFoundException(Throwable cause) {
		super(cause);
	}

}
