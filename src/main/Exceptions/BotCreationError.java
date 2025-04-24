package src.main.Exceptions;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotCreationError extends RuntimeException {
  public BotCreationError(String message) {
    super(message);
  }
}
