package com.apfjuliano.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    val userList: List<User>
): RecyclerView.Adapter<RecyclerViewAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.user_item,
            parent,
            false
        )
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.count()
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    inner class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val tvName: TextView = view.findViewById(R.id.tvName)
        private val tvAge: TextView = view.findViewById(R.id.tvAge)
        private val tvId: TextView = view.findViewById(R.id.tvId)

        fun bind(user: User) {
            tvName.text = "name: ${user.name}"
            tvAge.text = "Age: ${user.age}yo"
            tvId.text = "ID: ${user.id}"
        }
    }
}