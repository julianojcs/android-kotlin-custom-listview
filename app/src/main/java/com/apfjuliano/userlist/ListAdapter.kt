package com.apfjuliano.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListAdapter(private val users: MutableList<User>): BaseAdapter() {
    override fun getCount(): Int {
        return users.count()
    }

    override fun getItem(position: Int): Any {
        return users[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val view = layoutInflater.inflate(R.layout.user_item, parent, false)

        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvAge = view.findViewById<TextView>(R.id.tvAge)
        val tvId = view.findViewById<TextView>(R.id.tvId)

        tvName.text = users[position].name
        tvAge.text = users[position].age.toString()
        tvId.text = users[position].id.toString()

        return view
    }
}