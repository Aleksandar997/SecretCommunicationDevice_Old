package com.example.secretcommunicationdevice.services

import android.content.Context
import com.example.secretcommunicationdevice.repository.TranslationRepository

class MorseCodeParser {
    fun parse(textParam: String, context: Context): LongArray {
        var data = TranslationRepository.getTranslation(context)
        val text = textParam.uppercase()
        val res: MutableList<Long> = mutableListOf(0)

        for (letter: Char in text) {
            if (letter == ' ') {
                res.add(data.sentenceConfig.endOfWordPause)
                res.addAll(data.sentenceConfig.betweenLettersPattern)
                continue
            }
            val vibrationTimes = data.data.getValue(letter.toString())
            if (vibrationTimes != null) {
                vibrationTimes.iterator().forEach {
                    val vibrationTime = data.letterConfig.getValue(it)
                    if (vibrationTime != null) {
                        res.add(vibrationTime.toLong())
                        res.addAll(data.sentenceConfig.betweenLettersPattern)
                    }

                }
            }
        }
        return res.toLongArray();
    }
}