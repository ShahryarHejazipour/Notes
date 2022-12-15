package com.tispunshahryar960103.notes.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun NInputField(
    modifier: Modifier = Modifier,
    valueState:MutableState<String>,
    enabled:Boolean = true,
    label : String = "",
    placeHolder : @Composable () -> Unit,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine : Boolean = true,
    triangleIcon : @Composable () -> Unit = {}
) {



    OutlinedTextField(
        modifier = modifier.padding(top = 5.dp, bottom = 5.dp),
        value = valueState.value,
        onValueChange = { valueState.value = it },
        enabled = enabled,
        label = { Text(text = label )},
        placeholder = placeHolder,
        shape = RoundedCornerShape(8.dp),
        singleLine = singleLine,
        keyboardActions = keyboardActions,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
        trailingIcon = triangleIcon
    )


}