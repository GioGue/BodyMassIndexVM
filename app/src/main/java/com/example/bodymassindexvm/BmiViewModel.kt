package com.example.bodymassindexvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class BmiViewModel: ViewModel(){
    var heightInput by  mutableStateOf("")
    var weightInput by mutableStateOf("")

    var height: Float = 0.0f
        get(){
            return heightInput.toFloatOrNull() ?: 0.0f
        }

    var weight: Float = 0.0f
        get(){
            return weightInput.toFloatOrNull() ?: 0.0f
        }

    fun changeHeightInput(value: String){
        heightInput = value.replace(',', '.')
    }

    fun changeWeightInput(value: String){
        weightInput = value.replace(',', '.')
    }

    //return the bmi result
    var bmiResult: Float = 0.0f
        get(){
            return calculateBmi()
        }

    //calculate the bmi value
    private fun calculateBmi(): Float{
        return if (weight > 0 && height > 0) (weight / (height * height)) else 0.0f
    }

}