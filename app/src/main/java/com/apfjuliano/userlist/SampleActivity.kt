package com.apfjuliano.userlist

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class SampleActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample_layout)

        val ivProfile = findViewById<ImageView>(R.id.iv_profile)
        val tvName = findViewById<TextView>(R.id.tv_name)
        val url = "https://github.com/julianojcs.png"

        Glide.with(this)
            .load(url)
            .apply(RequestOptions().circleCrop())
            .into(ivProfile)

        tvName.text = getString(R.string.profile_name)
    }
}