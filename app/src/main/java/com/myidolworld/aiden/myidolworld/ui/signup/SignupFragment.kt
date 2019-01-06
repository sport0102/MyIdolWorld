package com.myidolworld.aiden.myidolworld.ui.signup

import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.myidolworld.aiden.myidolworld.R
import android.widget.ArrayAdapter
import com.myidolworld.aiden.myidolworld.util.point_color
import kotlinx.android.synthetic.main.fragment_signup.*


class SignupFragment : Fragment() {

    companion object {
        fun newInstance() = SignupFragment()
    }

    private lateinit var viewModel: SignupViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SignupViewModel::class.java)
        setLayout()
        setSpinner()

    }

    private fun setLayout() {
        fragment_signup_btn_signup.setBackgroundColor(point_color!!)
        fragment_signup_btn_signup.setTextColor(Color.WHITE)
    }

    private fun setSpinner() {
        fragment_signup_spn_messenger.attachDataSource(viewModel.messengerArray)
    }


}
