package com.myidolworld.aiden.myidolworld

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.myidolworld.aiden.myidolworld.ui.main.MainFragment
import com.myidolworld.aiden.myidolworld.ui.signup.SignupFragment

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.signup_container, SignupFragment.newInstance())
                .commitNow()
        }
    }
}
