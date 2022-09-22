package com.apfjuliano.userlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        //Dados
        val userList = mutableListOf<User>()
        for (i in 10..30) {
            userList.add(
                User(
                    id = i,
                    name = "Recicler${i+100}",
                    age = 20 + i
                )
            )
        }

        //RecyclerView + Item
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = RecyclerViewAdapter(userList)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}