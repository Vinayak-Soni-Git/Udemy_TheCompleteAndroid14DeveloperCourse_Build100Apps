package com.example.kotlin.KotlinBasics

fun main(){
    val range = 1..5
    
    // Half open range
    val range2 = 1 until 5
    
    // Iterating through a specific range
    for (i in range2){
        println(i)
    }
}