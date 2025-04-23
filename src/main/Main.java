package src.main;


import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import src.main.Entities.FuriaBot;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new FuriaBot());
            System.out.println("Bot iniciado com sucesso!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
