package com.example.simselection

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.simselection.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //add fragment to activity
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frame_container, MainFragment())
        transaction.commit()

    }

    override fun onBackPressed() {
            super.onBackPressed()
        }

}