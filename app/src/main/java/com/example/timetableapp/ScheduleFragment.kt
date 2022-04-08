package com.example.timetableapp


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI

import com.example.timetableapp.databinding.FragmentScheduleBinding




class ScheduleFragment : Fragment() {

    //reference to the ItemViewModel
    private lateinit var  viewModel: ItemViewModel
    lateinit var binding: FragmentScheduleBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }


    var classList:MutableList<MyClass> = mutableListOf<MyClass>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        addClasses()
        printClassInfo()

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentScheduleBinding>(inflater,
            R.layout.fragment_schedule,container,false)

        //** For ViewModel**//
        Log.i("ScheduleFragment", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        //When a button is clicked: These steps happen
        //Step 1: Get reference to the button
        val btnMon1 = binding.mon1
        //Step 2: Call the clickHandlerFunction
        btnMon1.setOnClickListener{view : View ->
            clickHandlerFunction(view)
            //view.findNavController().navigate(R.id.action_scheduleFragment_to_addFragment)
        }

        //Logic for ViewModel
        //val dataReceived = viewModel!!.selectedItem.value
        return binding.root
        //return inflater.inflate(R.layout.placeholder_layout, container, false)
    }

    private fun clickHandlerFunction( view:View)
    {
        view.findNavController().navigate(R.id.action_scheduleFragment_to_addFragment)
    }

    //This clickHandler handles the onClick functionality for the buttons
//    private fun clickHandlerFunction(btn: Button)
//    {
//
//        val btn = findViewById<Button>(R.id.mon1)
//        btn.text = classList[0].csciName  + "\n" +classList[0].classTime
//        val size = btn.textSize
//        btn.setTextSize(size-53)
//        val grayColorValue = Color.GRAY
//        btn.setBackgroundColor(grayColorValue)
//
//        1. Display the screen for dropdown menu/Add Fragment
//        view = view.findNavController().navigate(R.id.action_scheduleFragment_to_addFragment)
//
//    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment ScheduleFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            ScheduleFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }

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