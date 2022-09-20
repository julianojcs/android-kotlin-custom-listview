package com.apfjuliano.userlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userList = mutableListOf<User>()
        for (i in 1..20) {
            userList.add(
                User(
                    id = i,
                    name = "Name $i",
                    age = 30 + i
                )
            )
        }
        val listView = findViewById<ListView>(R.id.listViewUser)
        listView.adapter = ListAdapter(userList)

    }
}