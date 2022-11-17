package com.example.secretcommunicationdevice.services

import com.example.secretcommunicationdevice.http.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class ApiService {
    companion object {
        private val httpClient = HttpClient("http://192.168.0.50:5001/connect_peer")
        private val coroutineScope = CoroutineScope(Dispatchers.Default)
        fun registerId(id: String) = runBlocking {
//            coroutineScope.async {
            httpClient.post(mapOf("id" to id))
//            }
        }
    }
}