package nl.pelssersconsultancy.exception;

public class PropertyNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PropertyNotFoundException(String message) {
        super(message);
    }

    public PropertyNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public PropertyNotFoundException(String message, Throwable throwable) {
        super(message,throwable);
    }
}