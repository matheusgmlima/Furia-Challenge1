package src.main.Exceptions;
public class BotActivationError extends RuntimeException {
  public BotActivationError(String message) {
    super(message);
  }
}
