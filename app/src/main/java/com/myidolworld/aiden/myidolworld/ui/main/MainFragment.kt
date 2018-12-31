package com.myidolworld.aiden.myidolworld.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myidolworld.aiden.myidolworld.R
import com.myidolworld.aiden.myidolworld.ui.signup.SignupFragment
import com.myidolworld.aiden.myidolworld.util.replaceFragment
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(com.myidolworld.aiden.myidolworld.R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        fragment_main_btn_signup.setOnClickListener {
            replaceFragment(fragmentManager!!, R.id.main_container, SignupFragment())
        }
    }

}
