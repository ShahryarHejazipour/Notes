package com.tispunshahryar960103.notes.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun NButton(text:String = "", color: Color = Color.Blue, onClick:()->Unit = {}) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .width(100.dp)
            .width(80.dp)
          , shape = CircleShape
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

    }
}