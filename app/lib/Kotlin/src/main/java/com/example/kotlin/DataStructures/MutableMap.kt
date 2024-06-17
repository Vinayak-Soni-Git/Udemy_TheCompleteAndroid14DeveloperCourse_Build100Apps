package com.example.kotlin.DataStructures

fun main(){
    val vegetablesWithPrice = mutableMapOf("potato" to 1.5, "tomato" to 3.5, "broccoli" to 6.0)
    vegetablesWithPrice["tomato"] = 4.0
    
    vegetablesWithPrice.put("garlic", 6.0)
    
    for ((key, value) in vegetablesWithPrice){
        println("Vegetable: $key, Price: $value")
    }
}