package com.mohit.machinecoding.navigation

sealed class Routes(val routes : String) {

    object Home : Routes("home")
    object Detail : Routes("detail")

}