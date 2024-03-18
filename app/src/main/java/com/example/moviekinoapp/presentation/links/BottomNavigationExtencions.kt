package com.example.moviekinoapp.presentation.links

import android.app.Activity
import android.view.View
import com.example.moviekinoapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

fun Activity.hideBottomNavigation() {
    this.findViewById<BottomNavigationView?>(R.id.bottomNavigationView).visibility =
        View.GONE
}

fun Activity.showBottomNavigation() {
    this.findViewById<BottomNavigationView?>(R.id.bottomNavigationView).visibility =
        View.VISIBLE
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}