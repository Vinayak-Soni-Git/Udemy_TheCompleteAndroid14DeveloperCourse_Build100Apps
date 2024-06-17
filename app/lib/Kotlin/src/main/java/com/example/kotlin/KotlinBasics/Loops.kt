package com.example.kotlin.KotlinBasics

fun main(){
    // For Loop
    for (i in 1..5){
        println(i)
    }
    
    // While Loop
    var count = 0
    while (count < 5){
        println(count)
        count++
    }
    
    // Do While Loop
    var x = 1
    do {
        println("this will be printed at least once")
        x++
    } while (x < 0)
    
}