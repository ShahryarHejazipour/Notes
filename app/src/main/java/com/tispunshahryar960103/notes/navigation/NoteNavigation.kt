package com.tispunshahryar960103.notes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tispunshahryar960103.notes.screens.loginScreen.LoginScreen
import com.tispunshahryar960103.notes.screens.noteListScreen.NoteListScreen
import com.tispunshahryar960103.notes.screens.noteScreen.NoteScreen
import com.tispunshahryar960103.notes.screens.signupScreen.SignupScreen
import com.tispunshahryar960103.notes.screens.splashScreen.SplashScreen

@Composable
fun NoteNavigation() {

    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = NoteScreens.SplashScreen.name){

        composable(NoteScreens.SplashScreen.name){
            SplashScreen(navController = navController)
        }


        composable(NoteScreens.NoteListScreen.name){
            NoteListScreen(navController = navController)
        }

        composable(NoteScreens.NoteScreen.name){
           NoteScreen(navController = navController)

        }
        composable(NoteScreens.LoginScreen.name){
            LoginScreen(navController = navController)
        }

        composable(NoteScreens.SignupScreen.name){
            SignupScreen(navController = navController)
        }



    }

}