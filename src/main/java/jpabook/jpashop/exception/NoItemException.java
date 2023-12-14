package jpabook.jpashop.exception;

public class NoItemException extends RuntimeException{
    public NoItemException() {
        super();
    }

    public NoItemException(String message) {
        super(message);
    }

    public NoItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoItemException(Throwable cause) {
        super(cause);
    }
}
