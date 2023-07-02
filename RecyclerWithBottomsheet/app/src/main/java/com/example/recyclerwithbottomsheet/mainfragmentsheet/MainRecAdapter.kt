package com.example.recyclerwithbottomsheet.mainfragmentsheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerwithbottomsheet.R

class MainRecAdapter(val detailData: List<MainRecDataModel>) :
    RecyclerView.Adapter<MainRecAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_main, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.radius_tv.text = detailData.get(position).strRadius
        holder.name_tv.text = detailData.get(position).strName
        holder.detail_tv.text = detailData.get(position).strDetail
    }

    override fun getItemCount(): Int {
        return detailData.size
    }

    class MyViewHolder( view: View) : RecyclerView.ViewHolder(view) {
        val radius_tv = view.findViewById<TextView>(R.id.tv_radius)
        val name_tv = view.findViewById<TextView>(R.id.tv_name)
        val detail_tv = view.findViewById<TextView>(R.id.tv_detail)
    }
}
