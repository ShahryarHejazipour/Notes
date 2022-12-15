package com.tispunshahryar960103.notes.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings

object MenuItemList {

    val menuItemList = listOf(
        MenuItem(item = "home", icon = Icons.Default.Home),
        MenuItem(item = "setting", icon = Icons.Default.Settings),
        MenuItem(item = "exit", icon = Icons.Default.ExitToApp)
    )
}