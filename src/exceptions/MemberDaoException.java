package exceptions;

public class MemberDaoException extends Exception {
	private static final long serialVersionUID = 1L;
	public MemberDaoException() {
		super();
	}

	public MemberDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MemberDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public MemberDaoException(String message) {
		super(message);
	}

	public MemberDaoException(Throwable cause) {
		super(cause);
	}

}
