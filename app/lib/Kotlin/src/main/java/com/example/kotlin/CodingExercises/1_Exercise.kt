package com.example.kotlin.CodingExercises

import java.util.Scanner

fun main(){
    var scanner = Scanner(System.`in`)
    
    var x = scanner.nextInt()
    var y = scanner.nextInt()
    
    var result = x/y
    var remainder = x%y
    
    println("$result, $remainder")
    
}