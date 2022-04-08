package com.example.timetableapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel:ViewModel() {
    private val mutabaleSelectedItem = MutableLiveData<String>()
    var classList:MutableList<MyClass> = mutableListOf<MyClass>()

    fun setData(item:String)
    {
        mutabaleSelectedItem.value=item
    }

    val selectedItem:LiveData<String> get()=mutabaleSelectedItem

    init
    {
        Log.i("ItemViewModel", "ItemViewModel created")
        addClasses()
        printClassInfo()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ItemViewModel","ItemViewModel destroyed!!!")
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
            "1810",
            "2040"
        )
        val secondClass = MyClass(
            "CSCI 6212",
            "Design and Analysis of Algorithm",
            "3.0",
            "Youssef, A",
            "Not assigned",
            "Friday",
            "0930",
            "1200"
        )

        val thirdClass= MyClass(
            "CSCI 6221",
            "Advanced Software Paradigms",
            "3.0",
            "Melo, W",
            "FNGR 208",
            "Thursday",
            "1810",
            "2040"
        )

        val fourthClass = MyClass(
            "CSCI 6232",
            "Software Engineering",
            "3.0",
            "Kaisler, S",
            "COR 204",
            "Monday",
            "1245",
            "1400"
        )

        val fifthClass = MyClass(
            "CSCI 6231",
            "Cryptography",
            "3.0",
            "Yerukhimovich, A",
            "COR 204",
            "Monday",
            "1245",
            "1400"
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