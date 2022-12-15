package com.tispunshahryar960103.notes.screens.noteListScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tispunshahryar960103.notes.model.Note

@Composable
fun NoteItemList(note: Note) {
    Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(8.dp), elevation = 4.dp) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(
            start = 15.dp,
            end = 15.dp,
            top = 10.dp,
            bottom = 10.dp
        )) {

            Text(text = note.subject, style = TextStyle(fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = note.text, maxLines = 1, overflow = TextOverflow.Ellipsis)

            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Text(text = note.time)
                Spacer(modifier = Modifier.width(30.dp))
                Text(text = note.date)
            }

        }
    }
}