package com.example.kotlin.DataStructures

fun main(){
    val fruits = mutableSetOf("Apple", "Banana", "Orange")
    fruits.add("Grapes")
    fruits.add("Apple")
    
    for (item in fruits){
        println(item)
    }
    
    fruits.remove("Banana")
    
    println(fruits)
}