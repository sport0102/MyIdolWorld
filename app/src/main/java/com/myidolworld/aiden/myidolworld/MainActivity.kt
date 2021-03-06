package com.myidolworld.aiden.myidolworld

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.myidolworld.aiden.myidolworld.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, MainFragment.newInstance())
                .commitNow()
        }

    }

}
