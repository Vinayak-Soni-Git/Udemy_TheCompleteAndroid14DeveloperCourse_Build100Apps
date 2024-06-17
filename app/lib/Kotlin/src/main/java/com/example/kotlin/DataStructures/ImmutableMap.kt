package com.example.kotlin.DataStructures

fun main(){
    val fruits = mapOf("Apple" to 5, "Banana" to 8, "Cherry" to 12)
    
    val quantityOfBanana = fruits["Banana"]
    
    println(quantityOfBanana)
}