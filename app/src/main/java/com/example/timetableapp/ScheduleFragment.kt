package com.example.timetableapp


import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI

import com.example.timetableapp.databinding.FragmentScheduleBinding


class ScheduleFragment : Fragment() {

    //reference to the ItemViewModel
    private  val  viewModel: ItemViewModel by activityViewModels()
//    private lateinit var  viewModel: ItemViewModel
    lateinit var binding: FragmentScheduleBinding
    private var viewModelCounter:Int = 0;
    val args:ScheduleFragmentArgs by navArgs()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("ShceduleFragment","Schedule Fragment is called")
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentScheduleBinding>(inflater,
            R.layout.fragment_schedule,container,false)

        //update this fragment's content
        var size = 0
        for(item in viewModel.chosenClassObjects)
        {
            Log.i("ScheduleFragment","${item.csciName}")
            size++
            var startTime:Int = item.startTime.toInt()
            var endTime:Int = item.endTime.toInt()
            var day:String = item.day.toLowerCase()
            if(day == "wednesday")
            {
                //val btnMon1 = binding.wed1
                lateinit var btn: Button
                if(startTime < 1200)
                {
                    //btn 1
                    btn = binding.mon1
                }

                else if(startTime>=1200 && endTime< 1600)
                {
                    //btn2
                    btn = binding.mon2
                }

                else
                {
                    //btn3
                    btn = binding.mon3
                }
                btn.text = item.csciName + "\n" + item.startTime + ":"+item.endTime
                btn.setBackgroundColor(Color.LTGRAY)
            }

            else if(day == "friday")
            {
                lateinit var btn: Button
                if(startTime < 1200)
                {
                    //btn 1
                    btn = binding.fri1
                }

                else if(startTime>=1200 && endTime< 1600)
                {
                    //btn2
                    btn = binding.fri2
                }

                else
                {
                    //btn3
                    btn = binding.fri3
                }

                btn.text = item.csciName + "\n" + item.startTime + ":" + item.endTime
                btn.setBackgroundColor(Color.LTGRAY)
            }
        }
        Log.i("ScheduleFragment","Size is: $size")

        /**
         * if(viewModelCounter == 0)
        {
        //** For ViewModel**//
        Log.i("ScheduleFragment", "Called ViewModelProvider.get")
        //viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        viewModelCounter++
        }


        //When a button is clicked: These steps happen
        //Step 1: Get reference to the button
        val btnMon1 = binding.mon1
        val myClass = viewModel.className
        Log.i("ScheduleFragment", "Class Name: $myClass")
        //btnMon1.text = viewModel.className

        //Step 2: Call the clickHandlerFunction
        btnMon1.setOnClickListener{view : View ->
        clickHandlerFunction(view,btnMon1)
        btnMon1.text = viewModel.className
        }

        val btnMon2 = binding.mon2
        btnMon2.setOnClickListener { view:View->
        clickHandlerFunction(view,btnMon2)
        }


         */

        //Logic for ViewModel
        //val dataReceived = viewModel!!.selectedItem.value
        return binding.root
        //return inflater.inflate(R.layout.placeholder_layout, container, false)
    }

    /**
     * Method for handling button click handlers
     */
    private fun clickHandlerFunction( view:View, btn:Button)
    {

        val addedClassName = viewModel.className
        val action = ScheduleFragmentDirections.actionScheduleFragmentToAddFragment(addedClassName)


        //view.findNavController().navigate(R.id.action_scheduleFragment_to_addFragment)
        view.findNavController().navigate(action)
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


}