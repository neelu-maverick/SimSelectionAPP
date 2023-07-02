package com.example.recyclerwithbottomsheet.mainfragmentsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerwithbottomsheet.R
import com.example.recyclerwithbottomsheet.bottomsheet.BottomSheetDataModel
import com.example.recyclerwithbottomsheet.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var fragmentMainBinding: FragmentMainBinding
    private lateinit var mainRecAdapter: MainRecAdapter
    private val detailData: ArrayList<MainRecDataModel> = ArrayList()
    private var bottomSheetDataModel = BottomSheetDataModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment

        fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)
        return fragmentMainBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        showDataInMainRecyclerView()
        getCurrentSortedList()

        fragmentMainBinding.btnShowBottomSheet.setOnClickListener {
//            val bDialog = MainBottomFragment()
//            bDialog.show(
//                parentFragmentManager,
//                "ModalBottomSheet"
//            )
            Navigation.findNavController(fragmentMainBinding.root)
                .navigate(R.id.action_mainFragment_to_mainBottomFragment)
        }
    }

    private fun initRecyclerView() {
        mainRecAdapter = MainRecAdapter(detailData)
        fragmentMainBinding.mainRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mainRecAdapter

        }
    }

    private fun showDataInMainRecyclerView() {
        detailData.add(MainRecDataModel("7 KM",
            "Red Fort",
            "Famous for Fort made by red stones"))
        detailData.add(MainRecDataModel("1 KM",
            "Taj Mahal",
            "Famous for White marble stones"))
        detailData.add(MainRecDataModel("5 KM",
            "Chandani Chowk",
            "Famous for shopping markets "))
        detailData.add(MainRecDataModel("9 KM",
            "Cannaught Place",
            "Famous for expensive shopping complex markets"))
        detailData.add(MainRecDataModel("4 KM",
            "RML Hospital",
            "Delhi's famous hospital for everything"))
        detailData.add(MainRecDataModel("8 KM",
            "Qutub Minar",
            "Famous for tallest minaret in India"))
        detailData.add(MainRecDataModel("10 KM",
            "Varanasi",
            "Famous for Ganga ghats and paan, tea etc."))
        detailData.add(MainRecDataModel("2 KM",
            "Indira Point",
            "Famous as it is last point of India"))
        detailData.add(MainRecDataModel("3 KM",
            "Lotus Temple",
            "Famous for its beautiful architecture"))
        detailData.add(MainRecDataModel("6 KM",
            "India Gate",
            "Famous for triumphal arch & war memorial"))

    }

    private fun getCurrentSortedList() {
        findNavController().currentBackStackEntry?.savedStateHandle?.let { holder ->
            holder.getLiveData<BottomSheetDataModel>("key")
                .observe(viewLifecycleOwner) { res ->
                    bottomSheetDataModel = res
                }

        }
    }
}