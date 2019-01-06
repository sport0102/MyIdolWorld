package com.myidolworld.aiden.myidolworld.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myidolworld.aiden.myidolworld.R
import com.myidolworld.aiden.myidolworld.SignupActivity
import com.myidolworld.aiden.myidolworld.ui.signup.SignupFragment
import com.myidolworld.aiden.myidolworld.util.replaceFragment
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.concurrent.fixedRateTimer


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(com.myidolworld.aiden.myidolworld.R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        fragment_main_btn_signup.setOnClickListener {
            startActivity(Intent(context, SignupActivity::class.java))
        }
    }

}
