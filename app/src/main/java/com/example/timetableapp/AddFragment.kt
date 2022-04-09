package com.example.timetableapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.timetableapp.databinding.FragmentAddBinding



class AddFragment: Fragment() {
    var name:String = ""
    val args:AddFragmentArgs by navArgs()

    var counter:Int = 0;

    //link to the viewModel
    private val viewModel:ItemViewModel by activityViewModels()

    init
    {
        Log.i("AddFragement", "Add Fragment is called")
    }

    //lateinit var binding:FragmentAddBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding:FragmentAddBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add,
            container,
            false)
        //When a button is clicked: These steps happen
        //Step 1: Get reference to the button

        val myScore = args.score
        val class1Btn = binding.class1
        val class2Btn = binding.class2
        val class3Btn = binding.class3
        val class4Btn = binding.class4
        val class5Btn = binding.class5
        val doneBtn = binding.doneButton


        //Step 2: Call the clickHandlerFunction
        class1Btn.setOnClickListener{view : View ->
            viewModel.chosenClasses.add(class1Btn.text.toString())
            viewModel.addToChosenObjects(class1Btn.text.toString())

        }

        //Step 2: Call the clickHandlerFunction
        class2Btn.setOnClickListener{view : View ->
                //add classes to the listOfChosenClasses
                viewModel.chosenClasses.add(class2Btn.text.toString())
                viewModel.addToChosenObjects(class2Btn.text.toString())
        }

        class3Btn.setOnClickListener{view : View ->
            //add classes to the listOfChosenClasses
            viewModel.chosenClasses.add(class3Btn.text.toString())
            viewModel.addToChosenObjects(class3Btn.text.toString())
        }

        class4Btn.setOnClickListener{view : View ->
            //add classes to the listOfChosenClasses
            viewModel.chosenClasses.add(class4Btn.text.toString())
            viewModel.addToChosenObjects(class4Btn.text.toString())
            if(!viewModel.addSuccess)
            {
                Toast.makeText(activity, "Time conflict with another class", Toast.LENGTH_SHORT).show()
            }
        }

        class5Btn.setOnClickListener{view : View ->
            //add classes to the listOfChosenClasses
            viewModel.chosenClasses.add(class5Btn.text.toString())
            viewModel.addToChosenObjects(class5Btn.text.toString())

            if(!viewModel.addSuccess)
            {
                Toast.makeText(activity, "Time conflict with another class", Toast.LENGTH_SHORT).show()
            }
        }

        doneBtn.setOnClickListener{view : View ->
                //Navigate to the timetable
                clickHandlerFunction(view,doneBtn)
        }

        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_add, container, false)
    }

    private fun clickHandlerFunction( view:View, btn:Button)
    {

//        val myClass1 = viewModel.chosenClasses[0]
//        Log.i("AddFragment", "Class1 Name: $myClass1")
//        if(viewModel.chosenClasses.size > 1)
//        {
//            val myClass2 = viewModel.chosenClasses[1]
//            Log.i("AddFragment", "Class2 Name: $myClass2")
//        }
//
//        for(item in viewModel.chosenClassObjects)
//        {
//            Log.i("AddFragment","${item.className}")
//        }
//        Toast.makeText(activity, "Added Class: $myClass1",Toast.LENGTH_SHORT).show()
        val currentScore = 10
        val action = AddFragmentDirections.actionAddFragmentToScheduleFragment(currentScore)

        //view.findNavController().navigate(R.id.action_scheduleFragment_to_addFragment)
        view.findNavController().navigate(action)
    }
}