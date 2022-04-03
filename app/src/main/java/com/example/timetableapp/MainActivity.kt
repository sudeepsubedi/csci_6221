package com.example.timetableapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
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

        addClasses()
        printClassInfo()

        //When a button is clicked: These steps happen
        //Step 1: Get reference to the button
        val btnMon1 = binding.mon1
        //Step 2: Call the clickHandlerFunction
        btnMon1.setOnClickListener { clickHandlerFunction(btnMon1) }
    }

    //This clickHandler handles the onClick functionality for the buttons
    private fun clickHandlerFunction(btn: Button)
    {
        //val btn = findViewById<Button>(R.id.mon1)
        btn.text = classList[0].csciName  + "\n" +classList[0].classTime
        val size = btn.textSize
        btn.setTextSize(size-53)
        val grayColorValue = Color.GRAY
        btn.setBackgroundColor(grayColorValue)
        //1. Display the screen for dropdown menu
    }

    fun addClasses()
    {
        val firstClass = MyClass(
            "CSCI 6101",
            "Introduction to Computer Science Fundamentals",
            "3.0",
            "Shaban, H",
            "TOMP 406",
            "Wednesday",
            "06:10pm-08:40pm"
        )
        val secondClass = MyClass(
            "CSCI 6212",
            "Design and Analysis of Algorithm",
            "3.0",
            "Youssef, A",
            "Not assigned",
            "Friday",
            "09:30am-12:00pm"
        )

        val thirdClass= MyClass(
            "CSCI 6221",
            "Advanced Software Paradigms",
            "3.0",
            "Melo, W",
            "FNGR 208",
            "Thursday",
            "06:10pm-08:40pm"
        )

        val fourthClass = MyClass(
            "CSCI 6232",
            "Software Engineering",
            "3.0",
            "Kaisler, S",
            "COR 204",
            "Monday",
            "12:45pm-02:00pm"
        )

        val fifthClass = MyClass(
            "CSCI 6231",
            "Cryptography",
            "3.0",
            "Yerukhimovich, A",
            "COR 204",
            "Monday",
            "12:45pm-02:00pm"
        )

        classList.add(firstClass)
        classList.add(secondClass)
        classList.add(thirdClass)
        classList.add(fourthClass)
        classList.add(fifthClass)
    }

    fun printClassInfo()
    {
        for (myClass in classList) {
            myClass.printInfo()
        }
    }
}