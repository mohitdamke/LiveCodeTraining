package com.mohit.machinecoding.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mohit.machinecoding.presentation.MainScreen

@Composable
fun NavigationGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Home.routes) {

        composable(Routes.Home.routes){
            MainScreen()
        }

    }












}