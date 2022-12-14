/*
 * *
 *  * Created by Trinh Khac Hung on 9/8/22, 1:53 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/8/22, 1:53 PM
 *
 */

package com.bangcodin.calculator.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bangcodin.calculator.R
import com.bangcodin.calculator.data.models.History

class HistoryAdapter(val onclick: (history: History, position: Int) -> Unit) :
    RecyclerView.Adapter<HistoryAdapter.MyViewHolder>() {
    var items = mutableListOf<History>()


    fun setListData(data: MutableList<History>) {
        this.items = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_history, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val history = items[position]
        holder.img_showMenu.setOnClickListener {
            onclick(history,position)
        }
        holder.bind(items[position])

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_result = view.findViewById<TextView>(R.id.tv_Result_History)
        val tv_calculator = view.findViewById<TextView>(R.id.tv_Calculator_History)
        val tv_date_time = view.findViewById<TextView>(R.id.tv_date_time)
        val img_showMenu = view.findViewById<ImageButton>(R.id.img_ShowMenu)

        fun bind(data: History) {
            tv_result.text = data.result
            tv_calculator.text = data.calculator
            tv_date_time.text = data.dateTime
        }
    }

}