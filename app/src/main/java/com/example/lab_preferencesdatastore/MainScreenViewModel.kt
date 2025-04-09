package com.example.lab_preferencesdatastore

import android.app.Application
import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/**
 * View Model Class -> for Main Screen
 */
class MainScreenViewModel(application: Application) : AndroidViewModel(application){

    private val myPreferences: MyPreferences

    var backColorStateFlow : StateFlow<Long> = MutableStateFlow<Long>(0xFFFFFF00)
        private set


    init {
        val context: Context = getApplication<Application>().applicationContext
        myPreferences = MyPreferences(context)
        backColorStateFlow =
            myPreferences.watchBackColor().stateIn(viewModelScope, SharingStarted.Lazily, 0X0000FF00) as StateFlow<Long>
    }

    fun setBackColor(newColor: Long) {
        viewModelScope.launch {
            myPreferences.updateBackColor(newColor)
        }
    }

}