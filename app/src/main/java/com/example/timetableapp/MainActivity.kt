package com.example.timetableapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.timetableapp.databinding.ActivityMainBinding

//import com.example.timetableapp.MyClass as MyClass1

class MainActivity : AppCompatActivity()
{
    //private lateinit var binding:ActivityMainBinding
    private lateinit var binding: ActivityMainBinding
    var classList:MutableList<MyClass> = mutableListOf<MyClass>()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        val navController = this.findNavController(R.id.myNavHostFragment)
//        NavigationUI.setupActionBarWithNavController(this,navController)


//        addClasses()
//        printClassInfo()

        //uncomment these lines

//        //When a button is clicked: These steps happen
//        //Step 1: Get reference to the button
//        val btnMon1 = binding.mon1
//        //Step 2: Call the clickHandlerFunction
//        btnMon1.setOnClickListener { clickHandlerFunction(btnMon1) }
    }

    /**
     * This is for adding the back button
     */
    override fun onSupportNavigateUp():Boolean{
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }

    //This clickHandler handles the onClick functionality for the buttons
    private fun clickHandlerFunction(btn: Button)
    {
        //val btn = findViewById<Button>(R.id.mon1)
        btn.text = classList[0].csciName  + "\n" +classList[0].startTime + "-" + classList[0].endTime
        val size = btn.textSize
        btn.setTextSize(size-53)
        val grayColorValue = Color.GRAY
        btn.setBackgroundColor(grayColorValue)
        //1. Display the screen for dropdown menu
    }



}