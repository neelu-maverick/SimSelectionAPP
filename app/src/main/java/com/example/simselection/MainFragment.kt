package com.example.simselection

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.simselection.builder_pattern.BuilderDesignFragment
import com.example.simselection.city_selection.CitySelectionFragment
import com.example.simselection.databinding.FragmentMainBinding
import com.example.simselection.settings.SettingsFragment
import com.example.simselection.sim_selection.SimSelectionFragment
import com.example.simselection.sorting.SortingFragment


class MainFragment : Fragment() {

    private lateinit var activity: AppCompatActivity
    private lateinit var fragmentBinding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        fragmentBinding =
            FragmentMainBinding.inflate(inflater, container, false)
        showDialog()
        return fragmentBinding.root
    }


    private fun showDialog() {
        val statusDialog = BuilderDesignFragment.Builder()
            .setBackground(R.drawable.status_dialog_success)
            .setTitle(getString(R.string.success))
            .setIcon(R.drawable.ic_check)
            .setDescription(getString(R.string.description))
            .build()
        Log.d("tag", "Show")

        statusDialog.isCancelable = false
        statusDialog.show(parentFragmentManager, null)
        statusDialog.dismiss()

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity = getActivity() as AppCompatActivity
        activity.setSupportActionBar(fragmentBinding.toolbar)
        activity.supportActionBar?.setTitle("Go to Next")

        fragmentBinding.btnSelectSim.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_container, SimSelectionFragment())
            fragmentTransaction.addToBackStack("null")
            fragmentTransaction.commit()

        }

        fragmentBinding.btnSelectItems.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_container, CitySelectionFragment())
            fragmentTransaction.addToBackStack("null")
            fragmentTransaction.commit()

        }

        fragmentBinding.btnSettings.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_container, SettingsFragment())
            fragmentTransaction.addToBackStack("null")
            fragmentTransaction.commit()
        }

        fragmentBinding.btnBuilder.setOnClickListener {

            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            val frag = BuilderDesignFragment((BuilderDesignFragment.Builder()))
            frag.show(fragmentTransaction, "txn_tag")
            fragmentTransaction.addToBackStack("null")
            showDialog()
            Log.d("tag", "Hello")
        }

        fragmentBinding.btnSorting.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_container, SortingFragment())
            fragmentTransaction.addToBackStack("null")
            fragmentTransaction.commit()
        }
    }

}
