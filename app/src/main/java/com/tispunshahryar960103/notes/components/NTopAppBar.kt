package com.tispunshahryar960103.notes.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NTopAppBar(onInfoClicked:()->Unit,onNavIconClicked:()->Unit) {

  TopAppBar(title = { SearchField{
    // todo : search operation must be implemented
  } },
    modifier = Modifier.fillMaxWidth(),
    actions = { IconButton(onClick = { onInfoClicked() }) {
      Icon(imageVector = Icons.Default.Info, contentDescription = "Info Icon")
    }},
    navigationIcon = {
      IconButton(onClick = { onNavIconClicked() }) {
      Icon(imageVector = Icons.Default.Menu, contentDescription = "menu icon")
    }},
    backgroundColor = Color.LightGray,
    contentColor = Color.White,
    elevation = 5.dp
    )


}