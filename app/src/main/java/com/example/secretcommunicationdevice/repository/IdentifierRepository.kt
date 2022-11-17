package com.example.secretcommunicationdevice.repository

import android.content.Context
import java.util.*

class IdentifierRepository {
    companion object {
        private const val defaultTranslation = "identity"

        fun getIdentity(context: Context): String {
            if (!context.fileList().contains(defaultTranslation)) {
                context.openFileOutput(defaultTranslation, Context.MODE_PRIVATE).use {
                    it.write(UUID.randomUUID().toString().toByteArray())
                }
            }
            return context.openFileInput(defaultTranslation).bufferedReader().readLine()
        }
    }
}