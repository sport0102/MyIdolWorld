package com.myidolworld.aiden.myidolworld

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.shashank.sony.fancytoastlib.FancyToast
import android.graphics.Typeface
import com.myidolworld.aiden.myidolworld.util.*
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initialize()
        checkGooglePlayServices()
        remoteConfigInitialize()
    }

    private fun initialize() {
        initializeTypeFace(assets)
        splash_tv_logo.setTypeface(type_face)
        splash_tv_logo.setTextColor(Color.WHITE)
        splash_tv_logo.setBackgroundColor(Color.parseColor("#FA7268"))
    }

    private fun remoteConfigInitialize() {
        val remoteConfig = FirebaseRemoteConfig.getInstance()
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            // Debug일 때 Developer Mode를 enable 하여 캐쉬 설정을 변경한다.
            .setDeveloperModeEnabled(BuildConfig.DEBUG)
            .build()

        remoteConfig.setConfigSettings(configSettings)
        // 로컬 기본값을 저장한 xml을 설정한다.
        remoteConfig.setDefaults(R.xml.remote_config_defaults)

        // 기본 캐쉬 만료시간은 12시간이다. Developer Mode 여부에 따라 fetch()에 적설한 캐시 만료시간을 넘긴다.
        remoteConfig.fetch(0).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                remoteConfig.activateFetched()
                // 파이어베이스 변수들 초기화
                FirebaseRemoteConfigInitialize()
                // 서버 점검일 경우
                if (server_check == true) {
                    FancyToast.makeText(
                        this,
                        getString(R.string.splash_toast_server_check),
                        FancyToast.LENGTH_LONG,
                        FancyToast.ERROR,
                        false
                    )
                    return@addOnCompleteListener
                }
                // 3초 쉬고
                Thread.sleep(3000)
                // 메인 액티비티로 이동
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        }
    }

    private fun checkGooglePlayServices() {
        val googleApiAvailability = GoogleApiAvailability.getInstance()
        val status = googleApiAvailability.isGooglePlayServicesAvailable(this@SplashActivity)

        if (status != ConnectionResult.SUCCESS) {
            val dialog = googleApiAvailability.getErrorDialog(this@SplashActivity, status, -1)
            dialog.setOnDismissListener { dialogInterface -> finish() }
            dialog.show()

            googleApiAvailability.showErrorNotification(this@SplashActivity, status)
        }
    }
}
