package com.apfjuliano.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) { // first time
            val layoutInflater = LayoutInflater.from(parent?.context)
            view = layoutInflater.inflate(R.layout.user_item, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        viewHolder.tvName.text = users[position].name
        viewHolder.tvAge.text = users[position].age.toString()
        viewHolder.tvId.text = users[position].id.toString()

        return view
    }
}

class ViewHolder(view: View) {
    val tvName: TextView
    val tvAge: TextView
    val tvId: TextView

    init {
        tvName = view.findViewById(R.id.tvName)
        tvAge = view.findViewById(R.id.tvAge)
        tvId = view.findViewById(R.id.tvId)
    }
}