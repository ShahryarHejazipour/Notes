package com.tispunshahryar960103.notes.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchField(onSearch:(String)->Unit) {

    val searchQuery = rememberSaveable {
        mutableStateOf("")
    }

    val valid = remember(searchQuery.value){
        searchQuery.value.trim().isNotEmpty()
    }

    val keyboardActions = LocalSoftwareKeyboardController.current

    NInputField(
        valueState = searchQuery,
        placeHolder = {  },
        label = "search",
        keyboardActions = KeyboardActions {
            if (!valid) return@KeyboardActions
            onSearch(searchQuery.value)
            searchQuery.value = ""
            keyboardActions?.hide()


        }
    ){
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
        }
    }

}