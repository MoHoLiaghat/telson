package com.github.moholiaghat.telson

import com.github.moholiaghat.telson.config.App
import com.github.moholiaghat.telson.service.TelSonBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession


class TelSonApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App.configureApp()

            TelegramBotsApi(DefaultBotSession::class.java).apply {
                registerBot(TelSonBot())
            }
        }
    }
}
