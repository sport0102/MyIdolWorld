package com.myidolworld.aiden.myidolworld.util

import android.graphics.Color
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

var point_color: Int? = null
var server_check: Boolean? = null

fun FirebaseRemoteConfigInitialize() {
    var config = FirebaseRemoteConfig.getInstance()
    point_color = Color.parseColor(config.getString("point_color"))
    server_check = config.getBoolean("server_check")
}