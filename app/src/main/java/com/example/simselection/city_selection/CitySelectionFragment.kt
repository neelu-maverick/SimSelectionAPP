package com.example.simselection.city_selection

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simselection.R
import com.example.simselection.databinding.FragmentCitySelectionBinding

class CitySelectionFragment : Fragment() {

    private lateinit var citySelectionBinding: FragmentCitySelectionBinding
    val cityList: ArrayList<City_DataModel> = ArrayList()
    private lateinit var cAdapter: CityAdapter
    private lateinit var showClick: String
    private lateinit var activity: AppCompatActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        citySelectionBinding = FragmentCitySelectionBinding.inflate(inflater, container, false)

        return citySelectionBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity = getActivity() as AppCompatActivity
        activity.setSupportActionBar(citySelectionBinding.toolbar)
        activity.supportActionBar?.setTitle("Select City")

        citySelectionBinding.toolbar.setNavigationIcon(R.drawable.arrow_back)
        citySelectionBinding.toolbar.setNavigationOnClickListener {
            getActivity()?.onBackPressed()
        }

        initRecyclerView()
        showCityList()

        citySelectionBinding.buttonSort.setOnClickListener {
            Toast.makeText(context, "$showClick is selected", Toast.LENGTH_SHORT).show()
            sortCityByList()

        }
    }

    private fun sortCityByList(){
        val options = arrayOf("A to Z","Z to A")

        val dialog = AlertDialog.Builder(requireContext())
        dialog.setTitle("Sort")
            .setItems(options){ dialogInterface, i->
            if(i == 0){
                dialogInterface.dismiss()
                sortAscending()
            } else if(i == 1){
                dialogInterface.dismiss()
                sortDescending()
            }
        }.show()
    }

    private fun sortAscending(){
        cityList.sortBy { it.city }
        cAdapter.notifyDataSetChanged()
    }

    private fun sortDescending(){
        cityList.sortByDescending { it.city }
        cAdapter.notifyDataSetChanged()

    }


    private fun showCityList() {
        cityList.add(City_DataModel("Lucknow"))
        cityList.add(City_DataModel("Kanpur"))
        cityList.add(City_DataModel("Varanasi"))
        cityList.add(City_DataModel("Indore"))
        cityList.add(City_DataModel("Bhopal"))
        cityList.add(City_DataModel("New Delhi"))
        cityList.add(City_DataModel("Allahabad"))
        cityList.add(City_DataModel("Jaipur"))
        cityList.add(City_DataModel("Jodhpur"))
        cityList.add(City_DataModel("Kolkata"))
        cityList.add(City_DataModel("Siliguri"))
        cityList.add(City_DataModel("Agartala"))
        cityList.add(City_DataModel("Sri Nagar"))
        cityList.add(City_DataModel("Mumbai"))
        cityList.add(City_DataModel("Hyderabad"))

    }

    private val initCallBack = object : OnClickInterface {
        override fun onClick(s: City_DataModel) {
            showClick = s.city
            Log.e("TAG", s.city)
        }
    }


    private fun initRecyclerView() {

        cAdapter = CityAdapter(cityList)
        cAdapter.setCallBack(initCallBack)

        citySelectionBinding.recyclerview.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = cAdapter
        }

    }
}