package com.example.kotlin.CodingExercises

import java.util.Scanner

fun main(){
    val scanner = Scanner(System.`in`)
    
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val c = scanner.nextInt()
    
    if (a>b){
        if (a>b){
            println(a)
        }
    }
    if (b>a){
        if (b>c){
            println(b)
        }
    }
    if (c>a){
        if (c>b){
            println(c)
        }
    }
}