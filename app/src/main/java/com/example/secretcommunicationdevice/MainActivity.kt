package com.example.secretcommunicationdevice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.secretcommunicationdevice.components.Communicate
import com.example.secretcommunicationdevice.components.Peers
import com.example.secretcommunicationdevice.components.Templates
import com.example.secretcommunicationdevice.layout.TopBar
import com.example.secretcommunicationdevice.layout.BottomNavigation
import com.example.secretcommunicationdevice.models.BottomNavItem
import com.example.secretcommunicationdevice.services.ReactiveService

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /* ... */ }) {
                /* FAB content */
            }
        },
        isFloatingActionButtonDocked = true,
        topBar = {TopBar()},
        bottomBar = {BottomNavigation(navController)}
    ) {
        NavigationGraph(navController)
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Communicate.screen_route) {
        ReactiveService.formTitle.value = BottomNavItem.Communicate.title
        composable(BottomNavItem.Communicate.screen_route) {
            Communicate()
        }
        composable(BottomNavItem.Templates.screen_route) {
            Templates()
        }
        composable(BottomNavItem.Peers.screen_route) {
            Peers()
        }
    }
}

