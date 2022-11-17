package com.example.secretcommunicationdevice.layout

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.secretcommunicationdevice.models.BottomNavItem
import com.example.secretcommunicationdevice.services.ReactiveService
import androidx.compose.material.*

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Templates,
        BottomNavItem.Communicate,
        BottomNavItem.Peers
    )
    BottomNavigation(
//        backgroundColor = colorResource(id = R.color.teal_200),
//        contentColor = Color.Black
    ) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(imageVector = item.icon, item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
//                selectedContentColor = Color.Black,
//                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    ReactiveService.formTitle.value = item.title
                    navController.navigate(item.screen_route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
