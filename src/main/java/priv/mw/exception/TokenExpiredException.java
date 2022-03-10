package priv.mw.exception;

public class TokenExpiredException extends TidyException{
    public TokenExpiredException() {
        super();
    }

    public TokenExpiredException(String message) {
        super(message);
    }
}
