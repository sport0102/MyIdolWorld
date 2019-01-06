package com.myidolworld.aiden.myidolworld.util

import android.content.res.AssetManager
import android.graphics.Typeface

var type_face: Typeface? = null
fun initializeTypeFace(assets: AssetManager) {
    type_face = Typeface.createFromAsset(assets, "fonts/main_font.ttf")
}
