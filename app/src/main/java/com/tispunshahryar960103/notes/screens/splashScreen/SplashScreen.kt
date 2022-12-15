package com.tispunshahryar960103.notes.screens.splashScreen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Note
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tispunshahryar960103.notes.navigation.NoteScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    val noteScaleState = remember{
        Animatable(0f)
    }

    LaunchedEffect(key1 = true){
        noteScaleState.animateTo(targetValue = 0.9f, animationSpec = tween(durationMillis = 900, easing = {
            OvershootInterpolator(8f).getInterpolation(it)
        }))

        delay(2000)

        //todo : handling this feature below
        val isLoggedIn = true
        if (isLoggedIn){

            navController.navigate(NoteScreens.NoteListScreen.name)

        }else{

            navController.navigate(NoteScreens.NoteScreen.name)

        }


    }



    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colors.background,
                shape = CircleShape)
            .scale(noteScaleState.value),
        border = BorderStroke(width = 1.dp, color = Color.Green),
        elevation = 5.dp
    ) {

        Image(imageVector = Icons.Default.Note, contentDescription = "note icon")

    }

}