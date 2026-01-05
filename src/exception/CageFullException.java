package exception;

public class CageFullException extends RuntimeException {

    public CageFullException(String message) {
        super(message);
    }
}
