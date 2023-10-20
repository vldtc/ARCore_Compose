package com.example.arcore_compose.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun MainScreen(){
    Box (modifier = Modifier.fillMaxSize()){
        val currentModel = remember{
            mutableStateOf("burger")
        }
        ARPreview(currentModel.value)
        Menu(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 16.dp)){
            currentModel.value = it
        }
    }
}