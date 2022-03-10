package priv.mw.exception;

public class TidyException extends Exception{
    public TidyException() {
        super();
    }

    public TidyException(String message) {
        super(message);
    }

    public TidyException(String message, Throwable cause) {
        super(message, cause);
    }
}
