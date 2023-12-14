package jpabook.jpashop.exception;

public class NoUserException extends RuntimeException {
    public NoUserException() {
        super();
    }

    public NoUserException(String message) {
        super(message);
    }

    public NoUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoUserException(Throwable cause) {
        super(cause);
    }
}
