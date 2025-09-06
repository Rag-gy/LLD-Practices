package exception;

public class AlreadyApproved extends RuntimeException {
    public AlreadyApproved(String message) {
        super(message);
    }
}
