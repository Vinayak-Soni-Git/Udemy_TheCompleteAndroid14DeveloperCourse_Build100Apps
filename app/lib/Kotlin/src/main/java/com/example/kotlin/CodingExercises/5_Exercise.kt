package com.example.kotlin.CodingExercises

import java.util.Scanner

fun main(){
    val scanner = Scanner(System.`in`)
    val letters = scanner.nextLine().toCharArray()
    
    var reverse = ""
    
    for (i in letters.size-1 downTo 0){
        reverse += letters[i]
    }
    
    println(reverse)
}