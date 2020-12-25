package com.github.moholiaghat.telson.service

import com.github.moholiaghat.telson.commons.gson
import com.google.gson.JsonParser

// ToDo MoHoLiaghat: add ioc
// ToDo MoHoLiaghat: add log

class PrettyJson {

    fun makePretty(json: String): String {
        return try {
            val jsonElement = JsonParser.parseString(reformatJson(json))
            gson.toJson(jsonElement)
        } catch (e: Exception) {
            "please send text as json format."
        }
    }

    // ToDo MoHoLiaghat: should check
    private fun reformatJson(text:String) =
        text.substring(1, text.lastIndex).replace("\\", "")
}
