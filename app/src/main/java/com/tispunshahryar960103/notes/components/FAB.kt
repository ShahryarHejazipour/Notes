package com.tispunshahryar960103.notes.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.FloatingActionButtonElevation
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Note
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun FAB(onFABClicked:()->Unit) {
    FloatingActionButton(
        onClick = { onFABClicked() },
        interactionSource = MutableInteractionSource(),
        shape = RectangleShape,
    ) {
        Icon(imageVector = Icons.Default.Note, contentDescription = "add note icon")
    }
}