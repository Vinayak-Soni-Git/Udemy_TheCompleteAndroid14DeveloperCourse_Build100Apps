package com.example.kotlin.KotlinBasics

fun main(){
    // if statement
    
    val age = 30
    if (age > 18){
        println("You are an adult")
    }else {
        println("You are not an adult")
    }
    
    // When Expression
    
    val day = "Monday"
    when (day) {
        "Monday" -> println("Today is Monday")
        "Tuesday" -> println("Today is Tuesday")
        else -> println("Today is not Monday or Tuesday")
    }
}