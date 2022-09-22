package com.apfjuliano.userlist

import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

private const val PREF_EMAIL = "email"
private const val PREF_SMS = "sms"
private const val PREF_AGE = "age"
private const val PREF = "STORAGE_PREFERENCES" //Name of stored preferences

class SampleActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample_layout)

        val ivProfile = findViewById<ImageView>(R.id.iv_profile)
        val tvName = findViewById<TextView>(R.id.tv_name)
        val chkEmail = findViewById<CheckBox>(R.id.chkEmail)
        val chkSMS = findViewById<CheckBox>(R.id.chkSms)
        val edtAge = findViewById<EditText>(R.id.edtAge)
        val btnSave = findViewById<Button>(R.id.btnSave)

        val url = "https://github.com/julianojcs.png"

        Glide.with(this)
            .load(url)
            .apply(RequestOptions().circleCrop())
            .into(ivProfile)

        tvName.text = getString(R.string.profile_name)

        val preferences = getSharedPreferences(PREF, Context.MODE_PRIVATE)

        chkEmail.isChecked = preferences.getBoolean(PREF_EMAIL, false)
        chkSMS.isChecked = preferences.getBoolean(PREF_SMS, false)
        edtAge.setText(preferences.getInt(PREF_AGE, 0).toString())

        btnSave.setOnClickListener {
            val edit =preferences.edit()
            edit.putBoolean(PREF_EMAIL, chkEmail.isChecked)
            edit.putBoolean(PREF_SMS, chkSMS.isChecked)
            edit.putInt(PREF_AGE, edtAge.text.toString().toInt())
            edit.apply()
        }
    }
}