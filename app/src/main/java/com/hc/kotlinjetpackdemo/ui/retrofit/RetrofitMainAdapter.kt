package com.hc.kotlinjetpackdemo.ui.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hc.kotlinjetpackdemo.R
import com.hc.kotlinjetpackdemo.data.model.User

/**
 * @Author: wanghaichao
 * @Date: 2023/4/20
 * @Description:
 * @Copyright: all rights reserved.
 */
class RetrofitMainAdapter (private val users: ArrayList<User>) : RecyclerView.Adapter<RetrofitMainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {
            itemView.apply {
                findViewById<TextView>(R.id.textViewUserName).text = user.userName
                findViewById<TextView>(R.id.textViewUserEmail).text = user.userEmail
                Glide.with(context)
                    .load(user.image)
                    .into( findViewById<ImageView>(R.id.imageViewAvatar))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addUsers(users: List<User>) {
        this.users.apply {
            clear()
            addAll(users)
        }

    }
}
