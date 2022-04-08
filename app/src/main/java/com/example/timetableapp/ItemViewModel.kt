package com.example.timetableapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel:ViewModel() {
    private val mutabaleSelectedItem = MutableLiveData<String>()

    fun setData(item:String)
    {
        mutabaleSelectedItem.value=item
    }

    val selectedItem:LiveData<String> get()=mutabaleSelectedItem

    init
    {
        Log.i("ItemViewModel", "ItemViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ItemViewModel","ItemViewModel destroyed!!!")
    }


}