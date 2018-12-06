package exceptions;

public class SQLSyntaxException extends Exception{
	private static final long serialVersionUID = 1L;
	public SQLSyntaxException() {
		super();
	}

	public SQLSyntaxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SQLSyntaxException(String message, Throwable cause) {
		super(message, cause);
	}

	public SQLSyntaxException(String message) {
		super(message);
	}

	public SQLSyntaxException(Throwable cause) {
		super(cause);
	}

}
