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
        val btnClicked = binding.class1

        val class2Btn = binding.class2

        val doneBtn = binding.doneButton


        //Step 2: Call the clickHandlerFunction
        btnClicked.setOnClickListener{view : View ->
            viewModel.chosenClasses.add(btnClicked.text.toString())
            viewModel.addToChosenObjects(btnClicked.text.toString())

        }

        //Step 2: Call the clickHandlerFunction
        class2Btn.setOnClickListener{view : View ->
                //add classes to the listOfChosenClasses
                viewModel.chosenClasses.add(class2Btn.text.toString())
                viewModel.addToChosenObjects(class2Btn.text.toString())
        }

        doneBtn.setOnClickListener{view : View ->
                //Navigate to the timetable
                clickHandlerFunction(view,btnClicked)
        }

        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_add, container, false)
    }

    private fun clickHandlerFunction( view:View, btn:Button)
    {

        val myClass1 = viewModel.chosenClasses[0]
        Log.i("AddFragment", "Class1 Name: $myClass1")
        if(viewModel.chosenClasses.size > 1)
        {
            val myClass2 = viewModel.chosenClasses[1]
            Log.i("AddFragment", "Class2 Name: $myClass2")
        }

        for(item in viewModel.chosenClassObjects)
        {
            Log.i("AddFragment","${item.className}")
        }
        val currentScore = 10
        val action = AddFragmentDirections.actionAddFragmentToScheduleFragment(currentScore)
        Toast.makeText(activity, "Added Class: $myClass1",Toast.LENGTH_SHORT).show()
        //view.findNavController().navigate(R.id.action_scheduleFragment_to_addFragment)
        view.findNavController().navigate(action)
    }
}