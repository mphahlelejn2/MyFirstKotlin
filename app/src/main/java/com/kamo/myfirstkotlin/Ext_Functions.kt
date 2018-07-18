package com.kamo.myfirstkotlin

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity


fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int){
    supportFragmentManager
            .beginTransaction()
            .add(frameId, fragment)
            .commit()
}

