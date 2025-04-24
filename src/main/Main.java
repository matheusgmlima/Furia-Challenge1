package src.main;


import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import src.main.Entities.FuriaBot;
import src.main.Exceptions.BotCreationError;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new FuriaBot());
            System.out.println("Bot is running...");
        } catch (TelegramApiException e) {
            throw new BotCreationError("Error on bot creation!");
        }
    }
}
