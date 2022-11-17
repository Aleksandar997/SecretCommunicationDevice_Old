package com.example.secretcommunicationdevice.http

import com.example.secretcommunicationdevice.models.Response
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class HttpClient(url: String) {
    private var _url: URL

    init {
        _url = URL(url)
    }

    suspend fun post(body: Map<String, String>): Response {
        val response = StringBuffer()
        try {
            var reqParam = ""
            body.keys.forEach {
                reqParam = URLEncoder.encode(it, "UTF-8") + "=" + URLEncoder.encode(
                    body.getValue(it),
                    "UTF-8"
                )
            }


            with(_url.openConnection() as HttpURLConnection) {
                requestMethod = "POST"
                setRequestProperty("Content-Type", "application/json")
                val wr = outputStream.writer()
                wr.write(reqParam);
                wr.flush();

                BufferedReader(InputStreamReader(inputStream)).use {
                    var inputLine = it.readLine()
                    while (inputLine != null) {
                        response.append(inputLine)
                        inputLine = it.readLine()
                    }
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return Response(true)
    }
}
