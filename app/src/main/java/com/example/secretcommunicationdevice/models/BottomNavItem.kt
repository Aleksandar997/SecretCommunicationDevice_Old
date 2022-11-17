package com.example.secretcommunicationdevice.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Quickreply
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title:String, var icon: ImageVector, var screen_route:String){

    object Templates : BottomNavItem("Templates", Icons.Default.LibraryBooks,"templates")
    object Communicate: BottomNavItem("Communicate",Icons.Default.Quickreply,"communicate")
    object Peers: BottomNavItem("Peers",Icons.Default.AccountTree,"peers")

}
