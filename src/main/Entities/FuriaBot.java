package src.main.Entities;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import src.main.Exceptions.SendingMessageError;

import java.util.ArrayList;
import java.util.List;

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
        if(update.hasMessage() && update.getMessage().hasText()) {
            String startingMessage = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if(startingMessage.equals("/start")) {
                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText("Bem vindo, furioso! Escolha uma das opções abaixo:");

                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rows = new ArrayList<>();

                List<InlineKeyboardButton> row = new ArrayList<>();
                InlineKeyboardButton ultimosJogosBtn= new InlineKeyboardButton("Ultimos Jogos da FuriaCS🔫");
                ultimosJogosBtn.setCallbackData("UltimosJogos");

                InlineKeyboardButton proximosJogosBtn = new InlineKeyboardButton("Proximos Jogos da FuriaCS📅");
                proximosJogosBtn.setCallbackData("ProximosJogos");

                row.add(ultimosJogosBtn);
                row.add(proximosJogosBtn);
                rows.add(row);
                inlineKeyboardMarkup.setKeyboard(rows);

                message.setReplyMarkup(inlineKeyboardMarkup);

                try{
                    execute(message);
                }
                catch(TelegramApiException e){
                    throw new SendingMessageError("Error in conversation");
                }
            }
        }

        if(update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            long chatId = update.getCallbackQuery().getMessage().getChatId();

            SendMessage response = new SendMessage();
            response.setChatId(String.valueOf(chatId));

            switch (callbackData){
                case "UltimosJogos":
                    response.setText("ta funcionando");
                    break;
                case "ProximosJogos":
                    response.setText("ta funcionando");
                    break;
                default:
                    response.setText("Opção invalida");

            }
            try {
                execute(response);
            }
            catch(TelegramApiException e){
                throw new SendingMessageError("Error in conversation");
            }
        }
    }
}

