package com.example.kotlin.KotlinBasics

fun main(){
    for (i in 1..10){
        if (i == 5){
            break;
        }
        println(i)
    }
    
    for (i in 1..10){
        if ((i % 2) == 0){
            continue
        }
        println(i)
    }
}