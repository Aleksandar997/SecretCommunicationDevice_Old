package com.example.secretcommunicationdevice.repository

import android.content.Context
import com.example.secretcommunicationdevice.models.Translation
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class TranslationRepository {
    companion object {
        private val defaultTranslation = "translations/english"

        fun getTranslation(context: Context): Translation {
            val jsonFileString = getJsonDataFromAsset(context, "$defaultTranslation.json")
            return Gson().fromJson<Translation>(jsonFileString)
        }

        inline fun <reified T> Gson.fromJson(json: String?) = fromJson<T>(json, object: TypeToken<T>() {}.type)

        private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }
    }
}