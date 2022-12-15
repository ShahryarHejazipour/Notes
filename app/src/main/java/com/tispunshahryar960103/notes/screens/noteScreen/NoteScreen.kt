package com.tispunshahryar960103.notes.screens.noteScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tispunshahryar960103.notes.components.NButton
import com.tispunshahryar960103.notes.components.NInputField
import com.tispunshahryar960103.notes.components.showToast
import com.tispunshahryar960103.notes.model.Note
import com.tispunshahryar960103.notes.navigation.NoteScreens

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun NoteScreen(
    navController: NavController = NavController(LocalContext.current),
    noteViewModel: NoteViewModel = hiltViewModel(),
) {

    val subjectState = remember{
        mutableStateOf("")
    }

    val noteState = remember{
        mutableStateOf("")
    }


    val valid = remember(subjectState.value){
        subjectState.value.trim().isNotEmpty() || noteState.value.trim().isNotEmpty()
    }

    val scrollState = rememberScrollState()
    val context = LocalContext.current


    val keyboardController = LocalSoftwareKeyboardController.current

    Card(
        modifier = Modifier
            .fillMaxSize(),
        shape = RectangleShape
    ) {
        Column(
            modifier = Modifier.padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NInputField(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(state = scrollState)
                    .padding(start = 15.dp, end = 15.dp),
                valueState = subjectState,
                label = "Subject",
                placeHolder = {Text(text = "Enter Yor Subject...")},
                keyboardActions = KeyboardActions {
                    if (!valid) return@KeyboardActions
                }
            )
            Spacer(modifier = Modifier.height(15.dp))
            NInputField(
                valueState = noteState,
                singleLine = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .padding(start = 15.dp, end = 15.dp),
                label = "Your Note",
                placeHolder = { Row(verticalAlignment = Alignment.Top) {
                    Text(text = "Enter Your Note")
                }},
                keyboardActions = KeyboardActions {
                    if (!valid) return@KeyboardActions
                }
            )

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(10.dp)
            ) {
                NButton(text = "Save") {
                    // todo : save  in database operation
                    //showToast(context = context, message = "Save button clicked")
                    if (!valid){
                        showToast(context = context,"Please Enter a Subject and a Note")
                    } else{

                        // todo : saving operation
                        noteViewModel.insertNote(Note(2,subjectState.value,noteState.value,"12:25","1401/09/28"))


                        subjectState.value = ""
                        noteState.value = ""
                        keyboardController?.hide()
                        navController.navigate(NoteScreens.NoteListScreen.name)
                    }

                }
                Spacer(modifier = Modifier.width(80.dp))
                NButton(text = "Cancel") {

                    // todo : more customization
                  showToast(context = context, message = "Save button clicked")
                    subjectState.value = ""
                    noteState.value = ""
                    keyboardController?.hide()
                    navController.navigate(NoteScreens.NoteListScreen.name)

                }
            }
            Spacer(modifier = Modifier.height(30.dp))

            NButton(text = "Clear", color = Color.Red) {
                subjectState.value = ""
                noteState.value = ""
                keyboardController?.hide()
            }
        }

    }

}