package com.example.secretcommunicationdevice.layout

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.secretcommunicationdevice.services.ReactiveService

@Composable
fun TopBar() {
    TopAppBar()
    {
        val value by ReactiveService.formTitle.collectAsState()
        Text(text = value)
    }

}