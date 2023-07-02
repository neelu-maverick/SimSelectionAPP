package com.example.simselection.sorting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.simselection.databinding.PersonalDetailRowBinding

class SortAdapter : ListAdapter<Sort_DataModel, SortAdapter.SortViewHolder>(Diffutil()) {

    class Diffutil : DiffUtil.ItemCallback<Sort_DataModel>() {
        override fun areItemsTheSame(oldItem: Sort_DataModel, newItem: Sort_DataModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Sort_DataModel, newItem: Sort_DataModel): Boolean {
            return oldItem == newItem
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SortViewHolder {
        return SortViewHolder(
            PersonalDetailRowBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: SortViewHolder, position: Int) {
        PersonalDetailRowBinding.bind(holder.itemView).apply {
            tvFirstName.text = currentList[position].firstName
            tvLastName.text = currentList[position].lastName
            tvAge.text = currentList[position].age.toString()
            tvAmount.text = currentList[position].amount.toString()
            tvDate.text = currentList[position].date
        }
    }

    inner class SortViewHolder(binding: PersonalDetailRowBinding) :
        RecyclerView.ViewHolder(binding.root)
}