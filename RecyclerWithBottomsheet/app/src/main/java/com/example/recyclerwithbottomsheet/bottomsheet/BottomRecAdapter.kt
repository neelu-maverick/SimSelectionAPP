package com.example.recyclerwithbottomsheet.bottomsheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerwithbottomsheet.OnClickInterface
import com.example.recyclerwithbottomsheet.R

class BottomRecAdapter(val listData: List<BottomSheetDataModel>) :
    RecyclerView.Adapter<BottomRecAdapter.MyViewHolder>() {

    private var isItemClicked: OnClickInterface? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleTextView.text = listData[position].title
        if (position == 0){
            holder.titleTextView.isSelected = true
        }

        holder.titleTextView.setOnClickListener {
            isItemClicked?.onItemClicked(listData[position])
        }

    }

    override fun getItemCount(): Int {
        return listData.size
    }

    fun setCallBack(param: OnClickInterface) {
        isItemClicked = param
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val titleTextView: TextView = view.findViewById(R.id.titleTextview)

    }
}
