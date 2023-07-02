package com.example.simselection.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.simselection.R
import com.example.simselection.databinding.FragmentSettingsBinding

class SettingsFragment : DialogFragment() {


    private lateinit var settingsBinding: FragmentSettingsBinding
    private lateinit var activity: AppCompatActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        settingsBinding = FragmentSettingsBinding.inflate(inflater, container, false)


        return settingsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity = getActivity() as AppCompatActivity
        activity.setSupportActionBar(settingsBinding.toolbar)
        activity.supportActionBar?.setTitle("Settings")
        // (requireActivity() as MainActivity).onBackPressed()

        settingsBinding.toolbar.setNavigationIcon(R.drawable.arrow_back)
        settingsBinding.toolbar.setNavigationOnClickListener {
            getActivity()?.onBackPressed()
        }


        settingsBinding.pinBtn.setOnClickListener {
            Toast.makeText(context, "Data Updated", Toast.LENGTH_SHORT).show()
        }

        settingsBinding.accountBtn.setOnClickListener {
            var mDialogview =
                LayoutInflater.from(requireContext()).inflate(R.layout.dialog_layout, null)
          //  mDialogview?.setBackgroundResource(R.drawable.background_bg)
            val mBuilder = AlertDialog.Builder(requireContext()).setView(mDialogview)
            val mAlertDialog = mBuilder.show()

//
//            var mDialogview = DialogLayoutFragment()
//            getActivity()?.let { it1 ->
//                mDialogview.show(it1.supportFragmentManager,
//                    "customDialog")
//
//            }

        }
    }
}

