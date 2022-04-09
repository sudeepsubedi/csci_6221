package com.example.timetableapp

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel:ViewModel() {
    var className:String = ""
    var addedClassName:String = ""
    private val mutabaleSelectedItem = MutableLiveData<String>()
    var classList:MutableList<MyClass> = mutableListOf<MyClass>()
    //Buttons clicked are put in this list
    var chosenClasses:MutableList<String> = mutableListOf<String>()
    var chosenClassObjects:MutableList<MyClass> = mutableListOf<MyClass>()

    var addSuccess:Boolean = true
    var removalSuccess:Boolean = true


    fun setData(item:String)
    {
        mutabaleSelectedItem.value=item
    }

    val selectedItem:LiveData<String> get()=mutabaleSelectedItem

    init
    {
        Log.i("ItemViewModel", "ItemViewModel created")
        //addClasses()
        //printClassInfo()
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

    /**
     * This function adds the class into the list of objects
     */
    fun addToChosenObjects(csci:String)
    {
        for(myClass in classList)
        {
            val myClassName = myClass.csciName
            if(myClassName==(csci))
            {
                val conflictResult:Boolean = timeConflicts(myClass)
                //make sure that it doesn't conflict with another class already added
                if(conflictResult)
                {
                    addSuccess = false
                }

                else
                {
                    chosenClassObjects.add(myClass)
                }

            }
        }
    }

    /**
     * This function checks if the time conflicts for the class
     */
    fun timeConflicts(myClass:MyClass):Boolean
    {
        var result:Boolean = false
        for(item in chosenClassObjects)
        {
            if(item.day== myClass.day && (item.startTime==myClass.startTime && item.endTime==myClass.endTime))
            {
                result = true
            }
        }
        return result
    }

    /**
     * This function removes class if it already present in the chosenClass and also removes from the ChosenObjects if present
     */
    fun removeClass(className:String)
    {
        if(chosenClasses.size > 0)
        {
            val contains:Boolean = chosenClasses.contains(className)
            if(contains)
            {
                chosenClasses.remove(className)
                //Remove from the ChosenObects too
                removeFromChosenObjects(className)
                removalSuccess = true
            }

            else
            {
                removalSuccess = false
            }
        }

        else
        {
            removalSuccess = false
        }

    }

    private fun removeFromChosenObjects(className: String)
    {
        var objectForRemoval: MyClass? = null
        var removeObject:Boolean = false
        for(item in chosenClassObjects)
        {
            if(chosenClassObjects.size > 0 && item.csciName == className)
            {
                objectForRemoval = item
                removeObject = true
            }
        }

        if(removeObject)
        {
            chosenClassObjects.remove(objectForRemoval)
        }
    }


}