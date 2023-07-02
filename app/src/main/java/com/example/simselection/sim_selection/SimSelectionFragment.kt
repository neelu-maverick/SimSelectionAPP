package com.example.simselection.sim_selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.simselection.R
import com.example.simselection.databinding.FragmentSimSelectionBinding

class SimSelectionFragment : Fragment() {
    private lateinit var simSelectionBinding: FragmentSimSelectionBinding
    private lateinit var activity: AppCompatActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        simSelectionBinding = FragmentSimSelectionBinding.inflate(inflater, container, false)


        return simSelectionBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity = getActivity() as AppCompatActivity
        activity.setSupportActionBar(simSelectionBinding.toolbar)
        activity.supportActionBar?.setTitle("Select SIM")

        simSelectionBinding.toolbar.setNavigationIcon(R.drawable.arrow_back)
        simSelectionBinding.toolbar.setNavigationOnClickListener {
            getActivity()?.onBackPressed()
        }

        simSelectionBinding.rbSim1.setOnClickListener {
            simSelectionBinding.card1.setOnClickListener {

                simSelectionBinding.rbSim1.isChecked = true
                simSelectionBinding.rbSim2.isChecked = false
            }
        }

        simSelectionBinding.rbSim2.setOnClickListener {
            simSelectionBinding.card2.setOnClickListener {

                simSelectionBinding.rbSim1.isChecked = false
                simSelectionBinding.rbSim2.isChecked = true
            }
        }

        simSelectionBinding.btnProceed.setOnClickListener {
            if (simSelectionBinding.rbSim1.isChecked)
                Toast.makeText(context, "SIM 1 selected", Toast.LENGTH_SHORT).show()

            if (simSelectionBinding.rbSim2.isChecked)
                Toast.makeText(context, "SIM 2 selected", Toast.LENGTH_SHORT).show()
        }
    }


}

