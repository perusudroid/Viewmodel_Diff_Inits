package com.perusu.vm_pro.features.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.perusu.vm_pro.R
import kotlinx.android.synthetic.main.inflater_items.view.*

class ListAdapter(val itemList: List<String>, val onItemClicked: (Int) -> Unit) :
    RecyclerView.Adapter<ListAdapter.VH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(R.layout.inflater_items, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.rootLay.setOnClickListener {
                onItemClicked(adapterPosition)
            }
        }

        fun bind(user: String) {
            with(itemView) {
                tvName.text = user
                tvDescription.text = when (adapterPosition) {
                    0 -> "Usual way of obtaining ViewModel"
                    1 -> "Share data between views"
                    2 -> "Obtaining ViewModel using extension"
                    3 -> "Observe Flow Emitted data"
                    else -> ""
                }
            }
        }

    }
}