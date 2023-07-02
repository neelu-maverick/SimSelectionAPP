package com.example.recyclerwithbottomsheet.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerwithbottomsheet.OnClickInterface
import com.example.recyclerwithbottomsheet.databinding.FragmentMainBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MainBottomFragment : BottomSheetDialogFragment() {

    private lateinit var mAdapter: BottomRecAdapter
    private val listData: ArrayList<BottomSheetDataModel> = ArrayList()
    private lateinit var fragmentMainBottomBinding: FragmentMainBottomBinding
    //private lateinit var showClick: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        fragmentMainBottomBinding = FragmentMainBottomBinding.inflate(
            inflater,
            container,
            false
        )
        return fragmentMainBottomBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buildDisplayData()
        initRecyclerview()

        fragmentMainBottomBinding.btnClose.setOnClickListener {
            dismiss()
        }
    }

    private fun initRecyclerview() {

        mAdapter = BottomRecAdapter(listData)
        mAdapter.setCallBack(initCallBack)

        listData.sortBy { it.title }

        fragmentMainBottomBinding.recyclerview.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = mAdapter
        }
    }

    private fun buildDisplayData() {
        listData.add(BottomSheetDataModel("Sort By Date (Newest First)"))
        listData.add(BottomSheetDataModel("Sort By Date (Oldest First)"))
        listData.add(BottomSheetDataModel("Sort By Amount (Highest First)"))
        listData.add(BottomSheetDataModel("Sort By Amount (Lowest First)"))
    }

    private val initCallBack = object : OnClickInterface {
        override fun onItemClicked(s: BottomSheetDataModel) {
//            showClick = s.title
//            Log.e("TAG", s.title)
            Toast.makeText(context, "ItemClicked", Toast.LENGTH_SHORT).show()
            submitSortedData()
            //dismiss()
        }
    }

    private fun submitSortedData() {
        findNavController().apply {
            previousBackStackEntry?.savedStateHandle?.set<BottomSheetDataModel>("key",
                BottomSheetDataModel(
                ))
        }
        findNavController().popBackStack()
        dismiss()
    }
}
