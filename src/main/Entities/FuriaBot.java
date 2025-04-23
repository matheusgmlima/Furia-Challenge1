package src.main.Entities;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class FuriaBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "@challengefuria_bot"; // Substitua com @seu_bot
    }

    @Override
    public String getBotToken() {
        return "7502628820:AAEjKUyrBMB4Kki1E1KVPDQJ6sdLz-nMlRQ"; // Sua API Token
    }

    @Override
    public void onUpdateReceived(Update update) {

    }
}

