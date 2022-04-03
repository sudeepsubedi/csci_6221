package com.example.timetableapp

import android.util.Log

class MyClass(
    val _csciName:String,
    val _className:String,
    val _creditHours:String,
    val _professorInfo:String,
    val _classLocation:String,
    val _classDay:String,
    val _classTime:String
)
{
    var csciName:String = _csciName
    var className:String = _className
    var creditHours:String = _creditHours
    var professorInfo:String = _professorInfo
    var classLocation:String = _classLocation
    var day:String = _classDay
    var classTime:String = _classTime

    init
    {
        println("Created the MyClass object")
    }
    fun printInfo()
    {
        println()
        //Log.i("Name of class: ", className)
        println("CSCI Name: $csciName")
        println("Name of class: $className")
        println("Number of creditHours: $creditHours")
        println("ProfessorInfo: $professorInfo")
        println("Class Location: $classLocation")
        println("Day: $day")
        println("Class Time: $classTime")
        println()
        println("==============")
    }



}