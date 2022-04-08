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
import androidx.navigation.fragment.navArgs
import com.example.timetableapp.databinding.FragmentAddBinding



class AddFragment: Fragment() {
    var name:String = ""
    val args:AddFragmentArgs by navArgs()


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
        //Step 2: Call the clickHandlerFunction
        btnClicked.setOnClickListener{view : View ->
            Toast.makeText(activity, "Score passed is: $myScore",Toast.LENGTH_SHORT).show()
            clickHandlerFunction(view,btnClicked)

        }

        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_add, container, false)
    }

    fun clickHandlerFunction(view:View, btn: Button)
    {
        val btnName = btn.text.toString()
        Log.i("AddFragment Button", "${btn.text.toString()} Clicked")


    }
}