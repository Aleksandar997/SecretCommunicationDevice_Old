package com.example.secretcommunicationdevice.models

import com.google.gson.annotations.SerializedName

data class SentenceConfig(
    @SerializedName("startOfSentence") val startOfSentence: Long,
    @SerializedName("endOfWordPause") val endOfWordPause: Long,
    @SerializedName("betweenLettersPattern") val betweenLettersPattern: List<Long>
) {
}

data class Translation(
    @SerializedName("letterConfig") val letterConfig: Map<String, String>,
    @SerializedName("sentenceConfig") val sentenceConfig: SentenceConfig,
    @SerializedName("data") val data: Map<String, Array<String>>
) {

}
