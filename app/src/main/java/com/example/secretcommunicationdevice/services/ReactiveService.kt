package com.example.secretcommunicationdevice.services

import kotlinx.coroutines.flow.MutableStateFlow

class ReactiveService {
    companion object {
        var formTitle = MutableStateFlow("")
    }
}