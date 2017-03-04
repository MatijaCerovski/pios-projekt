package com.pios.web.error;

/**
 * Created by Matija on 3/4/2017.
 */
public final class UserAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 5861310557366287163L;

    public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistException(final String message) {
        super(message);
    }

    public UserAlreadyExistException(final Throwable cause) {
        super(cause);
    }

}
