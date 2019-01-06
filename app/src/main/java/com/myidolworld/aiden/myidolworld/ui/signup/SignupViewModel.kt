package com.myidolworld.aiden.myidolworld.ui.signup

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import android.content.Context
import com.myidolworld.aiden.myidolworld.R
import kotlin.coroutines.coroutineContext

class SignupViewModel : ViewModel() {
    val messengerArray = arrayOf(
        "KAKAO",
        "LINE"
    ).asList()

}
