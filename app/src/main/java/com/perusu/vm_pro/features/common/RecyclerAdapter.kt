package com.perusu.vm_pro.features.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.perusu.vm_pro.data.model.User
import com.perusu.vm_pro.R
import kotlinx.android.synthetic.main.inflater_users.view.*

class RecyclerAdapter(val userList: List<User>) : RecyclerView.Adapter<RecyclerAdapter.VH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(R.layout.inflater_users, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(user.profilePicutre)
                    .into(ivPic)
                tvName.text = user.name
                tvBio.text = user.bio
            }
        }

    }
}