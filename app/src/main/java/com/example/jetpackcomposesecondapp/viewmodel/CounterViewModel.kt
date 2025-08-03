package com.example.jetpackcomposesecondapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {

    //Internal mutable state
    private val _count = mutableStateOf(0)

    //External mutable state
    val count: State<Int> = _count

    fun increment(){
        _count.value ++
    }

    fun reset(){
        _count.value = 0
    }
}