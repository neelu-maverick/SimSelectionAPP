package com.example.simselection.sorting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simselection.databinding.BottomSheetDialogBinding
import com.example.simselection.databinding.FragmentSortingBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class SortingFragment : Fragment() {

    private lateinit var sortingBinding: FragmentSortingBinding
    private val detailList: ArrayList<Sort_DataModel> = ArrayList()
    private lateinit var soringAdapter: SortAdapter

    lateinit var bottomSheetDialog: BottomSheetDialog
    private lateinit var bottomSheetDialogBinding: BottomSheetDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        sortingBinding = FragmentSortingBinding.inflate(inflater, container, false)

        bottomSheetDialogBinding = BottomSheetDialogBinding.inflate(inflater,container, false)

        return sortingBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        addPersonalData()
        soringAdapter.submitList(detailList)

        sortingBinding.buttonSort.setOnClickListener {
            showSortedData()

        }
    }

    private fun initRecyclerView() {
        soringAdapter = SortAdapter()
        sortingBinding.recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = soringAdapter

        }
    }

    private fun addPersonalData() {
        detailList.add(Sort_DataModel("Isabelle",
            "Ringing",
            24, 25000, "25/06/1994"))
        detailList.add(Sort_DataModel("Augusta",
            "Wind",
            37, 30000, "12/03/1994"))
        detailList.add(Sort_DataModel("Anita",
            "Bath",
            35, 23000, "13/06/1995"))
        detailList.add(Sort_DataModel("Paige",
            "Turner",
            54, 15000, "14/07/1994"))
        detailList.add(Sort_DataModel("Ivana",
            "LetterBack",
            21, 18000, "21/03/2022"))
        detailList.add(Sort_DataModel("Wes",
            "Yabinlatelee",
            27, 16000, "25/06/2022"))
        detailList.add(Sort_DataModel("Col",
            "Fays",
            20, 20000, "30/04/2022"))
        detailList.add(Sort_DataModel("Greg",
            "Arias",
            18, 18000, "01/01/2022"))
        detailList.add(Sort_DataModel("Simon",
            "Sias",
            28, 21000, "11/10/2021"))
        detailList.add(Sort_DataModel("Polly ",
            "Undawair",
            26, 28000, "13/05/2021"))
        detailList.add(Sort_DataModel("Oscar",
            "Nommanee",
            42, 29000, "24/05/2022"))
        detailList.add(Sort_DataModel("C.",
            "Yasson",
            32, 130000, "22/08/2021"))
        detailList.add(Sort_DataModel("Hope",
            "Homesoon",
            29, 100000, "28/07/2021"))
        detailList.add(Sort_DataModel("Ginger ",
            "Plant",
            28, 35000, "05/06/2022"))
        detailList.add(Sort_DataModel("Peter",
            "Owt",
            50, 40000, "15/05,2022"))
        detailList.add(Sort_DataModel("Rose",
            "Bush",
            19, 38000, "18/06/2022"))

    }

    private fun showSortedData() {

        bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(bottomSheetDialogBinding.root)
        bottomSheetDialog.show()

        bottomSheetDialogBinding.sortByNewDate.setOnClickListener {
            detailList.sortByDescending { it.date }
            soringAdapter.notifyDataSetChanged()
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialogBinding.sortByOldDate.setOnClickListener {
            detailList.sortBy { it.date }
            soringAdapter.notifyDataSetChanged()
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialogBinding.sortByHighAmount.setOnClickListener {
            detailList.sortByDescending { it.amount }
            soringAdapter.notifyDataSetChanged()
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialogBinding.sortByLowAmount.setOnClickListener {
            detailList.sortBy { it.amount }
            soringAdapter.notifyDataSetChanged()
            bottomSheetDialog.dismiss()

        }

    }


}