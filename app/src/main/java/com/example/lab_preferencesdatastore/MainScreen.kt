package com.example.lab_preferencesdatastore

import android.app.Application
import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Main Screen function
 */
@Composable
fun MainScreen(modifier: Modifier){
    val context = LocalContext.current

    var viewModel = viewModel { MainScreenViewModel(context.applicationContext as Application) }

    //  backColor = yellow color
    val backColor = viewModel.backColorStateFlow.collectAsState().value

    // 0xFF00FFFF = cyan color

    Column(modifier.background(color = Color(backColor)).fillMaxSize()) {


        Text(text = "Lab - Preferences Datastore", fontSize = 25.sp )


        Button(onClick = { viewModel.setBackColor(0xFFFF0000)

        }) {
            Text("Red")
        }

        Button(onClick = { viewModel.setBackColor(0xFF00FF00)

        }) {
            Text("Green")
        }

    }

}