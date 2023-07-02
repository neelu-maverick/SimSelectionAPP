package com.example.recyclerwithbottomsheet.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.recyclerwithbottomsheet.databinding.ActivityMainBinding
import com.example.recyclerwithbottomsheet.mainfragmentsheet.MainFragment
import com.example.recyclerwithbottomsheet.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //add fragment to activity
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frame_container, MainFragment())
        transaction.commit()

    }

}