package com.example.timetableapp

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.timetableapp.databinding.ActivityMainBinding
import com.example.timetableapp.databinding.FragmentScheduleBinding



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ScheduleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScheduleFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val binding = DataBindingUtil.inflate<FragmentScheduleBinding>(inflater,
            R.layout.fragment_schedule,container,false)

        //When a button is clicked: These steps happen
        //Step 1: Get reference to the button
        val btnMon1 = binding.mon1
        //Step 2: Call the clickHandlerFunction
        btnMon1.setOnClickListener { clickHandlerFunction(btnMon1) }
        return binding.root
        //return inflater.inflate(R.layout.placeholder_layout, container, false)
    }

    //This clickHandler handles the onClick functionality for the buttons
    private fun clickHandlerFunction(btn: Button)
    {
        //val btn = findViewById<Button>(R.id.mon1)
//        btn.text = classList[0].csciName  + "\n" +classList[0].classTime
//        val size = btn.textSize
//        btn.setTextSize(size-53)
//        val grayColorValue = Color.GRAY
//        btn.setBackgroundColor(grayColorValue)

        //1. Display the screen for dropdown menu

    }

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