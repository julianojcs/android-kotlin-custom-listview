package com.apfjuliano.userlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

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