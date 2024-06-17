package com.example.kotlin.DataStructures

fun main(){
    val vegetables = mutableListOf("carrots", "peas", "spinach")
    vegetables.add("Potato")
    println(vegetables)
    
    vegetables.removeAt(0)
    
    vegetables[0] = "Tomato"
    
    vegetables.forEach { println(it) }
}