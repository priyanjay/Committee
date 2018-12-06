package exceptions;

public class DriverNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	public DriverNotFoundException() {
		super();
	}

	public DriverNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DriverNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public DriverNotFoundException(String message) {
		super(message);
	}

	public DriverNotFoundException(Throwable cause) {
		super(cause);
	}

}
