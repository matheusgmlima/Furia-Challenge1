package src.main.Exceptions;

public class SendingMessageError extends RuntimeException {
    public SendingMessageError(String message) {
        super(message);
    }
}
