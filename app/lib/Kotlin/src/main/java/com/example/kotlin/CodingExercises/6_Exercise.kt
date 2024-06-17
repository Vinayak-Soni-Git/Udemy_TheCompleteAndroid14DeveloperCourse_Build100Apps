package com.example.kotlin.CodingExercises

fun main(){
    var arr1 = arrayOf(1, 3, -5, 4)
    var arr2 = arrayOf(1, 4, -5, -2)
    var result = 0
    
    for (i in arr1.withIndex()){
        result += arr1[i.index] * arr2[i.index]
    }
}