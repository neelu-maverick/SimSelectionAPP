package com.example.simselection.city_selection

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simselection.R

class CityAdapter(val cityList: List<City_DataModel>) :
    RecyclerView.Adapter<CityAdapter.MyViewHolder>() {
    private var checkPosition = -1
    private var isitemClick: OnClickInterface? = null
private lateinit var sortedList : ArrayList<City_DataModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.radio_item, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        @SuppressLint("RecyclerView") position: Int,
    ) {
        holder.citytextView.text = cityList.get(position).city
        holder.cityRadioBtn.isChecked = position == checkPosition

        holder.cityRadioBtn.setOnClickListener {

            cityList.get(position).isSelect = false
            checkPosition = holder.adapterPosition
            notifyDataSetChanged()

            isitemClick?.onClick(cityList.get(position))
        }
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    fun setCallBack(param: OnClickInterface) {
        isitemClick = param

    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val citytextView: TextView = view.findViewById(R.id.tv_city_name)
        val cityRadioBtn: RadioButton = view.findViewById(R.id.radio_btn)

    }
}

