package com.myidolworld.aiden.myidolworld.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

fun replaceFragment(fm: FragmentManager, frameeLayout: Int, fragment: Fragment) {
    val fragmentTransaction = fm.beginTransaction()
    fragmentTransaction.replace(frameeLayout, fragment)
    fragmentTransaction.addToBackStack(null)
    fragmentTransaction.commit()
}