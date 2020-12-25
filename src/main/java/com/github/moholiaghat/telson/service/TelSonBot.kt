package com.github.moholiaghat.telson.service

import com.github.moholiaghat.telson.config.App
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException


class TelSonBot : TelegramLongPollingBot() {
    private val prettyJson = PrettyJson()

    // ToDo MoHoLiaghat: should be multi thread
    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage() && update.message.hasText()) {
            val message = SendMessage().apply {
                text = prettyJson.makePretty(update.message.text)
                chatId = update.message.chatId!!.toString()
            }

            try {
                execute<Message, SendMessage>(message)
            } catch (e: TelegramApiException) {
                e.printStackTrace()
            }
        }
    }

    override fun getBotUsername(): String {
        return App.config.bot.username
    }

    override fun getBotToken(): String {
        return App.config.bot.token
    }
}
