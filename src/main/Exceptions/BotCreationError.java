package src.main.Exceptions;

public class BotCreationError extends RuntimeException {
  public BotCreationError(String message) {
    super(message);
  }
}
