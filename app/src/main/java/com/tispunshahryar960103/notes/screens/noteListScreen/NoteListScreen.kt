package com.tispunshahryar960103.notes.screens.noteListScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.tispunshahryar960103.notes.components.FAB
import com.tispunshahryar960103.notes.components.NTopAppBar
import com.tispunshahryar960103.notes.components.showToast
import com.tispunshahryar960103.notes.model.MenuItem
import com.tispunshahryar960103.notes.model.MenuItemList
import com.tispunshahryar960103.notes.model.Note
import com.tispunshahryar960103.notes.model.NotesListDummyData
import com.tispunshahryar960103.notes.navigation.NoteScreens
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NoteListScreen(
    navController: NavController,
    notes: List<Note> = NotesListDummyData.notes,
    viewModel: NoteListViewModel = hiltViewModel(),
) {

    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { NTopAppBar(onInfoClicked = { showToast(context = context, message = "Info Icon Clicked!")}){
            scope.launch {

                scaffoldState.drawerState.open()
            }

        } },
        bottomBar = {},
        floatingActionButton = { FAB {
            //todo : FAB must be implemented
            showToast(context = context,"FAB clicked")
            navController.navigate(NoteScreens.NoteScreen.name)
        }},
        drawerContent = {
            NavHeader()
            Divider(thickness = 1.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(10.dp))
            NavBodyItems(items = MenuItemList.menuItemList)

        },
    ) {

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.padding(top = 15.dp, bottom = 15.dp),
            reverseLayout = true
        ){
            viewModel.data.value.data?.let { Notes ->
                items(Notes.toList()){ note ->
                    NoteItemList(note = note)
                }
            }
        }

    }

}

@Composable
fun NavHeader() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(color = Color.LightGray),
        contentAlignment = Alignment.CenterStart
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(start = 20.dp)) {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = "profile icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .background(
                        shape = CircleShape,
                        color = Color.Transparent
                    )
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            //todo : adding username here
            Text(text = "Username")
        }


    }
}

@Composable
fun NavBodyItems(items:List<MenuItem>) {

    val context = LocalContext.current

    LazyColumn(verticalArrangement = Arrangement.spacedBy(30.dp)){
        items(items){ item ->
            NavMenuItem(menuItem = item){
                //todo : implement item clicked

                showToast(context,"${item.item} Clicked")

            }
        }

    }

}

@Composable
fun NavMenuItem(menuItem: MenuItem,onItemClicked:()->Unit) {

    Row(modifier = Modifier.clickable { onItemClicked() }) {
        Icon(imageVector = menuItem.icon, contentDescription = "menu icon")
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = menuItem.item)
    }

}