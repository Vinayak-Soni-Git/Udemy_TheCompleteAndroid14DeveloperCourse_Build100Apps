package com.example.kotlin.CodingExercises

fun main(){
    var nums = arrayOf(5, 3, 2, 6, 8, 1)
    
    var evenNumbers = 0
    var oddNumbers = 0
    
    for (i in nums){
        if(i%2 == 0){
            evenNumbers++
        } else {
            oddNumbers++
        }
    }
    
    println("$evenNumbers even numbers, $oddNumbers odd numbers")
}