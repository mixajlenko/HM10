public class ScaryException extends Exception {

    public ScaryException() {
    }

    public ScaryException(String message) {
        super(message);
    }

    public ScaryException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScaryException(Throwable cause) {
        super(cause);
    }

    public ScaryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
