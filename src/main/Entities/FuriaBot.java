package src.main.Entities;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import src.main.Exceptions.SendingMessageError;
import src.main.Functions.ProximosJogos;
import src.main.Functions.UltimosJogos;

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
                SendMessage message = getSendMessage(chatId, "Bem vindo, furioso! Escolha uma das opções abaixo:");

                try{
                    execute(message);
                }
                catch(TelegramApiException e){
                    throw new SendingMessageError("Error in conversation");
                }
            }
            else{
                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText("❌ Comando não reconhecido. Use /start para ver as opções.");
            }
        }

        if(update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            long chatId = update.getCallbackQuery().getMessage().getChatId();

            SendMessage response = new SendMessage();
            response.setChatId(String.valueOf(chatId));

            switch (callbackData){
                case "UltimosJogos":
                    response.setText(UltimosJogos.listarUltimos5Jogos());

                    InlineKeyboardMarkup markup = getInlineKeyboardMarkup();

                    response.setReplyMarkup(markup);
                    break;
                case "ProximosJogos":
                    response.setText(ProximosJogos.listarProximosJogos());
                    break;
                case "MaisJogos":
                    response.setText(UltimosJogos.listarUltimosJogos()); // aqui mostra a lista completa
                    break;
                case "VoltarMenu":
                    response = getSendMessage(chatId, "Escolha sua próxima opção, furioso!"); // Volta ao menu principal
                    break;
                default:
                    response.setText("Opção inválida!");
            }
            try {
                execute(response);
            }
            catch(TelegramApiException e){
                throw new SendingMessageError("Error in conversation");
            }
        }
    }

    private static InlineKeyboardMarkup getInlineKeyboardMarkup() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> newRows = new ArrayList<>();
        List<InlineKeyboardButton> newRow = new ArrayList<>();

        InlineKeyboardButton maisJogosBtn = new InlineKeyboardButton("Mais jogos?");
        InlineKeyboardButton VoltarMenuBtn = new InlineKeyboardButton("Voltar ao menu?\uD83D\uDD01");
        maisJogosBtn.setCallbackData("MaisJogos");
        VoltarMenuBtn.setCallbackData("VoltarMenu");


        newRow.add(maisJogosBtn);
        newRow.add(VoltarMenuBtn);
        newRows.add(newRow);
        markup.setKeyboard(newRows);
        return markup;
    }

    private static SendMessage getSendMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

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
        return message;
    }
}

